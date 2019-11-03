import java.util.ArrayList;
import java.util.List;

public class Player implements ObservableSB {
    private Color color;
    private String name;
    private List<Piece> captured_pieces= new ArrayList<Piece>();
    private List<ObserverSB> subscribed_observers= new ArrayList<ObserverSB>();

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
        notifyObserver(dead_piece);
    }

    public void registerObserver (ObserverSB aObserver){
        subscribed_observers.add(aObserver);
    }

    public void removeObserver(ObserverSB aObserver) {
        for (int i=0 ; i<subscribed_observers.size(); i++){
            if (subscribed_observers.get(i)==aObserver) subscribed_observers.remove(i);
        }
    }

    public void notifyObserver(Piece dead_piece) {
        for (int i=0 ; i<subscribed_observers.size(); i++){
            subscribed_observers.get(i).update(dead_piece);
        }
    }
}
