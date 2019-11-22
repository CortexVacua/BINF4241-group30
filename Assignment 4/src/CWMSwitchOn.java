public class CWMSwitchOn implements Command {

    WashingMachine washingmachine;

    public CWMSwitchOn(WashingMachine wm){
        washingmachine = wm;
    }

    public void execute() { washingmachine.SwitchOn(); }
}
