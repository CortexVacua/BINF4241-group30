public class Main {
    public static void main(String[] args) {
        Gameboard gb1 = new Gameboard();
        Printer printer = new Printer();
        printer.board_state(gb1.Fields, gb1.Pieces);
//        for (int i = 0; i<=63; i++) {
//            Field x = gb1.Fields.get(i);
//            x.getaColumn().get_column_number();
//            System.out.println(x.getaColor());
//            System.out.println(x.getaRow());
//            System.out.println(x.getaColumn());
//            System.out.println(x.getaOccupied());
//            System.out.println("\n\n");
//        for (int i=0; i<32; i++) {
//            Piece x = gb1.Pieces.get(i);
//            System.out.println(x.getClass());
//            System.out.println(x.getColor());
//            System.out.println(x.getX());
//            System.out.println(x.getY());
//            System.out.println(x.getNumber_of_moves());
//            System.out.println("\n\n");
//        }
        Game dfs= new Game();
    }
}

