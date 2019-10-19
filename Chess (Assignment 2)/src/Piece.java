public class Piece {
    protected Row y;
    protected Column x;
    protected Color color;
    protected int number_of_moves;

    //not moving anything is not a valid move
    public boolean isValid(Column fromX, Row fromY, Column toX, Row toY) {
        return toX.column_number != fromX.column_number || toY.row_number != fromY.row_number;
    }

    public Color getColor() {
        return color;
    }

    public Column getX() {
        return x;
    }

    public Row getY() {
        return y;
    }

    public int getNumber_of_moves() {
        return number_of_moves;
    }
}