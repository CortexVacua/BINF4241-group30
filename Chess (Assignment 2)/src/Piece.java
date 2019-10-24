public class Piece {
    protected Row y;
    protected Column x;
    protected Color color;
    protected int number_of_moves;

    //not moving anything is not a valid move; going out of bounds is not a valid move; capturing King is not a valid move; capturing a piece of your own is not a valid move
    //TODO: check if color of the moved piece matches color of the player who moves it
    public boolean isValid(Gameboard gb, Column toX, Row toY) {
        if(toX.column_number > 8 || toY.row_number > 8 || toX.column_number < 1 || toY.row_number < 1) {
            return false;
        }
//        if(gb.getPiece(toX, toY) instanceof King) {
//            return false;
//        }
        if(gb.getPiece(toX, toY) != null) {
            if(gb.getPiece(toX, toY).getColor() == color) {
                return false;
            }
        }
        //for (Piece piece : gb.getPieces()) {
        //  if (piece.getColor() == color && piece instanceof King) {
        //      if (((King) piece).checkIfChecked(gb)) {
        //          Gameboard gb2 = copy constructor;
        //        }
        //     }
        //  }
        return toX.column_number != x.column_number || toY.row_number != y.row_number;
    }

    public Color getColor() {
        return color;
    }

    public Column getColumn() {
        return x;
    }

    public Row getRow() {
        return y;
    }

    public int getNumber_of_moves() {
        return number_of_moves;
    }

    public void setPosition(Column x, Row y) {
        this.y = y;
        this.x = x;
        number_of_moves ++;
    }
}