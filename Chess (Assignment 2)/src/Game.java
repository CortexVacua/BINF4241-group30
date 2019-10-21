import java.util.*;

public class Game {
    private Queue<Player> PlayerQueue = new LinkedList<>();
    private boolean GameOver = false;
    private AlgebraicNotation alg_not = new AlgebraicNotation();
    private List<Column> col = new ArrayList<>();
    private List<Row> rows = new ArrayList<>();

    public Game() {
//        initializes Columns and Rows list
        for (Column c : Column.values())
            col.add(c);
        for (Row r : Row.values())
            rows.add(r);
//        initializes Gameboard and Printer
        Gameboard gb1 = new Gameboard();
        Printer printer = new Printer();
//        initializes the players
        System.out.println("Please enter the first player's name (white): ");
        Scanner name_P1 = new Scanner(System.in);
        String name_P1_str = name_P1.nextLine();
        System.out.println("Please enter the second player's name (black): ");
        Scanner name_P2 = new Scanner(System.in);
        String name_P2_str = name_P1.nextLine();
        PlayerQueue.add(new Player(Color.WHITE, name_P1_str));
        PlayerQueue.add(new Player(Color.BLACK, name_P2_str));


        while (!GameOver) {
            Player current_player = PlayerQueue.remove();
            printer.board_state(gb1.Fields, gb1.Pieces);
            boolean notation_is_valid = false;
            boolean input_accepted = false;

//first checks if notation is a valid one then checks if move is legal
//            check if notation is valid
            while (notation_is_valid == false || input_accepted == false) {
                System.out.println(current_player.getName() + ", please enter your move in algebraic notation:");
                Scanner move = new Scanner(System.in);
                String move_str = move.nextLine();
                notation_is_valid = alg_not.check_notation(move_str);
                if (notation_is_valid == false) System.out.println("Please check your algebraic notation!");

//              check if move is legal
                else {
                    int[] field_param = alg_not.field_interpreter(move_str);
                    Column c = col.get(field_param[0]-1);
                    Row r = rows.get(field_param[1]-1);
                    Object what_figure= alg_not.getTypeOfFigure(move_str);
                    int possible_pieces = 0;
                    List<Piece> potential_pieces= new ArrayList<Piece>();
                    for (Piece p : gb1.Pieces) {
                        if (p.getColor() == current_player.getColor() && p.getClass() == what_figure
                                && p.isValid(gb1, c, r)) {
                            possible_pieces++;
                            potential_pieces.add(p);
                        }
                    }
                    if (possible_pieces ==0) System.out.println("Could not find "+what_figure+" that can move to desired field.");
                    else if (possible_pieces>1)  System.out.println("Too many"+what_figure+"s can move to the desired field, please satisfy further.");
                    else {
                        for (Field f : gb1.Fields){
                            if (f.getaRow()==potential_pieces.get(0).getRow() && f.getaColumn()== potential_pieces.get(0).getColumn()){
                                f.unoccupy();
                            }
                        }

                        for (Field f : gb1.Fields){
                            if (f.getaRow()==r && f.getaColumn()== c){
                                f.occupy();
                            }
                        }
                        potential_pieces.get(0).setPosition(c,r);
                        input_accepted=true;
                    }

                }
            }
            PlayerQueue.add(current_player);
        }
    }
}