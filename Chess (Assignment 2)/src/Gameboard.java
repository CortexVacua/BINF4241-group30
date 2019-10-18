
import java.util.ArrayList;
import java.util.List;

public class Gameboard {
    public List<Field> Fields = new ArrayList<>();
    private List<Piece> Pieces = new ArrayList<>();

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
    }
}
