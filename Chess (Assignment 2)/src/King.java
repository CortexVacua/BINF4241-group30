public class King extends Piece {

    public King(Row pRow, Column pColumn, Color pColor) {
        super();
        this.y = pRow;
        this.x = pColumn;
        this.color = pColor;
        this.number_of_moves = 0;
    }

    // Checks whether the piece is allowed to do this kind of move; capture of potential pieces has to be checked by game class.
    public boolean isValid(Gameboard gb, Column toX, Row toY) {
        if (!super.isValid(gb, toX, toY)) {
            return false;
        }
        if (color == Color.WHITE) {
            if (gb.getField(toX, toY).checkIfAttacked(gb, Color.BLACK)) {
                return false;
            }
        }
        if (color == Color.BLACK) {
            if (gb.getField(toX, toY).checkIfAttacked(gb, Color.WHITE)) {
                return false;
            }
        }
        if (toX.column_number == x.column_number - 1 || toX.column_number == x.column_number + 1) {
            if (toY.row_number == y.row_number - 1 || toY.row_number == y.row_number || toY.row_number == y.row_number + 1) {
                return true;
            }
        }
        if (toX.column_number == x.column_number) {
            if (toY.row_number == y.row_number - 1 || toY.row_number == y.row_number + 1) {
                return true;
            }
        }

        return false;
    }

    //checks if this king is under check; returns true if this king is under check
    public boolean checkIfChecked(Gameboard gb) {
        for (Piece piece : gb.getPieces()) {
            if (piece.getColor() != color) {
                if (piece.isValid(gb, x, y)) {
                    return true;
                }
            }
        }
        return false;
    }

    //checks if this king can do the long castling (where rook moves 3 spots)
    public boolean isLongCastlingValid(Gameboard gb) {
        if (color == Color.WHITE) {
            if (number_of_moves == 0) {
                if (gb.getPiece(Column.A, Row.ONE).getColor() == Color.WHITE && gb.getPiece(Column.A, Row.ONE).getNumber_of_moves() == 0 && gb.getPiece(Column.A, Row.ONE) instanceof Rook) {
                    if (gb.getField(Column.B, Row.ONE).getaOccupied() == Occupied.UNOCCUPIED && gb.getField(Column.C, Row.ONE).getaOccupied() == Occupied.UNOCCUPIED && gb.getField(Column.D, Row.ONE).getaOccupied() == Occupied.UNOCCUPIED) {
                        if (!(gb.getField(x, y).checkIfAttacked(gb, Color.BLACK)) && !(gb.getField(Column.C, Row.ONE).checkIfAttacked(gb, Color.BLACK)) && !(gb.getField(Column.D, Row.ONE).checkIfAttacked(gb, Color.BLACK))) {
                            return true;
                        }
                    }
                }
            }
        }
        if (color == Color.BLACK) {
            if (number_of_moves == 0) {
                if (gb.getPiece(Column.A, Row.EIGHT).getColor() == Color.BLACK && gb.getPiece(Column.A, Row.EIGHT).getNumber_of_moves() == 0 && gb.getPiece(Column.A, Row.EIGHT) instanceof Rook) {
                    if (gb.getField(Column.B, Row.EIGHT).getaOccupied() == Occupied.UNOCCUPIED && gb.getField(Column.C, Row.EIGHT).getaOccupied() == Occupied.UNOCCUPIED && gb.getField(Column.D, Row.EIGHT).getaOccupied() == Occupied.UNOCCUPIED) {
                        if (!(gb.getField(x, y).checkIfAttacked(gb, Color.WHITE)) && !(gb.getField(Column.C, Row.EIGHT).checkIfAttacked(gb, Color.WHITE)) && !(gb.getField(Column.D, Row.EIGHT).checkIfAttacked(gb, Color.WHITE))) {
                            return true;
                        }
                    }
                }
            }

        }
        return false;
    }

    //checks if this king can do the short castling (where rook moves 2 spots)
    public boolean isShortCastlingValid(Gameboard gb) {
        if (color == Color.WHITE) {
            if (number_of_moves == 0) {
                if (gb.getPiece(Column.H, Row.ONE).getColor() == Color.WHITE && gb.getPiece(Column.H, Row.ONE).getNumber_of_moves() == 0 && gb.getPiece(Column.H, Row.ONE) instanceof Rook) {
                    if (gb.getField(Column.F, Row.ONE).getaOccupied() == Occupied.UNOCCUPIED && gb.getField(Column.G, Row.ONE).getaOccupied() == Occupied.UNOCCUPIED) {
                        if (!(gb.getField(x, y).checkIfAttacked(gb, Color.BLACK)) && !(gb.getField(Column.F, Row.ONE).checkIfAttacked(gb, Color.BLACK)) && !(gb.getField(Column.G, Row.ONE).checkIfAttacked(gb, Color.BLACK))) {
                            return true;
                        }
                    }
                }
            }
        }
        if (color == Color.BLACK) {
            if (number_of_moves == 0) {
                if (gb.getPiece(Column.H, Row.EIGHT).getColor() == Color.BLACK && gb.getPiece(Column.H, Row.EIGHT).getNumber_of_moves() == 0 && gb.getPiece(Column.H, Row.EIGHT) instanceof Rook) {
                    if (gb.getField(Column.F, Row.EIGHT).getaOccupied() == Occupied.UNOCCUPIED && gb.getField(Column.G, Row.EIGHT).getaOccupied() == Occupied.UNOCCUPIED) {
                        if (!(gb.getField(x, y).checkIfAttacked(gb, Color.WHITE)) && !(gb.getField(Column.F, Row.EIGHT).checkIfAttacked(gb, Color.WHITE)) && !(gb.getField(Column.G, Row.EIGHT).checkIfAttacked(gb, Color.WHITE))) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}