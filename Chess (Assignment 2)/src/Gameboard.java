
import java.util.ArrayList;
import java.util.List;

public class Gameboard {
    public List<Field> Fields = new ArrayList<>();

    public Gameboard(){
        boolean isBlack= true ;
        for(Row row : Row.values()){
            for (Column column : Column.values()){
            if (isBlack==true) {
                Fields.add(new Field(Color.BLACK,row,column,Occupied.UNOCCUPIED));
                if (column != Column.H){
                    isBlack=false;}
                }
            else {
                Fields.add(new Field(Color.WHITE,row,column,Occupied.UNOCCUPIED));
                if (column != Column.H){
                    isBlack=true;
                }
            }
            }
        }
    }
}
