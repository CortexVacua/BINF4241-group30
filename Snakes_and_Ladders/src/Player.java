public class Player {
    private String name;
    protected int square_number;

    public void change_sq_num(int num){
        square_number=num;
    }

    public Player(String playerName, int number) {
        this.name = playerName;
        this.square_number = number;
    }
}
