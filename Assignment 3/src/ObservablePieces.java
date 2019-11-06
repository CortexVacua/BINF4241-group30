import java.util.List;

public interface ObservablePieces {
    public void registerObserver(ObserverPieces observerPieces);
    public void removeObserver(ObserverPieces observerPieces);
    public void notifyObserver(ObservablePieces game,Player current_player,List<Piece> pieces_list, Row aRow, Column aColumn);
}
