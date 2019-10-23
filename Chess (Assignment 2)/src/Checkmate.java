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
//      determines the attacker's and defender's color
        if (att_color==Color.BLACK) def_color = Color.WHITE;
        else def_color = Color.BLACK;
//      searches the defender's king and gets some stats of it
        for (int i=0; i<gb1.Pieces.size(); i++) {
            if (gb1.Pieces.get(i) instanceof King && gb1.Pieces.get(i).getColor() == def_color) {
                def_King=gb1.Pieces.get(i);
                def_row = gb1.Pieces.get(i).getRow();
                def_column = gb1.Pieces.get(i).getColumn();
//              searches every piece that attacks the defender's king
                for (int j=0; j<gb1.Pieces.size(); j++){
                    if (gb1.Pieces.get(j).getColor() == att_color && gb1.Pieces.get(j).isValid(gb1,def_column,def_row)){
                        att_pieces.add(gb1.Pieces.get(j));
                    }
                }
//              searches fields where the king can dodge check
                boolean is_safe_field = false;
                for (int k=0; k<gb1.Fields.size(); k++){
                    if (def_King.isValid(gb1, gb1.Fields.get(k).getaColumn(), gb1.Fields.get(k).getaRow())){
                        is_safe_field = true;
                        for (int l=0; l<gb1.Pieces.size(); l++){
                            if(gb1.Pieces.get(l).isValid(gb1, gb1.Fields.get(k).getaColumn(), gb1.Fields.get(k).getaRow())
                                    && gb1.Pieces.get(l).getColor() == att_player.getColor()) is_safe_field = false;
                        }
                    }
                    if (is_safe_field == true) dodge_fields.add(gb1.Fields.get(k));
                }
            }
        }
        if (att_pieces.size()==0) { System.out.print("No Attackers! "); return false;}
        else if (dodge_fields.size()>0) { System.out.print("Check! You can dodge! "); return false;}
        else if (att_pieces.size()>1) return true;
        else if (att_pieces.size()==1) {
//          searches a piece of the defender that could kill the attacker
            for(int i=0 ; i<gb1.Pieces.size() ; i++){
                if (gb1.Pieces.get(i).getColor() == def_color &&
                        gb1.Pieces.get(i).isValid(gb1 , att_pieces.get(0).getColumn() , att_pieces.get(0).getRow())){
                    System.out.print("Check! Someone can kill Attacker! "); return false;}
            }
        }
        else if (att_pieces.get(0) instanceof Knight) return true;
        else {
            System.out.print("last case reached");
//          gets the stats of the defender's king again
            for(int i=0 ; i<gb1.Pieces.size() ; i++){
                if(gb1.Pieces.get(i) instanceof King && gb1.Pieces.get(i).getColor() == def_color) {
                    def_column = gb1.Pieces.get(i).getColumn();
                    def_row = gb1.Pieces.get(i).getRow();
//                  attacker and king are on the same column -> searches the fields between them
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
//                  attacker and king are on the same row -> searches the fields between them
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
//                  attacker and king are on the same diagonal -> searches the fields between them
                    else if (Math.abs(att_pieces.get(0).getRow().get_row_number()-def_row.get_row_number()) ==
                            Math.abs(att_pieces.get(0).getColumn().get_column_number()-def_column.get_column_number())){
                        int high_row;
                        int low_row;
                        if (att_pieces.get(0).getRow().get_row_number() > def_row.get_row_number()){
                            high_row = att_pieces.get(0).getRow().get_row_number();
                            low_row = def_row.get_row_number();
                            for (int j=1; j<high_row-low_row; j++){
                                if(att_pieces.get(0).getColumn().get_column_number()>def_column.get_column_number()){
                                    block_fields.add(gb1.Fields.get(8*(def_row.get_row_number()-1+j)+(def_column.get_column_number()-1+j)));
                                }
                                else{
                                    block_fields.add(gb1.Fields.get(8*(def_row.get_row_number()-1+j)+(def_column.get_column_number()-1-j)));
                                }
                            }
                        }
                        else {
                            high_row = def_row.get_row_number();
                            low_row = att_pieces.get(0).getRow().get_row_number();
                            for (int j=1; j<high_row-low_row; j++){
                                if(att_pieces.get(0).getColumn().get_column_number()<def_column.get_column_number()){
                                    block_fields.add(gb1.Fields.get(8*(att_pieces.get(0).getRow().get_row_number()-1+j)+(att_pieces.get(0).getColumn().get_column_number()-1+j)));
                                }
                                else{
                                    block_fields.add(gb1.Fields.get(8*(att_pieces.get(0).getRow().get_row_number()-1+j)+(att_pieces.get(0).getColumn().get_column_number()-1-j)));
                                }
                            }
                        }

                    }
                }
            }
            for(int k=0 ; k<block_fields.size() ; k++){
                System.out.println(block_fields.get(k).getaColumn());
                System.out.print(block_fields.get(k).getaRow());
                for (int i=0 ; i<gb1.Pieces.size() ; i++){
                    if(gb1.Pieces.get(i).getColor() == def_color && gb1.Pieces.get(i).isValid(gb1,block_fields.get(k).getaColumn(),block_fields.get(k).getaRow())){
                        System.out.print("Check! You can block the Attacker");
                        return false;
                    }
                }
            }
        }
        System.out.print("Check! No Escape! QwQ");
        return true;}
    }
