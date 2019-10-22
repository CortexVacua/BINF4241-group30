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

//        en passant moves
        //        capture moves for the pawns
        for (int u=0; u<8; u++){
            for (int i=0; i<8; i++){
                for (int j=0; j<8; j++){
                    special_moves.add(""+possible_columns.charAt(u)+"x"+possible_columns.charAt(i)+possible_rows.charAt(j)+"e.p.");
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
        int[] ab= new int[2];
        if (str.length()==8){
            int a= possible_columns.indexOf(str.charAt(2))+1;
            int b= possible_rows.indexOf(str.charAt(3))+1;
            ab[0]= a;
            ab[1]= b;
        }
        else {
            int a= possible_columns.indexOf(str.charAt(str.length()-2)) + 1;
            int b= possible_rows.indexOf(str.charAt(str.length()-1)) + 1;
            ab[0]= a;
            ab[1]= b;
        }
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

//      returns true if there are extra specifiers besides the game piece, like the column, the row or both
    private boolean extra_specifier(String str) {
        if (str.length()<4) return false;
        if (str.length()==4 && str.contains("x")) {//example: exe3, Kxe3
            if (java.lang.Character.isLowerCase(str.charAt(0))) return true;
            else return false;
        }
        if (str.length()==4 && !str.contains("x")) return true;// example: Bce3,B1e3
        if (str.length()==5) return true; //example: Ra1a7, Raxa7,R1xa7
        if (str.length()==6) return true; //example: Ra1xa7
        return false;
    }

    public int[] specifier (String str){
        int[] cd= new int[2];
        if(extra_specifier(str)==false){
            cd[0]=9;//9 used as value to tell there is no extra special specifier
            cd[1]=9;
        }
        else if (str.length()==4){
            if (str.contains("x")&& java.lang.Character.isLowerCase(str.charAt(0))){
                cd[0]=possible_columns.indexOf(str.charAt(0))+1;
                cd[1]=9;
            }
            else {
                if (possible_columns.contains(""+str.charAt(1))) {
                    cd[0] = possible_columns.indexOf(str.charAt(1)) + 1;
                    cd[1] = 9;
                }
                else {
                    cd[0] = 9;
                    cd[1]= possible_rows.indexOf(str.charAt(1))+1;
                }

            }
        }

        else if (str.length()==5){
            if (!str.contains("x")){
                cd[0] = possible_columns.indexOf(str.charAt(1)) + 1;
                cd[1]= possible_rows.indexOf(str.charAt(2))+1;
            }
            else {
                if (possible_columns.contains(""+str.charAt(1))) {
                    cd[0] = possible_columns.indexOf(str.charAt(1)) + 1;
                    cd[1] = 9;
                }
                else {
                    cd[0] = 9;
                    cd[1]= possible_rows.indexOf(str.charAt(1))+1;
                }
            }
        }
        else if(str.length()==6){
            cd[0] = possible_columns.indexOf(str.charAt(1)) + 1;
            cd[1]= possible_rows.indexOf(str.charAt(2))+1;
        }
        return cd;
    }
}