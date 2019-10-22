import java.util.ArrayList;
import java.util.List;

public class Checkmate {
    private List<Piece> att_pieces= new ArrayList<Piece>();
    private List<Field> dodge_fields= new ArrayList<Field>();
    private List<Field> block_fields = new ArrayList<Field>();
    private List<Column> col = new ArrayList<Column>();
    private List<Row> row = new ArrayList<Row>();


    public boolean checkmate(Gameboard gb1, Player att_player){
        Piece def_King;
        Color att_color =att_player.getColor();
        Color def_color;
        Column def_column;
        Row def_row;
        for (Column c : Column.values())
            col.add(c);
        for (Row r : Row.values())
            row.add(r);

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
            else {
                for(int i=0 ; i<gb1.Pieces.size() ; i++){
                    if(gb1.Pieces.get(i) instanceof King && gb1.Pieces.get(i).getColor() == def_color) {
                        def_column = gb1.Pieces.get(i).getColumn();
                        def_row = gb1.Pieces.get(i).getRow();

                        if (att_pieces.get(0).getColumn() == def_column) {
                            int high_row;
                            int low_row;
                            if (att_pieces.get(0).getRow().get_row_number() > def_row.get_row_number()){
                                high_row = att_pieces.get(0).getRow().get_row_number();
                                low_row = def_row.get_row_number();
                            } else {
                                high_row = def_row.get_row_number();
                                low_row = att_pieces.get(0).getRow().get_row_number();
                            }
                            for (int k=low_row ; k<high_row-1 ; k++){
                                block_fields.add(gb1.Fields.get(8*k+def_column.get_column_number()-1));
                            }
                        }

                        else if (att_pieces.get(0).getRow() == def_row) {
                            int high_column;
                            int low_column;
                            if (att_pieces.get(0).getColumn().get_column_number() > def_column.get_column_number()){
                                high_column = att_pieces.get(0).getColumn().get_column_number();
                                low_column = def_column.get_column_number();
                            } else {
                                high_column = def_column.get_column_number();
                                low_column = att_pieces.get(0).getColumn().get_column_number();
                            }
                            for (int k=low_column ; k<high_column-1 ; k++){
                                block_fields.add(gb1.Fields.get(8*(def_row.get_row_number()-1)+k));
                            }
                        }

                        else if (Math.abs(att_pieces.get(0).getRow().get_row_number()-def_row.get_row_number()) ==
                                Math.abs(att_pieces.get(0).getColumn().get_column_number()-def_column.get_column_number())){
                            return false;
                        }
                    }
                }
            }
        return true;}
    }
