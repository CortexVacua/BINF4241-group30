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
            Player next_player = PlayerQueue.remove();
            printer.board_state(gb1.Fields, gb1.Pieces);
            Checkmate cm = new Checkmate();
            if (cm.checkmate(gb1, next_player)) {
                GameOver=true;
                break;
            }
            PlayerQueue.add(next_player);
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

//              Castling
                else if (move_str.equals("0-0")) {
                    if (current_player.getColor() == Color.BLACK) {
                        for (Piece piece : gb1.getPieces()) {
                            if (piece instanceof King && piece.getColor() == Color.BLACK) {
                                if (((King) piece).isShortCastlingValid(gb1)) {
                                    piece.setPosition(Column.G, Row.EIGHT);
                                    gb1.getPiece(Column.H, Row.EIGHT).setPosition(Column.F, Row.EIGHT);
                                    gb1.Fields.get(60).unoccupy();
                                    gb1.Fields.get(63).unoccupy();
                                    gb1.Fields.get(61).occupy();
                                    gb1.Fields.get(62).occupy();
                                    input_legal = true;
                                }
                            }
                        }
                    } else if (current_player.getColor() == Color.WHITE) {
                        for (Piece piece : gb1.getPieces()) {
                            if (piece instanceof King && piece.getColor() == Color.WHITE) {
                                if (((King) piece).isShortCastlingValid(gb1)) {
                                    piece.setPosition(Column.G, Row.ONE);
                                    gb1.getPiece(Column.H, Row.ONE).setPosition(Column.F, Row.ONE);
                                    gb1.Fields.get(4).unoccupy();
                                    gb1.Fields.get(7).unoccupy();
                                    gb1.Fields.get(5).occupy();
                                    gb1.Fields.get(6).occupy();
                                    input_legal = true;
                                }
                            }
                        }
                    }

                    if (input_legal==false) System.out.println("Castling illegal in given situation");
                }

                else if(move_str.equals("0-0-0")){
                    if (current_player.getColor()==Color.BLACK){
                        for (Piece piece : gb1.getPieces()) {
                            if (piece instanceof King && piece.getColor() == Color.BLACK) {
                                if (((King) piece).isLongCastlingValid(gb1)) {
                                            piece.setPosition(Column.C, Row.EIGHT);
                                            gb1.getPiece(Column.A, Row.EIGHT).setPosition(Column.D, Row.EIGHT);
                                            gb1.Fields.get(56).unoccupy();
                                            gb1.Fields.get(60).unoccupy();
                                            gb1.Fields.get(58).occupy();
                                            gb1.Fields.get(59).occupy();
                                            input_legal=true;
                                        }
                                    }
                                }
                            }

                    else if (current_player.getColor()==Color.WHITE){
                        for (Piece piece : gb1.getPieces()) {
                            if (piece instanceof King && piece.getColor() == Color.WHITE) {
                                if (((King) piece).isLongCastlingValid(gb1)) {
                                            piece.setPosition(Column.C, Row.ONE);
                                            gb1.getPiece(Column.A, Row.ONE).setPosition(Column.D, Row.ONE);
                                            gb1.Fields.get(0).unoccupy();
                                            gb1.Fields.get(4).unoccupy();
                                            gb1.Fields.get(2).occupy();
                                            gb1.Fields.get(3).occupy();
                                            input_legal=true;
                                        }
                                    }
                                }
                            }
                    if (input_legal==false) System.out.println("Castling illegal in given situation");
                }

