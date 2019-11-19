public class Oven implements BaseInterface, Switch, Temperature{
    private MyThread Ovenmt;
    private Thread Ovenrt;
    private boolean system_on = false;
    private int timer;
    private int temperature;
    private long elapsedtime;
    private long starttime;
    private OvenProgram program;


    public void SetTimer(int TimeInSeconds) {
        if (system_on==true) {
            if (TimeInSeconds <= 0) System.out.println("Timer cannot be set to 0 or to a negative value.");
            else {
                timer = TimeInSeconds * 1000;
            }
        }
        else System.out.println("Oven is switched off.");
    }

    public void CheckTimer() {
        if (system_on==true) {
            if (Ovenmt == null)
                System.out.println("Set timer is: " + timer / 1000 + "\n");
            else {
                elapsedtime = System.currentTimeMillis() - starttime;
                System.out.println("Time remaining: " + (timer - elapsedtime) / 1000);
            }
        }
        else System.out.println("Oven is switched off.");
    }

    public void SetTemperature(int TempInCelsius){
        if (system_on==true) {
            if (TempInCelsius <= 0) System.out.println("Temperature cannot be set to 0 or to a negative value");
            else {
                temperature = TempInCelsius;
            }
        }
        else System.out.println("Oven is switched off.");
    }

    public void SetProgram(OvenProgram DesiredProgram){
        if (system_on==true) {
            program=DesiredProgram;
        }
        else System.out.println("Oven is switched off.");
    }

    public void Start() {
        if (system_on==true) {
            if (Ovenmt == null) {
                if (timer == 0) System.out.println("No timer set!");
                if (temperature == 0) System.out.println("Temperature has not been set.");
                if (program==null) System.out.println("No program selected.");
                else if (timer!=0 && temperature !=0 && program instanceof OvenProgram){
                    Ovenmt = new MyThread(timer);
                    Ovenrt = new Thread(Ovenmt, "Oven");
                    Ovenrt.start();
                    starttime = System.currentTimeMillis();
                    System.out.println("The oven is running");
                }
            } else System.out.println("Oven already running.");
        }
        else System.out.println("Oven is switched off.");
    }

    public void Stop() {
        if (system_on==true) {
            Ovenmt=null;
            Ovenrt=null;
            timer=0;
            temperature=0;
            elapsedtime=0;
            starttime=0;
        }
        else system_on=true;
    }


    public void SwitchOn() {
        if (system_on==true) System.out.println("Oven is already switched on.");
        else system_on=true;

    }


    public void SwitchOff() {
        if (system_on == true) system_on = false;
        else System.out.println("Oven is switched off.");
    }
}
