public class WashingQuickState implements WashingMachineState {
    int time = 10;
    WashingMachine washingmachine;

    public WashingQuickState(WashingMachine wm){
        this.washingmachine = wm;
    }

    @Override
    public void setTimer() {
        washingmachine.SetTimer(time);
        System.out.print("Washing machine is now set to wash super fast.\n");
    }
}
