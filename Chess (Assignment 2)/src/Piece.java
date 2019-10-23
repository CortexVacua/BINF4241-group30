import java.util.Iterator;

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
//        if(gb.getPiece(toX, toY) instanceof King) {
//            return false;
//        }
        if(gb.getPiece(toX, toY) != null) {
            if(gb.getPiece(toX, toY).getColor() == color) {
                return false;
            }
        }
        //checks if this move undoes check in case of checked King or places the king in check in the first place
        Gameboard gb2 = new Gameboard(gb);
        for (int i = 0; i < gb2.getPieces().size(); i++) {
          if (gb2.getPieces().get(i).getColor() == color && gb2.getPieces().get(i) instanceof King) {
              if (gb2.getPiece(toX, toY) != null) {
                  for (int j = 0; j < gb2.getPieces().size(); j++) {
                      if (gb2.getPieces().get(j).getRow() == toY && gb2.getPieces().get(j).getColumn() == toX) {
                          gb2.Pieces.remove(j);
                      }
                  }
                  gb2.getPiece(x, y).setPosition(toX, toY);
                  gb2.getField(x, y).unoccupy();
                  for (int k = 0; k < gb2.getPieces().size(); k++) {
                      if (gb2.getPieces().get(k).getColor() == color && gb2.getPieces().get(k) instanceof King) {
                          if (gb2.getPieces().get(i).checkIfChecked(gb2)) {
//                              System.out.println("You are making a move that puts or leaves your king in check. ");
                              return false;
                          }
                      }

                  }
              } else {
                  gb2.getPiece(x, y).setPosition(toX, toY);
                  gb2.getField(x, y).unoccupy();
                  gb2.getField(toX, toY).occupy();
                  for (int l = 0; l < gb2.getPieces().size(); l++) {
                      if (gb2.getPieces().get(l).getColor() == color && gb2.getPieces().get(l) instanceof King) {
                          if (gb2.getPieces().get(i).checkIfChecked(gb2)) {
//                              System.out.println("You are making a move that puts or leaves your king in check. ");
                              return false;
                          }
                      }
                  }
              }
          }
        }
        return toX.column_number != x.column_number || toY.row_number != y.row_number;
    }
    public boolean isValidForKing(Gameboard gb, Column toX, Row toY) {
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
    public boolean checkIfChecked(Gameboard gb) {
        return false;
    }
}