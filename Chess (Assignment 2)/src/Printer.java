import java.util.List;

public class Printer {

    public void board_state(List<Field> Fields,List<Piece> Pieces){
        int num_col = 1;
        int k = 0;
        System.out.print("\n" + num_col + " ");
        num_col++;
        for (int i=0 ; i<Fields.size() ; i++){
            System.out.print("[");
// places the right Piece if Field is occupied
            if (Fields.get(i).getaOccupied() == Occupied.OCCUPIED) {
                for (int p = 0; p < Pieces.size(); p++) {
                    if (Pieces.get(p).getRow() == Fields.get(i).getaRow() && Pieces.get(p).getColumn() == Fields.get(i).getaColumn()) {
// checks the Color and Subclass of the Piece
                        if (Pieces.get(p).getColor() == Color.BLACK){
                            System.out.print("B"); } else { System.out.print("W"); }
                        Class c = Pieces.get(p).getClass();
                        if (c == Pawn.class){ System.out.print("P"); }
                        if (c == King.class){ System.out.print("K"); }
                        if (c == Queen.class){ System.out.print("Q"); }
                        if (c == Bishop.class){ System.out.print("B"); }
                        if (c == Knight.class){ System.out.print("N"); }
                        if (c == Rook.class){ System.out.print("R"); }
                        }
                    }
                }
            else { System.out.print("  "); }
            System.out.print("]");
            k = k+1;
//  makes a new row
            if (k == 8){
                System.out.print("\n");
                if (num_col != 9){
                    System.out.print(num_col + " ");
                    num_col++;}
                k = 0;
            }
            }
        System.out.println("   A   B   C   D   E   F   G   H \n");
        }
    }
