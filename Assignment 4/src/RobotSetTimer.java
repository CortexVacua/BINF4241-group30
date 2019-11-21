import java.util.Scanner;

public class RobotSetTimer implements Command{
    CleaningRobot rbt;
    int TimeInSeconds;

    public RobotSetTimer(CleaningRobot r){
        rbt=r;
    }

    //    sets timer
    public void execute(){
        System.out.println("Please set your timer in seconds: \n");
        Scanner myObj = new Scanner(System.in);
        if (myObj.hasNextInt()) {
            TimeInSeconds = myObj.nextInt();
            rbt.SetTimer(TimeInSeconds);
        }
        else {
            System.out.println("Invalid Input! Try again. \n");
            this.execute();
        }
    }
}