public interface ObservablePieces {
    public void registerObserver(ObserverPieces observerPieces);
    public void removeObserver(ObserverPieces observerPieces);
    public void notifyObserver(Piece dead_piece);
}
