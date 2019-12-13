import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SquareTest {

//  Tests if you can get the correct number from a square
    @Test
    public void get_square_number_test() {
        Square test_square = new Square(5);
        int test_number = test_square.get_square_number();
        assertEquals(5,test_number);
    }

//  Tests if the square can be properly occupied/unoccupied
    @Test
    public void occupation_test() {
        Square test_square = new Square(5);
        int test_beforeOccupied = test_square.isOccupied();
        test_square.ChangeOccupiedState();
        int test_isOccupied = test_square.isOccupied();
        test_square.ChangeOccupiedState();
        int test_afterOccupied = test_square.isOccupied();
        assertEquals(0,test_beforeOccupied);
        assertEquals(1,test_isOccupied);
        assertEquals(0,test_afterOccupied);
    }

}