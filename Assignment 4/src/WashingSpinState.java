public class WashingSpinState implements WashingMachineState {
    int time = 200;
    WashingMachine washingmachine;

    public WashingSpinState(WashingMachine wm){
        this.washingmachine = wm;
    }

    @Override
    public void setTimer() {
        washingmachine.SetTimer(time);
        System.out.print("Washing machine is now set to use the spin washing method.\n");
    }
}
