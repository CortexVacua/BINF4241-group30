import java.util.Random;

public class Die  {
    int roll_die(){
        Random roll = new Random();
        return roll.nextInt(6)+1;
    }
}