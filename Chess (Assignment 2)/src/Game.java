import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Game {
    private Queue<Player> PlayerQueue = new LinkedList<>();
    private boolean GameOver = false;

    public Game(){
//        initializes Gameboard and Printer
        Gameboard gb1 = new Gameboard();
        Printer printer = new Printer();
//        initializes the players
        System.out.println("Please enter the first player's name (white): ");
        Scanner name_P1 = new Scanner (System.in);
        String name_P1_str = name_P1.nextLine();
        System.out.println("Please enter the second player's name (black): ");
        Scanner name_P2 = new Scanner (System.in);
        String name_P2_str = name_P1.nextLine();
        PlayerQueue.add(new Player(Color.WHITE, name_P1_str));
        PlayerQueue.add(new Player(Color.BLACK, name_P2_str));

        String move_from="";
        String move_to="";
        while (!GameOver){
            Player current_player= PlayerQueue.remove();
            printer.board_state(gb1.Fields, gb1.Pieces);
            while(move_from.length()<2 || move_to.length() < 2) {
                System.out.println(current_player.getName()+", please enter your move in algebraic notation:");
                Scanner move = new Scanner(System.in);
                String move_str = move.nextLine();
                if (move_str.indexOf(" ")>-1) {
                    String[] move_split = move_str.split(" ");
                    move_from = move_split[0];
                    move_to = move_split[1];
                }
                else {
                    System.out.println("incorrect notation");
                }

            }
        }

    }

}
