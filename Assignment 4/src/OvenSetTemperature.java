import java.util.Scanner;

public class OvenSetTemperature {
    Oven oven;
    int Temp;

    public OvenSetTemperature(Oven o){
        oven=o;
    }
    public void execute(){
        System.out.println("Please set your timer in seconds: \n");
        Scanner myObj = new Scanner(System.in);
        if (myObj.hasNextInt()) {
            Temp = myObj.nextInt();
            oven.SetTemperature(Temp);
        }
        else {
            System.out.println("Invalid Input! Try again. \n");
            this.execute();
        }
    }
}
