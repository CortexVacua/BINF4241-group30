import java.util.Scanner;

public class MicrSetTemperature implements Command{
    Microwave micr;
    int Temp;

    public MicrSetTemperature(Microwave m){
        micr=m;
    }

//    sets temperature
    public void execute(){
        System.out.println("Please set your desired temperature in celsius: \n");
        Scanner myObj = new Scanner(System.in);
        if (myObj.hasNextInt()) {
            Temp = myObj.nextInt();
            micr.SetTemperature(Temp);
        }
        else {
            System.out.println("Invalid Input! Try again. \n");
            this.execute();
        }
    }
}
