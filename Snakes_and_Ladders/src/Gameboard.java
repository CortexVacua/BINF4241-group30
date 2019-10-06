import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Gameboard {

    static Scanner input = new Scanner(System.in);
    static Queue<Player> list_of_players = new LinkedList<>();
    static int board_size;
    public static void init() {
        System.out.print("Enter the board size: ");
        board_size = input.nextInt();
        FirstSquare first = new FirstSquare();
        LastSquare last = new LastSquare();
        for (int i = 2; i < board_size; i+=5 ){


        }
        System.out.print("Enter the number of players (between 2 and 4): ");
        int number_of_players = input.nextInt();
        for (int i = 1; i <= number_of_players; i++) {
            System.out.print("Enter the name of Player " + i + ": ");
            String name = input.next();
            Player player = new Player(name, 1);
            list_of_players.add(player);
        }
    }

    public Queue<Player> getPlayers(){
        return list_of_players;
    }
    public int get_board_size(){
        return board_size;
    }

    public static void main(String[] args) {
        init();
        }
    }

