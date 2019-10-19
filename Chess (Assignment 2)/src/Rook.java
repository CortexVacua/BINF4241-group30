public class Rook extends Piece {

    public Rook (Row pRow, Column pColumn, Color pColor){
        super();
        this.y=pRow;
        this.x=pColumn;
        this.color=pColor;
        this.number_of_moves=0;
    }

    // Checks whether the piece is allowed to do this kind of move; Staying in bounds and capture of potential pieces has to be checked by game class.
    public boolean isValid(Column fromX, Row fromY, Column toX, Row toY) {
        if(!super.isValid(fromX, fromY, toX, toY)) {
            return false;
        }
        if(toX.column_number == fromX.column_number) {
            return true;
        }
        if(toY.row_number == fromY.row_number) {
            return true;
        }
        return false;
    }
}
