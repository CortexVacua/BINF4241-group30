public class Field {
    private Color aColor;
    private Row aRow;
    private Column aColumn;
    private Occupied aOccupied;

    public Field (Color pColor, Row pRow, Column pColumn,Occupied pOccupied){
        aColor=pColor;
        aRow=pRow;
        aColumn = pColumn;
        aOccupied=pOccupied;
    }
    public Field(Field f) {
        this.aColor = f.getaColor();
        this.aRow = f.getaRow();
        this.aColumn = f.getaColumn();
        this.aOccupied = f.getaOccupied();
    }

    public void occupy () {
        this.aOccupied = Occupied.OCCUPIED;
    }

    public void unoccupy () {
        this.aOccupied = Occupied.UNOCCUPIED;
    }

    public Color getaColor() {
        return aColor;
    }

    public Column getaColumn() {
        return aColumn;
    }

    public Occupied getaOccupied() {
        return aOccupied;
    }

    public Row getaRow() {
        return aRow;
    }

    //checks if a piece attacks this field; returns true if attacked
    public boolean checkIfAttacked(Gameboard gb) {
        for(Piece piece : gb.getPieces()) {
            if(piece.isValid(gb, aColumn, aRow)) {
                return true;
            }
        }
        return false;
    }
    // checks if pieces of a given color attack this field; returns true if attacked
    public boolean checkIfAttacked(Gameboard gb, Color color) {
        for(Piece piece : gb.getPieces()) {
            if (piece.getColor() == color) {
                if(piece.isValid(gb, aColumn, aRow)) {
                    return true;
                }
            }
        }
        return false;
    }
}
