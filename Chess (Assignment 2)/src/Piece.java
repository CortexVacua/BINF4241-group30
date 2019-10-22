public class Piece {
    protected Row y;
    protected Column x;
    protected Color color;
    protected int number_of_moves;

    public Piece(Piece p) {
        this.y = p.getRow();
        this.x = p.getColumn();
        this.color = p.getColor();
        this.number_of_moves = p.getNumber_of_moves();
    }

    public Piece() {
    }

    //not moving anything is not a valid move; going out of bounds is not a valid move; capturing King is not a valid move; capturing a piece of your own is not a valid move
    public boolean isValid(Gameboard gb, Column toX, Row toY) {
        if(toX.column_number > 8 || toY.row_number > 8 || toX.column_number < 1 || toY.row_number < 1) {
            return false;
        }
        if(gb.getPiece(toX, toY) instanceof King) {
            return false;
        }
        if(gb.getPiece(toX, toY) != null) {
            if(gb.getPiece(toX, toY).getColor() == color) {
                return false;
            }
        }
        //checks if this move undoes check in case of checked King or places the king in check in the first place
        Gameboard gb2 = new Gameboard(gb);
        for (Piece piece : gb2.getPieces()) {
          if (piece.getColor() == color && piece instanceof King) {
                  if (gb2.getPiece(toX, toY) != null) {
                      for (Piece p : gb2.getPieces()) {
                          if (p.getRow()== toY && p.getColumn()== toX) {
                              gb2.Pieces.remove(p);
                          }
                      }
                      gb2.getPiece(x, y).setPosition(toX, toY);
                      gb2.getField(x, y).unoccupy();
                      if (((King) piece).checkIfChecked(gb2)) {
                          return false;
                      }
                  }
                  else {
                      gb2.getPiece(x, y).setPosition(toX, toY);
                      gb2.getField(x, y).unoccupy();
                      if (((King) piece).checkIfChecked(gb2)) {
                          return false;
                      }
                  }
                }
        }
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