public class Main {
    public static void main(String[] args) {
        Gameboard gb1 = new Gameboard();
        for (int i = 0; i<=63; i++) {
            Field x = gb1.Fields.get(i);
            x.getaColumn().get_column_number();
//            System.out.println(x.getaColor());
//            System.out.println(x.getaRow());
//            System.out.println(x.getaColumn());
//            System.out.println(x.getaOccupied());
//            System.out.println("\n\n");
        }
    }
}

