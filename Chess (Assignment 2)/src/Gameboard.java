
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;

public class Gameboard {
    public List<Field> Fields = new ArrayList<>(); //needs to be made private after testing
    public List<Piece> Pieces = new ArrayList<>(); //needs to be made private after testing

    public Gameboard(){
        Color color = Color.BLACK ;
        for(Row row : Row.values()){
            for (Column column : Column.values()){
            if (color==Color.BLACK) {
                Fields.add(new Field(Color.BLACK,row,column,Occupied.UNOCCUPIED));
                if (column != Column.H){
                    color= Color.WHITE;}
                }
            else {
                Fields.add(new Field(Color.WHITE,row,column,Occupied.UNOCCUPIED));
                if (column != Column.H){
                    color=Color.BLACK;
                }
            }
            }
        }
        for (int i=0 ; i<64; i++){
            if (Fields.get(i).getaRow()== Row.ONE ||Fields.get(i).getaRow()== Row.TWO ||
                    Fields.get(i).getaRow()== Row.SEVEN || Fields.get(i).getaRow()== Row.EIGHT){
                Fields.get(i).occupy();
            }
        }

//adds all the game pieces
        for (Column i: Column.values()){
            Pieces.add(new Pawn(Row.TWO,i, Color.WHITE));
            Pieces.add(new Pawn(Row.SEVEN,i, Color.BLACK));
        }
        Pieces.add(new King(Row.EIGHT,Column.E, Color.BLACK));
        Pieces.add(new King(Row.ONE,Column.E, Color.WHITE));

        Pieces.add(new Queen(Row.EIGHT,Column.D, Color.BLACK));
        Pieces.add(new Queen(Row.ONE,Column.D, Color.WHITE));

        Pieces.add(new Rook(Row.EIGHT,Column.A, Color.BLACK));
        Pieces.add(new Rook(Row.EIGHT,Column.H, Color.BLACK));
        Pieces.add(new Rook(Row.ONE,Column.A, Color.WHITE));
        Pieces.add(new Rook(Row.ONE,Column.H, Color.WHITE));

        Pieces.add(new Knight(Row.EIGHT,Column.B, Color.BLACK));
        Pieces.add(new Knight(Row.EIGHT,Column.G, Color.BLACK));
        Pieces.add(new Knight(Row.ONE,Column.B, Color.WHITE));
        Pieces.add(new Knight(Row.ONE,Column.G, Color.WHITE));

        Pieces.add(new Bishop(Row.EIGHT,Column.C, Color.BLACK));
        Pieces.add(new Bishop(Row.EIGHT,Column.F, Color.BLACK));
        Pieces.add(new Bishop(Row.ONE,Column.C, Color.WHITE));
        Pieces.add(new Bishop(Row.ONE,Column.F, Color.WHITE));

    }
}
