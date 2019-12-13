import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Queue;
import static org.junit.jupiter.api.Assertions.*;

class GameboardTest {

//    Tests if the gameboard can be initialized
//    @Test
//    public void initialize_gameboard() {
//        String input = String.format("6%n2%nJotaro%nDio%n"); // %n == Enter
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        Gameboard test_board = new Gameboard();
//        test_board.init();
//
//        int test_board_size = test_board.get_board_size();
//        int test_player_size = test_board.number_of_players;
//        Queue<Player> test_player_list = test_board.list_of_players;
//        Player test_player = test_player_list.remove();
//
//        assertEquals(6, test_board_size);
//        assertEquals(2, test_player_size);
//        assertEquals("Jotaro", test_player.get_player_name());
//        assertEquals(1, test_player.get_player_number());
//    }
//
//    Tests what happens if the gameboard gets wrong inputs (string instead of integer)
//    @Test
//    public void wrong_initialize() {
//        String input = String.format("abc%ndef%n100%nabc%ndef%n4%nJotaro%nDio%nGiorno%nDiavolo%n"); // %n == Enter
//        InputStream in = new ByteArrayInputStream(input.getBytes());
//        System.setIn(in);
//
//        Gameboard test_board = new Gameboard();
//        test_board.init();
//
//        int test_board_size = test_board.get_board_size();
//        int test_player_size = test_board.number_of_players;
//        Queue<Player> test_player_list = test_board.list_of_players;
//        Player test_player = test_player_list.remove();
//
//        assertEquals(100, test_board_size);
//        assertEquals(4, test_player_size);
//        assertEquals("Jotaro", test_player.get_player_name());
//        assertEquals(1, test_player.get_player_number());
//    }
}