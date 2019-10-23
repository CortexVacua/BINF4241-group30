import java.util.ArrayList;
import java.util.List;

public class Checkmate {
    private List<Piece> att_pieces= new ArrayList<Piece>();
    private List<Field> dodge_fields= new ArrayList<Field>();
    private List<Field> block_fields = new ArrayList<Field>();

    public boolean Checkmate(Gameboard gb1, Player att_player){
        Piece def_King;
        Color att_color =att_player.getColor();
        Color def_color;
        Column def_column;
        Row def_row;
        if (att_color==Color.BLACK) def_color = Color.WHITE;
        else def_color = Color.BLACK;
        for (int i=0; i<gb1.Pieces.size(); i++) {
            if (gb1.Pieces.get(i) instanceof King && gb1.Pieces.get(i).getColor() == def_color) {
                def_King=gb1.Pieces.get(i);
                def_row = gb1.Pieces.get(i).getRow();
                def_column = gb1.Pieces.get(i).getColumn();

                for (int j=0; j<gb1.Pieces.size(); j++){
                    if (gb1.Pieces.get(j).getColor() == att_color){
                        if (gb1.Pieces.get(j).isValid(gb1,def_column,def_row)) att_pieces.add(gb1.Pieces.get(j));
                    }
                }
                for (int k=0; k<gb1.Fields.size(); k++){
                    if (def_King.isValid(gb1, gb1.Fields.get(k).getaColumn(), gb1.Fields.get(k).getaRow()))
                        for (int l=0; l<gb1.Pieces.size(); l++){
                            if(!gb1.Pieces.get(l).isValid(gb1, gb1.Fields.get(k).getaColumn(), gb1.Fields.get(k).getaRow())) dodge_fields.add(gb1.Fields.get(k));
                }
                }
            }
        }
        if (att_pieces.size()==0) return false;
        else if (dodge_fields.size()>0) return false;
        else if (att_pieces.size()>1) return true;
        else if (att_pieces.size()==1) {
            for(int i=0 ; i<gb1.Pieces.size() ; i++){
                if (gb1.Pieces.get(i).getColor() == def_color &&
                        gb1.Pieces.get(i).isValid(gb1 , att_pieces.get(0).getColumn() , att_pieces.get(0).getRow())) return false;
            }
        }
        else if (att_pieces.get(0) instanceof Knight) return true;
            else if (att_pieces.get(0).getColumn() == def_column){

        }


    }
}
