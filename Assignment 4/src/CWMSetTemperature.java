import java.util.Scanner;

public class CWMSetTemperature implements Command {

    WashingMachine washingmachine;
    int temperature;

    public CWMSetTemperature(WashingMachine wm){ washingmachine = wm; }

    @Override
    public void execute() {
        System.out.println("Please set your desired temperature in celsius: \n");
        Scanner myObj = new Scanner(System.in);
        if (myObj.hasNextInt()) {
            temperature = myObj.nextInt();
            washingmachine.SetTemperature(temperature);
        }
        else {
            System.out.println("Invalid Input! Try again. \n");
            this.execute();
        }
    }
}
