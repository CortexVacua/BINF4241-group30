public interface ObservablePieces {
    public void registerObserver(ObserverSB pObserver);
    public void removeObserver(ObserverSB pObserver);
    public void notifyObserver(Piece dead_piece);
}
