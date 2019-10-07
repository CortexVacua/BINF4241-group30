import java.util.*;

public class Game {
    protected Die die = new Die();
    public Printer printer = new Printer();
    public void game_flow(Gameboard gb){
        while (gb.list_of_squares[gb.board_size-1].isOccupied() == 0){
                int die_roll=die.roll_die();
//              prints the output of everyturn
                printer.dice_roll(die_roll,gb.list_of_players);
                printer.board_state(gb.list_of_players,gb.list_of_squares,gb.board_size);
                Player active_player= gb.list_of_players.remove();
                gb.list_of_squares[active_player.square_number-1].ChangeOccupiedState();
                int possible_square = active_player.square_number + die_roll;

//              active_player lands on final square
                if (possible_square == gb.board_size){
                    gb.list_of_squares[gb.board_size-1].ChangeOccupiedState();
                    active_player.change_sq_num(gb.board_size);
                    gb.list_of_players.add(active_player);
//                  prints the final statement output
                    printer.finalization();
                    printer.board_state(gb.list_of_players,gb.list_of_squares,gb.board_size);
                    printer.winner(gb.list_of_players,gb.board_size);
                    break;
                }

//              go backwards if you overshoot the last square
                if(possible_square > gb.board_size){
                    possible_square = gb.board_size - (possible_square-gb.board_size);
                }


//              check if snake/ladder and then modify possible_square to destination of snake/ladder
                if (gb.list_of_squares[possible_square-1].getClass() == Snake.class){
                    possible_square= ((Snake)gb.list_of_squares[possible_square-1]).points_to;
                }
                if (gb.list_of_squares[possible_square-1].getClass() == Ladder.class){
                    possible_square = ((Ladder)gb.list_of_squares[possible_square-1]).points_to;
                }

//              normal square occupied, player sent to first square
                if (gb.list_of_squares[possible_square-1].isOccupied() == 1) {
                    active_player.change_sq_num(1);
                }
//              normal square not occupied, player moves to destination
                else {
                    gb.list_of_squares[possible_square-1].ChangeOccupiedState();
                    active_player.change_sq_num(possible_square);
                }
                gb.list_of_players.add(active_player);
        }

    }
}


