import java.util.Scanner;

public class OvenSetTimer implements Command{
    Oven oven;
    int TimeInSeconds;

    public OvenSetTimer(Oven o){
        oven=o;
    }
    public void execute(){
        System.out.println("Please set your timer in seconds: \n");
        Scanner myObj = new Scanner(System.in);
        if (myObj.hasNextInt()) {
            TimeInSeconds = myObj.nextInt();
            oven.SetTimer(TimeInSeconds);
        }
        else {
            System.out.println("Invalid Input! Try again. \n");
            this.execute();
        }
    }
}