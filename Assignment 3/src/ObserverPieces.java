import java.util.List;

public interface ObserverPieces {
    public void update(ObservablePieces game,Player current_player,List<Piece> pieces_list, Row aRow, Column aColumn);
}
