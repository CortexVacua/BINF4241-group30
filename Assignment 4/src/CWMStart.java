public class CWMStart implements Command {

    WashingMachine washingmachine;

    public CWMStart(WashingMachine wm) { washingmachine = wm; }

    @Override
    public void execute() {
        washingmachine.Start();
    }
}
