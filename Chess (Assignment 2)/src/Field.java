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
}