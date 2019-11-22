public class CWMSwitchOff implements Command {

    WashingMachine washingmachine;

    public CWMSwitchOff(WashingMachine wm){
        washingmachine = wm;
    }

    public void execute() { washingmachine.SwitchOff(); }
}
