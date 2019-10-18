public class Piece {
    private Row y;
    private Column x;
    private Color color;
    private int number_of_moves;

    //not moving anything is not a valid move
    public boolean isValid(Column fromX, Row fromY, Column toX, Row toY) {
        return toX.column_number != fromX.column_number || toY.row_number != fromY.row_number;
    }
}