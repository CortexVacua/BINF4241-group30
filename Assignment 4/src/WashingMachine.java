public class WashingMachine implements BaseInterface, Temperature, Switch {
    private boolean system_on = false;
    private  int timer;
    private MyThread washingmachine_thread;
    private long elapsedtime;
    private long starttime;

    WashingMachineState doubleRinseState;
    WashingMachineState intenseState;
    WashingMachineState quickState;
    WashingMachineState spinState;

    WashingMachineState washingMachineState;

    public WashingMachine(){
        doubleRinseState = new WashingDoubleRinseState(this);
        intenseState = new WashingIntenseState(this);
        quickState = new WashingQuickState(this);
        spinState = new WashingSpinState(this);
        timer = 0;
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

    }

    @Override
    public void SetTimer(int time) {
        timer = time*1000;
    }

    @Override
    public void CheckTimer() {

    }

    @Override
    public void Start() {

    }

    @Override
    public void Stop() {

    }
}
