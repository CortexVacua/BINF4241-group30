import java.util.Scanner;

public class MicrSetTimer implements Command{
    Microwave micr;
    int TimeInSeconds;

    public MicrSetTimer(Microwave m){
        micr=m;
    }

//    sets timer
    public void execute(){
        System.out.println("Please set your timer in seconds: \n");
        Scanner myObj = new Scanner(System.in);
        if (myObj.hasNextInt()) {
            TimeInSeconds = myObj.nextInt();
            micr.SetTimer(TimeInSeconds);
        }
        else {
            System.out.println("Invalid Input! Try again. \n");
            this.execute();
        }
    }
}