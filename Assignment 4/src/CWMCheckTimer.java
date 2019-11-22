public class CWMCheckTimer implements Command {

    WashingMachine washingmachine;

    public CWMCheckTimer(WashingMachine wm) { washingmachine = wm; }

    @Override
    public void execute() {
        washingmachine.CheckTimer();
    }
}

