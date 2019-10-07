import java.util.Queue;

public class Printer {

    public void initialize(Queue<Player> list_of_players){
        System.out.println("");
        System.out.print("Initial State: ");
        for (int i=1 ; i<=list_of_players.size() ; i++){
            Player player = list_of_players.remove();
            System.out.println(player.get_player_name() + player.get_player_number());
            list_of_players.add(player);
        }
    }
}
