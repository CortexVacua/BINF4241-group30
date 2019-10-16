public enum Column {
    A (1),
    B (2),
    C (3),
    D (4),
    E (5),
    F (6),
    G (7),
    H (8);

    public final int column_number;

    private Column(int column_number){
        this.column_number = column_number;
    }

    public int get_column_number() {
        return column_number;
    }
}
