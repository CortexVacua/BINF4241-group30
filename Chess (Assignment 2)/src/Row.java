public enum Row {
    ONE (1),
    TWO (2),
    THREE (3),
    FOUR (4),
    FIVE (5),
    SIX (6),
    SEVEN (7),
    EIGHT (8);

    public final int row_number;

    private Row(int row_number){
        this.row_number = row_number;
    }

    public int get_row_number() {
        return row_number;
    }
}
