import java.util.Queue;

public class Printer {

    public void initialize(Queue<Player> list_of_players, Square[] list_of_squares, int board_size){
        System.out.println("");
        System.out.print("Initial State:"+"\t");
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

        //for (int i=1 ; i<=list_of_players.size() ; i++){
         //   Player player = list_of_players.remove();
         //   System.out.println(player.get_player_name() + player.get_player_number());
         //   list_of_players.add(player);
        //}
    }
}
