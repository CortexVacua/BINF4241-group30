public class Bishop extends Piece {

    public Bishop(Row pRow, Column pColumn, Color pColor) {
        super();
        this.y = pRow;
        this.x = pColumn;
        this.color = pColor;
        this.number_of_moves = 0;
    }
    public Bishop(Bishop b) {
        super();
        this.y = b.getRow();
        this.x = b.getColumn();
        this.color = b.getColor();
        this.number_of_moves = b.getNumber_of_moves();
    }

    // Checks whether the piece is allowed to do this kind of move; capture of potential pieces has to be checked by game class.
    public boolean isValid(Gameboard gb, Column toX, Row toY) {
        if (!super.isValid(gb, toX, toY)) {
            return false;
        }
        if (Math.abs(toX.column_number - x.column_number) == Math.abs(toY.row_number - y.row_number)) {
            int vertical_distance = toY.row_number - y.row_number;
            int horizontal_distance = toX.column_number - x.column_number;
//            if (Math.abs(vertical_distance) >= 2) {
                if (horizontal_distance > 0) {
                    if (vertical_distance > 0) {
                        for (int i = 1; i < vertical_distance; i++) {
                            Row row = Row.values()[y.row_number + i - 1];
                            Column column = Column.values()[x.column_number + i - 1];
                            if (gb.getField(column, row).getaOccupied() == Occupied.OCCUPIED) {
                                return false;
                            }
                        }
                    }
                    if (vertical_distance < 0) {
                        for (int i = 1; i < Math.abs(vertical_distance); i++) {
                            Row row = Row.values()[y.row_number - i - 1];
                            Column column = Column.values()[x.column_number + i - 1];
                            if (gb.getField(column, row).getaOccupied() == Occupied.OCCUPIED) {
                                return false;
                            }
                        }
                    }
                }
                if (horizontal_distance < 0) {
                    if (vertical_distance > 0) {
                        for (int i = 1; i < vertical_distance; i++) {
                            Row row = Row.values()[y.row_number + i - 1];
                            Column column = Column.values()[x.column_number - i - 1];
                            if (gb.getField(column, row).getaOccupied() == Occupied.OCCUPIED) {
                                return false;
                            }
                        }
                    }
                    if (vertical_distance < 0) {
                        for (int i = 1; i < Math.abs(vertical_distance); i++) {
                            Row row = Row.values()[y.row_number - i - 1];
                            Column column = Column.values()[x.column_number - i - 1];
                            if (gb.getField(column, row).getaOccupied() == Occupied.OCCUPIED) {
                                return false;
                            }
                        }
                    }
                }
//            }
            return true;
        }
        return false;
    }
    public boolean isValidForKing(Gameboard gb, Column toX, Row toY) {
        if (!super.isValidForKing(gb, toX, toY)) {
            return false;
        }
        if (Math.abs(toX.column_number - x.column_number) == Math.abs(toY.row_number - y.row_number)) {
            int vertical_distance = toY.row_number - y.row_number;
            int horizontal_distance = toX.column_number - x.column_number;
//            if (Math.abs(vertical_distance) >= 2) {
                if (horizontal_distance > 0) {
                    if (vertical_distance > 0) {
                        for (int i = 1; i < vertical_distance; i++) {
                            Row row = Row.values()[y.row_number + i - 1];
                            Column column = Column.values()[x.column_number + i - 1];
                            if (gb.getField(column, row).getaOccupied() == Occupied.OCCUPIED) {
                                return false;
                            }
                        }
                    }
                    if (vertical_distance < 0) {
                        for (int i = 1; i < Math.abs(vertical_distance); i++) {
                            Row row = Row.values()[y.row_number - i - 1];
                            Column column = Column.values()[x.column_number + i - 1];
                            if (gb.getField(column, row).getaOccupied() == Occupied.OCCUPIED) {
                                return false;
                            }
                        }
                    }
                }
                if (horizontal_distance < 0) {
                    if (vertical_distance > 0) {
                        for (int i = 1; i < vertical_distance; i++) {
                            Row row = Row.values()[y.row_number + i - 1];
                            Column column = Column.values()[x.column_number - i - 1];
                            if (gb.getField(column, row).getaOccupied() == Occupied.OCCUPIED) {
                                return false;
                            }
                        }
                    }
                    if (vertical_distance < 0) {
                        for (int i = 1; i < Math.abs(vertical_distance); i++) {
                            Row row = Row.values()[y.row_number - i - 1];
                            Column column = Column.values()[x.column_number - i - 1];
                            if (gb.getField(column, row).getaOccupied() == Occupied.OCCUPIED) {
                                return false;
                            }
                        }
                    }
                }
//            }
            return true;
        }
        return false;
    }
}
