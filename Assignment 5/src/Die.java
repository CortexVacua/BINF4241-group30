//implements the die for the die roll
import java.util.Random;

public class Die  {
    public int roll_die(){
        Random roll = new Random();
        return roll.nextInt(6)+1;
    }
}