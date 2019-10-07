public class Ladder extends LadderSnake{
    // always puts the player 4 squares forward
    public Ladder(int start_square) {
        super(start_square, start_square +4);
    }
}
