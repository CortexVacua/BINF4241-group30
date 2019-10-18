public class Queen extends Piece {

    // Checks whether the piece is allowed to do this kind of move; Staying in bounds and capture of potential pieces has to be checked by game class.
    public boolean isValid(Column fromX, Row fromY, Column toX, Row toY) {
        if(!super.isValid(fromX, fromY, toX, toY)) {
            return false;
        }
        if(toX.column_number - fromX.column_number == toY.row_number - fromY.row_number) {
            return true;
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
