import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LastSquareTest {

//  Tests if the last square is the last square in gameboard.
    @Test
    public void last_square_test() {

        Gameboard test_board = new Gameboard();
        test_board.board_size = 10;

        LastSquare test_square = new LastSquare();
        int test_number = test_square.get_square_number();

        assertEquals(10,test_number);
    }
}