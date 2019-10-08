//implements the output of the game
import java.util.Queue;

public class Printer {

//  prints the initial state
    public void initialization(){
        System.out.println("");
        System.out.print("Initial State:"+"\t\t");
    }

//  prints the final state
    public void finalization(){
        System.out.print("Final state:"+"\t\t");
    }

//  prints the winner
    public void winner(Queue<Player> list_of_players, int board_size){
        for (int i=1 ; i<=list_of_players.size() ; i++){
            Player player = list_of_players.remove();
            if (player.get_player_number() == board_size){
                System.out.print(player.get_player_name() + " wins!");
            }
            list_of_players.add(player);
        }
    }

//  prints the rolled dice
    public void dice_roll(int die_roll, Queue<Player> list_of_players){
        Player player = list_of_players.remove();
        System.out.print(player.get_player_name() + " rolls " + die_roll + ":\t\t");
        // cycles the player list so the order is right (because players are removed and added into the linked list)
        // (and the list.addFirst() function doesn't work somehow...)
        for (int i=1 ; i<=list_of_players.size() ; i++){
            list_of_players.add(player);
            player = list_of_players.remove();
        }
        list_of_players.add(player);
    }

//  prints the current board state
    public void board_state(Queue<Player> list_of_players, Square[] list_of_squares, int board_size){
        for (int j=1 ; j<=board_size; j++){
            //prints squares
            System.out.print("[");
            //checks if the current square is a snake
            if (list_of_squares[j-1].getClass() == Snake.class){
                System.out.print(list_of_squares[j-1].get_square_number()-4);
                System.out.print("<-");
            }
            System.out.print(list_of_squares[j-1].get_square_number());
            //checks if any player is in square
            for (int i=1 ; i<=list_of_players.size() ; i++){
                Player player = list_of_players.remove();
                if (j == player.get_player_number()){
                    System.out.print("<"+player.get_player_name()+">");
                }
                list_of_players.add(player);
            }
            //checks if current square is a ladder
            if (list_of_squares[j-1].getClass() == Ladder.class){
                System.out.print("->");
                System.out.print(list_of_squares[j-1].get_square_number()+4);
            }
            System.out.print("]");
        }
        System.out.print("\n");
    }
}
