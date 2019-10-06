import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Gameboard {

    static Scanner input = new Scanner(System.in);
    static Queue<Player> list_of_players = new LinkedList<>();
    static int board_size;
    static Square[] list_of_squares;
    public static void init() {
        System.out.print("Enter the board size: ");
        board_size = input.nextInt();
        list_of_squares = new Square[board_size];
        FirstSquare first = new FirstSquare();
        list_of_squares[0] = first;
        LastSquare last = new LastSquare();
        list_of_squares[board_size -1] = last;
        for (int i = 3; i < board_size - 5; i+=5 ){
            Ladder ladder = new Ladder(i);
            list_of_squares[i-1] = ladder;
        }
        for (int i = 5; i < board_size - 2; i+=6 ) {
            if (list_of_squares[i - 1] == null) {
                Snake snake = new Snake(i);
                list_of_squares[i - 1] = snake;
            } else {
                Snake snake = new Snake(i+1);
                list_of_squares[i] = snake;
            }
        }
        for (int i = 2; i < board_size; i++) {
            if (list_of_squares[i - 1] == null) {
                Square square = new Square(i);
                list_of_squares[i - 1] = square;
            }
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
    public static int get_board_size(){
        return board_size;
    }

    public static void main(String[] args) {
        init();
        }
    }

