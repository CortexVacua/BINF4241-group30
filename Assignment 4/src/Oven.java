public class Oven implements BaseInterface, Switch, Temperature{
    private MyThread Ovenmt;
    private Thread Ovenrt;
    public boolean system_on = false;
    private int timer;
    private int temperature;
    private long elapsedtime;
    private long starttime;
    private OvenProgram program;

//sets the timer
    public void SetTimer(int TimeInSeconds) {
        if (system_on==true) {
            if (TimeInSeconds <= 0) System.out.println("Timer cannot be set to 0 or to a negative value.\n");
            else {
                timer = TimeInSeconds * 1000;
                System.out.println("Timer set.\n");
            }
        }
        else System.out.println("Oven is switched off.\n");
    }

//    checks timer
    public void CheckTimer() {
        if (system_on==true) {
            if (Ovenmt == null)
                System.out.println("Set timer is: " + timer / 1000 + "\n");
            else {
                if (Ovenmt.isRunning()) {
                    elapsedtime = System.currentTimeMillis() - starttime;
                    System.out.println("Time remaining: " + (timer - elapsedtime) / 1000 + "\n");
                }
                else System.out.println("Set timer is: " + timer / 1000 + "\n");
            }
        }
        else System.out.println("Oven is switched off.\n");
    }

//    sets temperature
    public void SetTemperature(int TempInCelsius){
        if (system_on==true) {
            if (TempInCelsius <= 0) System.out.println("Temperature cannot be set to 0 or to a negative value.\n");
            else {
                temperature = TempInCelsius;
                System.out.println("Temperature set.\n");
            }
        }
        else System.out.println("Oven is switched off.\n");
    }

//   sets program
    public void SetProgram(OvenProgram DesiredProgram){
        if (system_on==true) {
            program=DesiredProgram;
            System.out.println("Program set.\n");
        }
        else System.out.println("Oven is switched off.\n");
    }

//    starts oven
    public void Start() {
        if (system_on==true) {
            if (Ovenmt == null) {
                if (timer == 0) System.out.println("No timer set!\n");
                if (temperature == 0) System.out.println("Temperature has not been set.\n");
                if (program==null) System.out.println("No program selected.\n");
                else if (timer!=0 && temperature !=0 && program instanceof OvenProgram){
                    Ovenmt = new MyThread(timer);
                    Ovenrt = new Thread(Ovenmt, "oven");
                    Ovenrt.start();
                    starttime = System.currentTimeMillis();
                    System.out.println("The oven is running.\n");
                }
            }
            else if (Ovenmt.isRunning()==false) Ovenrt.start();
            else System.out.println("Oven already running.\n");
        }
        else System.out.println("Oven is switched off.\n");
    }

//    stops the oven
    public void Stop() {
        if (system_on==true) {
            if(Ovenmt!=null && Ovenmt.isRunning()) {
                Ovenmt = null;
                Ovenrt = null;
                timer = 0;
                temperature = 0;
                elapsedtime = 0;
                starttime = 0;
                program=null;
            }
            else System.out.println("The oven does not seem to be running any program you could stop.\n");
        }
        else System.out.println("Oven is switched off.\n");
    }

//switches oven on
    public void SwitchOn() {
        if (system_on==true) System.out.println("Oven is already switched on.\n");
        else {
            system_on=true;
            System.out.println("Oven has been switched on.\n");
        }

    }

//switches oven off
    public void SwitchOff() {
        if (system_on == true) {
            system_on = false;
            Ovenmt = null;
            Ovenrt = null;
            timer = 0;
            temperature = 0;
            elapsedtime = 0;
            starttime = 0;
            System.out.println("Oven has been switched off.\n");
        }
        else System.out.println("Oven is already switched off.\n");
    }
}
