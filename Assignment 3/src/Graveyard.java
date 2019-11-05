import java.util.ArrayList;
import java.util.List;

public class Graveyard implements ObserverPieces {

    private List<Piece> Dead_White_Pieces = new ArrayList<>();
    private List<Piece> Dead_Black_Pieces = new ArrayList<>();

    public List<Piece> getDead_White_Pieces() {
        return  Dead_White_Pieces;
    }

    public List<Piece> getDead_Black_Pieces() {
        return  Dead_Black_Pieces;
    }

    @Override
    public void update(Piece dead_piece) {
        if (dead_piece.getColor() == Color.WHITE) Dead_White_Pieces.add(dead_piece);
        else Dead_Black_Pieces.add(dead_piece);
    }
}
