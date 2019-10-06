public class Game {
    protected Die die = new Die();
    public void game_flow(Gameboard gb){
//        Output state
        while (gb.list_of_squares[gb.board_size-1].isOccupied() == 0){
                Player active_player= gb.list_of_players.remove();
                int die_roll=die.roll_die();
                int possible_square = active_player.square_number + die_roll;

//              active_player lands on final square
                if (possible_square == gb.board_size){
                    gb.list_of_squares[gb.board_size-1].ChangeOccupiedState();
                    gb.list_of_squares[active_player.square_number-1].ChangeOccupiedState();
                    active_player.change_sq_num(gb.board_size);

//                  Output state, plus text that active player has won
                }


                else if (possible_square < gb.board_size){
//                  check if snake/ladder and then modify possible_square to destination of snake/ladder
                    if (gb.list_of_squares[possible_square-1].getClass() == Snake.class || gb.list_of_squares[possible_square-1].getClass() == Ladder.class){
                        possible_square = gb.list_of_squares[possible_square-1].points_to;
                    }
//                  normal square occupied, player sent to first square
                    if (gb.list_of_squares[possible_square-1].isOccupied() == 1) {
                        gb.list_of_squares[active_player.square_number-1].ChangeOccupiedState();
                        active_player.change_sq_num(1);
//                      output state
                    }
//                  normal square not occupied, player moves to destination
                    else {
                        gb.list_of_squares[active_player.square_number-1].ChangeOccupiedState();
                        gb.list_of_squares[possible_square-1].ChangeOccupiedState();
                        active_player.change_sq_num(possible_square);
                    }
                    gb.list_of_players.add(active_player);
                }

        }
    }
}


