//implements snakes
public class Snake extends LadderSnake{
    // always puts the player 4 squares backwards
    public Snake(int start_square) {
        super(start_square, start_square -4);
        }
    }

