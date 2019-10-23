public class Pawn extends Piece {

    public Pawn (Row pRow, Column pColumn, Color pColor){
        super();
        this.y=pRow;
        this.x=pColumn;
        this.color=pColor;
        this.number_of_moves=0;
    }
    public Pawn(Pawn p) {
        super();
        this.y = p.getRow();
        this.x = p.getColumn();
        this.color = p.getColor();
        this.number_of_moves = p.getNumber_of_moves();
    }

    // Checks whether the piece is allowed to do this kind of move; capture of potential pieces has to be checked by game class.
    //TODO: promotion
    public boolean isValid(Gameboard gb, Column toX, Row toY) {
        if (!super.isValid(gb, toX, toY)) {
            return false;
        }
        if (number_of_moves == 0) {
            if (color == Color.WHITE) {
                if (toX.column_number == x.column_number) {
                    if (toY.row_number == y.row_number + 1) {
                        if(gb.getField(toX, toY).getaOccupied() == Occupied.UNOCCUPIED) {
                            return true;
                        }
                    }
                    if (toY.row_number == y.row_number + 2) {
                        Row row = Row.values()[y.row_number +1 -1];
                        if(gb.getField(toX, toY).getaOccupied() == Occupied.UNOCCUPIED && gb.getField(toX, row).getaOccupied() == Occupied.UNOCCUPIED) {
                            return true;
                        }
                    }
                }
                if (toY.row_number == y.row_number +1 && (toX.column_number == x.column_number -1 || toX.column_number == x.column_number +1)) {
                    if (gb.getPiece(toX, toY) != null) {
                        if (gb.getPiece(toX, toY).getColor() == Color.BLACK) {
                            return true;
                        }
                    }
                }
            }
            if (color == Color.BLACK) {
                if (toX.column_number == x.column_number) {
                    if (toY.row_number == y.row_number - 1) {
                        if(gb.getField(toX, toY).getaOccupied() == Occupied.UNOCCUPIED) {
                            return true;
                        }
                    }
                    if (toY.row_number == y.row_number - 2) {
                        Row row = Row.values()[y.row_number -1 -1];
                        if(gb.getField(toX, toY).getaOccupied() == Occupied.UNOCCUPIED && gb.getField(toX, row).getaOccupied() == Occupied.UNOCCUPIED) {
                            return true;
                        }
                    }
                }
                if (toY.row_number == y.row_number -1 && (toX.column_number == x.column_number -1 || toX.column_number == x.column_number +1)) {
                    if (gb.getPiece(toX, toY) != null) {
                        if (gb.getPiece(toX, toY).getColor() == Color.WHITE) {
                            return true;
                        }
                    }
                }
            }
        } else {
            if (color == Color.WHITE) {
                if (toX.column_number == x.column_number) {
                    if (toY.row_number == y.row_number + 1) {
                        if (gb.getField(toX, toY).getaOccupied() == Occupied.UNOCCUPIED) {
                            return true;
                        }
                    }
                }
                if (toY.row_number == y.row_number +1 && (toX.column_number == x.column_number -1 || toX.column_number == x.column_number +1)) {
                    if (gb.getPiece(toX, toY) != null) {
                        if (gb.getPiece(toX, toY).getColor() == Color.BLACK) {
                            return true;
                        }
                    }
                }
            }
            if (color == Color.BLACK) {
                if (toX.column_number == x.column_number) {
                    if (toY.row_number == y.row_number - 1) {
                        if (gb.getField(toX, toY).getaOccupied() == Occupied.UNOCCUPIED) {
                            return true;
                        }
                    }
                }
                if (toY.row_number == y.row_number - 1 && (toX.column_number == x.column_number - 1 || toX.column_number == x.column_number + 1)) {
                    if (gb.getPiece(toX, toY) != null) {
                        if (gb.getPiece(toX, toY).getColor() == Color.WHITE) {
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }
    //checks if this en passant move is valid
    public boolean isValidEnPassant(Gameboard gb, Column toX, Row toY) {
        if (color == Color.WHITE) {
            if (y.row_number == 5) {
                if(toY.row_number == 6 && (toX.column_number == x.column_number +1 || toX.column_number == x.column_number -1)) {
                    if (gb.getPiece(toX, y) instanceof Pawn && gb.getPiece(toX, y).getColor() == Color.BLACK && gb.getPiece(toX, y).getNumber_of_moves() == 1 ) {
                        return true;
                    }
                }
            }
        }
        if (color == Color.BLACK) {
            if (y.row_number == 4) {
                if(toY.row_number == 3 && (toX.column_number == x.column_number +1 || toX.column_number == x.column_number -1)) {
                    if (gb.getPiece(toX, y) instanceof Pawn && gb.getPiece(toX, y).getColor() == Color.WHITE && gb.getPiece(toX, y).getNumber_of_moves() == 1) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean isValidForKing(Gameboard gb, Column toX, Row toY) {
        if (!super.isValidForKing(gb, toX, toY)) {
            return false;
        }
        if (number_of_moves == 0) {
            if (color == Color.WHITE) {
                if (toX.column_number == x.column_number) {
                    if (toY.row_number == y.row_number + 1) {
                        if(gb.getField(toX, toY).getaOccupied() == Occupied.UNOCCUPIED) {
                            return true;
                        }
                    }
                    if (toY.row_number == y.row_number + 2) {
                        Row row = Row.values()[y.row_number +1 -1];
                        if(gb.getField(toX, toY).getaOccupied() == Occupied.UNOCCUPIED && gb.getField(toX, row).getaOccupied() == Occupied.UNOCCUPIED) {
                            return true;
                        }
                    }
                }
                if (toY.row_number == y.row_number +1 && (toX.column_number == x.column_number -1 || toX.column_number == x.column_number +1)) {
                    if (gb.getPiece(toX, toY) != null) {
                        if (gb.getPiece(toX, toY).getColor() == Color.BLACK) {
                            return true;
                        }
                    }
                }
            }
            if (color == Color.BLACK) {
                if (toX.column_number == x.column_number) {
                    if (toY.row_number == y.row_number - 1) {
                        if(gb.getField(toX, toY).getaOccupied() == Occupied.UNOCCUPIED) {
                            return true;
                        }
                    }
                    if (toY.row_number == y.row_number - 2) {
                        Row row = Row.values()[y.row_number -1 -1];
                        if(gb.getField(toX, toY).getaOccupied() == Occupied.UNOCCUPIED && gb.getField(toX, row).getaOccupied() == Occupied.UNOCCUPIED) {
                            return true;
                        }
                    }
                }
                if (toY.row_number == y.row_number -1 && (toX.column_number == x.column_number -1 || toX.column_number == x.column_number +1)) {
                    if (gb.getPiece(toX, toY) != null) {
                        if (gb.getPiece(toX, toY).getColor() == Color.WHITE) {
                            return true;
                        }
                    }
                }
            }
        } else {
            if (color == Color.WHITE) {
                if (toX.column_number == x.column_number) {
                    if (toY.row_number == y.row_number + 1) {
                        if (gb.getField(toX, toY).getaOccupied() == Occupied.UNOCCUPIED) {
                            return true;
                        }
                    }
                }
                if (toY.row_number == y.row_number +1 && (toX.column_number == x.column_number -1 || toX.column_number == x.column_number +1)) {
                    if (gb.getPiece(toX, toY) != null) {
                        if (gb.getPiece(toX, toY).getColor() == Color.BLACK) {
                            return true;
                        }
                    }
                }
            }
            if (color == Color.BLACK) {
                if (toX.column_number == x.column_number) {
                    if (toY.row_number == y.row_number - 1) {
                        if (gb.getField(toX, toY).getaOccupied() == Occupied.UNOCCUPIED) {
                            return true;
                        }
                    }
                }
                if (toY.row_number == y.row_number - 1 && (toX.column_number == x.column_number - 1 || toX.column_number == x.column_number + 1)) {
                    if (gb.getPiece(toX, toY) != null) {
                        if (gb.getPiece(toX, toY).getColor() == Color.WHITE) {
                            return true;
                        }
                    }
                }

            }
        }
        return false;
    }
}
