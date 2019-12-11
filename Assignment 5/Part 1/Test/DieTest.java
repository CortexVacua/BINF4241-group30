import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DieTest {

    @Test
    public void roll_die_test() {
        Die test_die = new Die();
        int[] test_list = new int[100];
        for (int i = 0 ; i < 100 ; i++){
            test_list[i] = test_die.roll_die();
            assertTrue(test_list[i]<=6 && test_list[i]>=1);
        }

    }
}