//                Other moves
                else {
                    int[] field_param = alg_not.field_interpreter(move_str);
                    int[] specifiers = alg_not.specifier(move_str);
                    int possible_pieces = 0;

                    List<Piece> potential_pieces= new ArrayList<Piece>();
                    Column c = col.get(field_param[0]-1);
                    Row r = rows.get(field_param[1]-1);
                    Row rk;
                    Object what_figure= alg_not.getTypeOfFigure(move_str);
                    for (Piece p : gb1.Pieces) {
                        if (p.getRow()== r && p.getColumn()== c && p.getColor()!=current_player.getColor()){
                            enemy_piece_on_field=true;
                        }
                    }




//case without extra specifiers
                    if (move_str.length()==8){
                        for (Piece p : gb1.Pieces) {
                            if (p.getColor() == current_player.getColor() && p.getClass() == what_figure
                                    && ((Pawn) p).isValidEnPassant(gb1, c, r)){
                                possible_pieces++;
                                potential_pieces.add(p);
                            }
                        }
                    }
                    else if (specifiers[0]==9  & specifiers[1]==9){
                        for (Piece p : gb1.Pieces) {
                            if (p.getColor() == current_player.getColor() && p.getClass() == what_figure
                                    && p.isValid(gb1, c, r)) {
                                possible_pieces++;
                                potential_pieces.add(p);
                            }
                        }
                    }
//case with column as extra specifier
                    else if (specifiers[0]!=9  & specifiers[1]==9){
                        for (Piece p : gb1.Pieces) {
                            if (p.getColor() == current_player.getColor() && p.getClass() == what_figure
                                    && p.isValid(gb1, c, r) && p.getColumn()==col.get(specifiers[0]-1)) {
                                possible_pieces++;
                                potential_pieces.add(p);
                            }
                        }
                    }

//case with row as extra specifier
                    else if (specifiers[0]==9  & specifiers[1]!=9){
                        for (Piece p : gb1.Pieces) {
                            if (p.getColor() == current_player.getColor() && p.getClass() == what_figure
                                    && p.isValid(gb1, c, r) && p.getRow()==rows.get(specifiers[1]-1)) {
                                possible_pieces++;
                                potential_pieces.add(p);
                            }
                        }
                    }

//case with exact field of moving piece
                    else if (specifiers[0]!=9  & specifiers[1]!=9){
                        for (Piece p : gb1.Pieces) {
                            if (p.getColor() == current_player.getColor() && p.getClass() == what_figure
                                    && p.isValid(gb1, c, r) && p.getColumn()==col.get(specifiers[0]-1)
                                    && p.getRow()==rows.get(specifiers[1]-1)) {
                                possible_pieces++;
                                potential_pieces.add(p);
                            }
                        }
                    }


                    if (enemy_piece_on_field && !move_str.contains("x")) System.out.println("You are attacking a figure without having declared a capture. " +
                            "\nPlease check your algebraic notation.\n");
                    else if (possible_pieces ==0) System.out.println("Could not find "+what_figure.toString().substring(6)+" that can move to desired field.");
                    else if (possible_pieces>1)  System.out.println("Too many "+what_figure.toString().substring(6)+"s can move to the desired field, please specify further.");

//                   if move is legal, completes the move
                    else {

//                  unoccupies previous field
                        for (Field f : gb1.Fields){
                            if (f.getaRow()==potential_pieces.get(0).getRow() && f.getaColumn()== potential_pieces.get(0).getColumn()){
                                f.unoccupy();
                            }
                        }
//                  removes captured piece from the field
                        if (move_str.length()==8){
                            rk= rows.get(field_param[1]-2);
                            for (int i=0; i<=gb1.Pieces.size()-1; i++) {
                                if (gb1.Pieces.get(i).getRow()== rk && gb1.Pieces.get(i).getColumn()== c && gb1.Pieces.get(i).getColor()!=current_player.getColor()){
                                    Piece dead_piece=gb1.Pieces.remove(i);
                                    current_player.add_captures(dead_piece);
                                    for (Field f: gb1.Fields){
                                        if (f.getaColumn()==c && f.getaRow() ==rk) f.unoccupy();
                                    }
                                }
                            }
                        }
                        if (enemy_piece_on_field){
                            for (int i=0; i<=gb1.Pieces.size()-1; i++) {
                                if (gb1.Pieces.get(i).getRow()== r && gb1.Pieces.get(i).getColumn()== c && gb1.Pieces.get(i).getColor()!=current_player.getColor()){
                                    Piece dead_piece=gb1.Pieces.remove(i);
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

//          Initialize Promotion
            for (int i = 0 ; i<gb1.Pieces.size() ; i++){
                if (gb1.Pieces.get(i) instanceof Pawn && gb1.Pieces.get(i).getRow() == Row.EIGHT){
                    Scanner scanner = new Scanner(System.in);
                    String promotion = "0";
                    System.out.println("Specify the figure you wish to promote to:");
                    Column c = gb1.Pieces.get(i).getColumn();
                    gb1.Pieces.remove(gb1.Pieces.get(i));
                    while (true) {
                        promotion = scanner.nextLine();
                        if (promotion.equals("N")) {
                            gb1.Pieces.add(new Knight(Row.EIGHT,c, Color.WHITE));
                            break;
                        }
                        if (promotion.equals("Q")) {
                            gb1.Pieces.add(new Queen(Row.EIGHT,c, Color.WHITE));
                            break;
                        }
                        if (promotion.equals("R")) {
                            gb1.Pieces.add(new Rook(Row.EIGHT,c, Color.WHITE));
                            break;
                        }
                        if (promotion.equals("B")) {
                            gb1.Pieces.add(new Bishop(Row.EIGHT,c, Color.WHITE));
                            break;
                        }
                        System.out.println("Please check your notation!");
                        System.out.println("Specify the figure you wish to promote to:");
                    }

                }
                else if (gb1.Pieces.get(i) instanceof Pawn && gb1.Pieces.get(i).getRow() == Row.ONE){
                    Scanner scanner = new Scanner(System.in);
                    String promotion = "0";
                    System.out.println("Specify the figure you wish to promote to:");
                    Column c = gb1.Pieces.get(i).getColumn();
                    gb1.Pieces.remove(gb1.Pieces.get(i));
                    while (true) {
                        promotion = scanner.nextLine();
                        if (promotion.equals("N")) {
                            gb1.Pieces.add(new Knight(Row.ONE,c, Color.BLACK));
                            break;
                        }
                        if (promotion.equals("Q")) {
                            gb1.Pieces.add(new Queen(Row.ONE,c, Color.BLACK));
                            break;
                        }
                        if (promotion.equals("R")) {
                            gb1.Pieces.add(new Rook(Row.ONE,c, Color.BLACK));
                            break;
                        }
                        if (promotion.equals("B")) {
                            gb1.Pieces.add(new Bishop(Row.ONE,c, Color.BLACK));
                            break;
                        }
                        System.out.println("Please check your notation!");
                        System.out.println("Specify the figure you wish to promote to:");
                    }
                }

            }

        }
    }
}