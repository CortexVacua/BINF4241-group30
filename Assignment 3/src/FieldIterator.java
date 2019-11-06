import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FieldIterator implements Iterator {
    private List<Field> Fields = new ArrayList<>();
    private int position;

    public FieldIterator() {
        position = 0;
        Color color = Color.BLACK;
        for(Row row : Row.values()) {
            for (Column column : Column.values()) {
                if (color == Color.BLACK) {
                    Fields.add(new Field(Color.BLACK, row, column, Occupied.UNOCCUPIED));
                    if (column != Column.H) {
                        color = Color.WHITE;
                    }
                } else {
                    Fields.add(new Field(Color.WHITE, row, column, Occupied.UNOCCUPIED));
                    if (column != Column.H) {
                        color = Color.BLACK;
                    }
                }
            }
        }
    }


    public Field next() {
        Field field = Fields.get(position);
        position ++;
        return field;
    }

    public boolean hasNext() {
        if (position >= Fields.size() || Fields.get(position) == null) {
            return false;
        }
        else {
            return true;
        }
    }
}
