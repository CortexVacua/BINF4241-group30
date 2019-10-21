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
            boolean input_legal = false;


//first checks if notation is a valid one then checks if move is legal
//            check if notation is valid
            while (notation_is_valid == false || input_legal == false) {
                boolean enemy_piece_on_field = false;
                System.out.println(current_player.getName() + ", please enter your move in algebraic notation:");
                Scanner move = new Scanner(System.in);
                String move_str = move.nextLine();
                notation_is_valid = alg_not.check_notation(move_str);
                if (notation_is_valid == false) System.out.println("Please check your algebraic notation!");


//              check if move is legal
                else {
                    int[] field_param = alg_not.field_interpreter(move_str);
                    int[] specifiers = alg_not.specifier(move_str);
                    int possible_pieces = 0;

                    List<Piece> potential_pieces= new ArrayList<Piece>();
                    Column c = col.get(field_param[0]-1);
                    Row r = rows.get(field_param[1]-1);
                    Object what_figure= alg_not.getTypeOfFigure(move_str);




//case without extra specifiers
                    if (specifiers[0]==9  & specifiers[1]==9){
                        for (Piece p : gb1.Pieces) {
                            if (p.getColor() == current_player.getColor() && p.getClass() == what_figure
                                    && p.isValid(gb1, c, r)) {
                                possible_pieces++;
                                potential_pieces.add(p);
                            }
                        }
                    }
//case with column as extra specifier
                    if (specifiers[0]!=9  & specifiers[1]==9){
                        for (Piece p : gb1.Pieces) {
                            if (p.getColor() == current_player.getColor() && p.getClass() == what_figure
                                    && p.isValid(gb1, c, r) && p.getColumn()==col.get(specifiers[0]-1)) {
                                possible_pieces++;
                                potential_pieces.add(p);
                            }
                        }
                    }

//case with row as extra specifier
                    if (specifiers[0]==9  & specifiers[1]!=9){
                        for (Piece p : gb1.Pieces) {
                            if (p.getColor() == current_player.getColor() && p.getClass() == what_figure
                                    && p.isValid(gb1, c, r) && p.getRow()==rows.get(specifiers[1]-1)) {
                                possible_pieces++;
                                potential_pieces.add(p);
                            }
                        }
                    }

//case with exact field of moving piece
                    if (specifiers[0]!=9  & specifiers[1]!=9){
                        for (Piece p : gb1.Pieces) {
                            if (p.getColor() == current_player.getColor() && p.getClass() == what_figure
                                    && p.isValid(gb1, c, r) && p.getColumn()==col.get(specifiers[0]-1)
                                    && p.getRow()==rows.get(specifiers[1]-1)) {
                                possible_pieces++;
                                potential_pieces.add(p);
                            }
                        }
                    }

                    for (Piece p : gb1.Pieces) {
                        if (p.getRow()== r && p.getColumn()== c && p.getColor()!=current_player.getColor()){
                            enemy_piece_on_field=true;
                        }
                    }
                    if (enemy_piece_on_field && !move_str.contains("x")) System.out.println("You are attacking a figure without having declared a capture. " +
                            "\nPlease check your algebraic notation.\n");
                    else if (possible_pieces ==0) System.out.println("Could not find "+what_figure+" that can move to desired field.");
                    else if (possible_pieces>1)  System.out.println("Too many "+what_figure+"s can move to the desired field, please specify further.");

//                   if move is legal, completes the move
                    else {

//                  unoccupies previous field
                        for (Field f : gb1.Fields){
                            if (f.getaRow()==potential_pieces.get(0).getRow() && f.getaColumn()== potential_pieces.get(0).getColumn()){
                                f.unoccupy();
                            }
                        }
//                  removes captured piece from the field
                        if (enemy_piece_on_field){
                            for (Piece p : gb1.Pieces) {
                                if (p.getRow()== r && p.getColumn()== c && p.getColor()!=current_player.getColor()){
                                    Piece dead_piece = gb1.Pieces.remove(gb1.Pieces.indexOf(p));
                                    current_player.add_captures(dead_piece);
                                }
                            }
                        }
//                  occupies new field
                        for (Field f : gb1.Fields){
                            if (f.getaRow()==r && f.getaColumn()== c){
                                f.occupy();
                            }
                        }
                        potential_pieces.get(0).setPosition(c,r);

                        input_legal=true;

                    }

                }
            }
            PlayerQueue.add(current_player);
        }
    }
}