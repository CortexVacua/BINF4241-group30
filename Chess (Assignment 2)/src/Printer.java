import java.util.List;

public class Printer {

    public void board_state(List<Field> Fields,List<Piece> Pieces){
        System.out.println("\n");
        int row_number = 8;
        for (int r=0 ; r<Fields.size()/8 ; r++){
            System.out.print(row_number + " ");
            row_number--;
            for (int c=0 ; c<Fields.size()/8 ; c++){
                System.out.print("[");
//              checks if current field is occupied
                if (Fields.get((7-r)*8+c).getaOccupied() == Occupied.OCCUPIED){
                    for (int p = 0; p < Pieces.size(); p++) {
                        if (Pieces.get(p).getRow() == Fields.get((7-r)*8+c).getaRow() && Pieces.get(p).getColumn() == Fields.get((7-r)*8+c).getaColumn()) {
//                          checks for the piece's color
                            if (Pieces.get(p).getColor() == Color.BLACK){
                            System.out.print("B"); } else { System.out.print("W"); }
//                      checks for the piece's class
                        Class cl = Pieces.get(p).getClass();
                        if (cl == Pawn.class){ System.out.print("P"); }
                        if (cl == King.class){ System.out.print("K"); }
                        if (cl == Queen.class){ System.out.print("Q"); }
                        if (cl == Bishop.class){ System.out.print("B"); }
                        if (cl == Knight.class){ System.out.print("N"); }
                        if (cl == Rook.class){ System.out.print("R"); }
                        }
                    }
                } else {System.out.print("  ");}
                System.out.print("]");
            }
            System.out.print("\n");
        }
        System.out.println("   A   B   C   D   E   F   G   H \n");
        }
    }
