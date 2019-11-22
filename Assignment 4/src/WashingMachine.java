public class WashingMachine implements BaseInterface, Temperature, Switch {
    private boolean system_on = false;
    private int temperature;
    private  int timer;
    private MyThread washingmachine_mythread;
    private Thread washingmachine_thread;
    private long elapsedtime;
    private long starttime;

    WashingMachineState doubleRinseState;
    WashingMachineState intenseState;
    WashingMachineState quickState;
    WashingMachineState spinState;

    WashingMachineState washingmachine_state;

    public WashingMachine(){
        doubleRinseState = new WashingDoubleRinseState(this);
        intenseState = new WashingIntenseState(this);
        quickState = new WashingQuickState(this);
        spinState = new WashingSpinState(this);
        timer = 0;
        temperature = 0;
    }

    @Override
    public void SwitchOn() {
        if (system_on==false) {
            system_on = true;
            System.out.print("Washing machine is switched on successfully.\n");
        }
        else System.out.print("Washing machine is already switched on.\n");
    }

    @Override
    public void SwitchOff() {
        if (system_on == true) {
            system_on = false;
            System.out.print("Washing machine is switched off successfully.\n");
        }
        else System.out.print("Washing machine is already switched off.\n");
    }

    @Override
    public void SetTemperature(int TemperatureInCelsius) {
        if(system_on == true){
            if(TemperatureInCelsius <= 0) System.out.print("Cannot wash clothes with frozen water.\n");
            else if (TemperatureInCelsius >= 100) System.out.print("Cannot wash clothes with boiling water.\n");
            else temperature = TemperatureInCelsius;
        }
        else System.out.print("Washing machine is switched off. \n");

    }

    public void chooseProgram(WashingMachineState state){
        if(system_on == true){
            washingmachine_state = state;
            washingmachine_state.setTimer();
        }
        else System.out.print("Washing machine is switched off.\n");
    }

    @Override
    public void SetTimer(int time) {
        timer = time*1000;
    }

    @Override
    public void CheckTimer() {
        if(system_on = true){
            if(washingmachine_mythread == null){
                System.out.print("Set timer is: " +timer / 1000 + " seconds.\n");
            }
            else{
                elapsedtime = System.currentTimeMillis() - starttime;
                System.out.print("Time remaining: " + (timer - elapsedtime) / 1000 + " seconds.\n");
            }
        }
        else System.out.print("Washing machine is switched off.\n");
    }

    @Override
    public void Start() {
        if(system_on == true){
            if(washingmachine_mythread == null){
                if(washingmachine_state == null) System.out.print("No washing machine method set.\n");
                else if (temperature <= 0 || temperature >= 100 ) System.out.print("No temperature set.\n");
                else if(washingmachine_state instanceof WashingMachineState){
                    washingmachine_mythread = new MyThread(timer);
                    washingmachine_thread = new Thread(washingmachine_mythread, "Washing machine");
                    washingmachine_thread.start();
                    starttime = System.currentTimeMillis();
//                    IS RUNNING DOESNT FUNCTION
//                    is_running = washingmachine_mythread.isRunning();
//                    System.out.print(washingmachine_mythread.isRunning());
                    System.out.print("Washing machine is running.\n");
                }
            }
            else System.out.print("Washing machine is already running.\n");
        }
        else System.out.print("Washing machine is switched off.\n");
    }

    @Override
    public void Stop() {
        if(system_on == true){
            if(washingmachine_mythread == null) {
                washingmachine_mythread = null;
                washingmachine_thread = null;
                washingmachine_state = null;
                temperature = 0;
                timer = 0;
                starttime = 0;
                elapsedtime = 0;
                System.out.print("Washing machine was forced to stop washing. QwQ\n");
            }
            else System.out.print("Washing machine is still running.\n");
        }
        else System.out.print("Washing machine is switched off.\n");
    }
}

