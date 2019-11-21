import java.util.Scanner;

public class OvenSetTemperature implements Command{
    Oven oven;
    int Temp;

    public OvenSetTemperature(Oven o){
        oven=o;
    }

//    sets temperature
    public void execute(){
        System.out.println("Please set your desired temperature in celsius: \n");
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
