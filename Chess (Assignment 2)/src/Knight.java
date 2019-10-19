public class Knight extends Piece {

    public Knight (Row pRow, Column pColumn, Color pColor){
        super();
        this.y=pRow;
        this.x=pColumn;
        this.color=pColor;
        this.number_of_moves=0;
    }

    // Checks whether the piece is allowed to do this kind of move; capture of potential pieces has to be checked by game class.
    public boolean isValid(Gameboard gb, Column toX, Row toY) {
        if(!super.isValid(gb, toX, toY)) {
            return false;
        }
        if(toX.column_number != x.column_number - 1 && toX.column_number != x.column_number + 1 && toX.column_number != x.column_number + 2 && toX.column_number != x.column_number - 2) {
            return false; }
        if(toY.row_number != y.row_number - 2 && toY.row_number != y.row_number + 2 && toY.row_number != y.row_number - 1 && toY.row_number != y.row_number + 1) {
            return false; }
        if((toX.column_number - 1 == x.column_number && toY.row_number -1 == y.row_number) || (toX.column_number - 2 == x.column_number && toY.row_number -2 == y.row_number)) {
            return false; }
        if((toX.column_number + 1 == x.column_number && toY.row_number +1 == y.row_number) || (toX.column_number + 2 == x.column_number && toY.row_number +2 == y.row_number)) {
            return false; }
        if((toX.column_number - 1 == x.column_number && toY.row_number +1 == y.row_number) || (toX.column_number - 2 == x.column_number && toY.row_number +2 == y.row_number)) {
            return false; }
        if((toX.column_number + 1 == x.column_number && toY.row_number -1 == y.row_number) || (toX.column_number + 2 == x.column_number && toY.row_number -2 == y.row_number)) {
            return false; }
        return true;
        }
    }
