import java.util.ArrayList;
import java.util.List;

public class AlgebraicNotation {
    private String possible_columns = "abcdefgh";
    private String possible_rows = "12345678";
    private String possible_figures = "KQNBR";

    public List<String> special_moves = new ArrayList<String>();
    public List<String> reg_moves = new ArrayList<String>();

    public AlgebraicNotation(){
        special_moves.add("0-0");
        special_moves.add("0-0-0");

//        all reg pawn moves
        for (int i=0; i<8; i++){
            for (int j=0; j<8; j++){
                reg_moves.add(""+possible_columns.charAt(i)+possible_rows.charAt(j));
            }
        }

//        capture moves for the pawns
        for (int u=0; u<8; u++){
            for (int i=0; i<8; i++){
                for (int j=0; j<8; j++){
                    reg_moves.add(""+possible_columns.charAt(u)+"x"+possible_columns.charAt(i)+possible_rows.charAt(j));
                }
            }
        }

//        all reg non pawn moves
        for (int u=0; u<5; u++){
            for (int i=0; i<8; i++){
                for (int j=0; j<8; j++){
                    reg_moves.add(""+possible_figures.charAt(u)+possible_columns.charAt(i)+possible_rows.charAt(j));
                }
            }
        }

//        all reg moves for non pawns (avoiding ambiguity)
        for (int u=0; u<5; u++) {
            for (int x = 0;x < 8; x++){
                for (int i = 0; i < 8; i++) {
                    for (int j = 0;  j< 8; j++) {
                        reg_moves.add("" + possible_figures.charAt(u) +possible_columns.charAt(x)+ possible_columns.charAt(i) + possible_rows.charAt(j));
                    }
                }
            }
        }

        for (int u=0; u<5; u++) {
            for (int x = 0;x < 8; x++){
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        reg_moves.add("" + possible_figures.charAt(u) +possible_rows.charAt(x)+ possible_columns.charAt(i) + possible_rows.charAt(j));
                    }
                }
            }
        }

        for (int u=0; u<5; u++) {
            for (int y = 0; y< 8; y++){
                for (int x = 0;x < 8; x++){
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            reg_moves.add("" + possible_figures.charAt(u) +possible_columns.charAt(y)+possible_rows.charAt(x)+ possible_columns.charAt(i) + possible_rows.charAt(j));
                        }
                    }
                }
            }
        }


//        capture moves for the non pawns
        for (int u=0; u<5; u++){
            for (int i=0; i<8; i++){
                for (int j=0; j<8; j++){
                    reg_moves.add(""+possible_figures.charAt(u)+"x"+possible_columns.charAt(i)+possible_rows.charAt(j));
                }
            }
        }

//        capture moves for the non pawns to (avoiding ambiguity)
        for (int u=0; u<5; u++) {
            for (int x = 0;x < 8; x++){
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        reg_moves.add("" + possible_figures.charAt(u) +possible_columns.charAt(x)+ "x" + possible_columns.charAt(i) + possible_rows.charAt(j));
                    }
                }
            }
        }

        for (int u=0; u<5; u++) {
            for (int x = 0;x < 8; x++){
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        reg_moves.add("" + possible_figures.charAt(u) +possible_rows.charAt(x)+ "x" + possible_columns.charAt(i) + possible_rows.charAt(j));
                    }
                }
            }
        }

        for (int u=0; u<5; u++) {
            for (int y = 0; y< 8; y++){
                for (int x = 0;x < 8; x++){
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 8; j++) {
                            reg_moves.add("" + possible_figures.charAt(u) +possible_columns.charAt(y)+possible_rows.charAt(x)+ "x" + possible_columns.charAt(i) + possible_rows.charAt(j));
                        }
                    }
                }
            }
        }
    }

//    Checks format of algebraic notation
    public boolean check_notation (String str){
        if (reg_moves.contains(str) || special_moves.contains(str)) return true;
        else return false;
    }

//    return field parameters as integers
    public int[] field_interpreter (String str){
        int a= possible_columns.indexOf(str.charAt(str.length()-2)) + 1;
        int b= possible_rows.indexOf(str.charAt(str.length()-1)) + 1;
        int[] ab= {a,b};
        return ab;
    }

//    return type of piece that should move
    public Object getTypeOfFigure (String str){
        if (java.lang.Character.isUpperCase(str.charAt(0))){
            if (("" + str.charAt(0)).equals("K")) return King.class;
            if (("" + str.charAt(0)).equals("Q")) return Queen.class;
            if (("" + str.charAt(0)).equals("N")) return Knight.class;
            if (("" + str.charAt(0)).equals("B")) return Bishop.class;
            if (("" + str.charAt(0)).equals("R")) return Rook.class;
        }
        return Pawn.class;
    }


}