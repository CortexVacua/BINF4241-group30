public class King extends Piece {

    public King (Row pRow, Column pColumn, Color pColor){
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
        if(toX.column_number == x.column_number -1 || toX.column_number == x.column_number +1) {
            if(toY.row_number == y.row_number -1 || toY.row_number == y.row_number || toY.row_number == y.row_number +1) {
                return true;
            }
        }
        if(toX.column_number == x.column_number) {
            if(toY.row_number == y.row_number -1 || toY.row_number == y.row_number +1) {
                return true;
            }
        }

        return false;
    }
}