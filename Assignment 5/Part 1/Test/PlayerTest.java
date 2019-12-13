import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

//  Tests if it's possible to get the player number
    @Test
    public void test_get_player_number() {
        Player test_player = new Player("Jotaro",3);
        int test_number = test_player.get_player_number();
        assertEquals(3,test_number);
    }

//  Tests if you can get the player's name
    @Test
    public void test_get_player_name() {
        Player test_player = new Player("Josuke",4);
        String test_name = test_player.get_player_name();
        assertEquals("Josuke",test_name);
    }

//  Tests if you can replace the player in another square
    @Test
    void test_change_number() {
        Player test_player = new Player("Jolyne",6);
        test_player.change_sq_num(5);
        int test_number = test_player.get_player_number();
        assertEquals(5,test_number);
    }

}