import java.util.ArrayList;
import java.util.List;

public class Player {
    private Color color;
    private String name;
    private List<Piece> captured_pieces= new ArrayList<Piece>();

    public Player(Color color,String name) {
        this.color = color;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public void add_captures(Piece dead_piece){
        captured_pieces.add(dead_piece);
    }
}
