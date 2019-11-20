public class WashingIntenseState implements WashingMachineState {
    int time = 36000;
    WashingMachine washingmachine;

    public WashingIntenseState(WashingMachine wm){
        this.washingmachine = wm;
    }

    @Override
    public void setTimer() {
        washingmachine.SetTimer(time);
        System.out.print("Washing machine is now set to wash intensively.\n");
    }
}
