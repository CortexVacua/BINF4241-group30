public class Oven implements BaseInterface, Switch, Temperature{
    private MyThread Ovenmt;
    private Thread Ovenrt;
    private int timer;
    private int temperature;
    private long elapsedtime;
    private long starttime;


    public void SetTimer(int TimeInSeconds) {
        if (TimeInSeconds <= 0) System.out.println("Timer cannot be set to 0 or to a negative value");
        else {
            timer = TimeInSeconds * 1000;
        }
    }

    public int CheckTimer() {
        if (Ovenmt.isRunning()==false)
        System.out.println("Set timer is: "+timer/1000+"\n");
        else {
            elapsedtime=System.currentTimeMillis()-starttime;
            System.out.println("Time remaining: "+(timer-elapsedtime)/1000);
            return 0;
        }
        return 0;
    }

    public void SetTemperature(int TempInCelsius){
        if (TempInCelsius <=0) System.out.println("Temperature cannot be set to 0 or to a negative value");
        else {
            temperature = TempInCelsius;
        }
    }

    public void Start() {
        if (Ovenmt==null) {
            if (timer == 0) System.out.println("No timer set");
            else if (temperature == 0) System.out.println("Temperature has not been set");
            else {
                Ovenmt=new MyThread(timer);
                Ovenrt = new Thread(Ovenmt, "Oven");
                Ovenrt.start();
                starttime = System.currentTimeMillis();
            }
        }
        else System.out.println("Oven already running");
    }

    public void Stop() {

    }


    public void SwitchOn() {

    }


    public void SwitchOff() {

    }
}
