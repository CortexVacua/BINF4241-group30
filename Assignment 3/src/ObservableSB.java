public interface ObservableSB {
//    Observable for the ScoreBoard
    public void registerObserver(ObserverSB aObserver);
    public void removeObserver(ObserverSB aObserver);
    public void notifyObserver(Piece dead_piece);
}
