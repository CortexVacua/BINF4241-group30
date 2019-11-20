public class WashingDoubleRinseState implements WashingMachineState {
    int time = 300;
    WashingMachine washingmachine;

    public WashingDoubleRinseState(WashingMachine wm){
        this.washingmachine = wm;
    }

    @Override
    public void setTimer() {
        washingmachine.SetTimer(time);
        System.out.print("Washing machine is now set to use the double rinse washing method.\n");
    }
}
