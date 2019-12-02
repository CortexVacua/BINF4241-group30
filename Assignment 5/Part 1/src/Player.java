//implements player
public class Player {
    private String name;
    protected int square_number;

    public String get_player_name(){
        return this.name;
    }

    public int get_player_number(){
        return this.square_number;
    }

//  responsible for changing the players square
    public void change_sq_num(int num){
        square_number=num;
    }

    public Player(String playerName, int number) {
        this.name = playerName;
        this.square_number = number;
    }
}
