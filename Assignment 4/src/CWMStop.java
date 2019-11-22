public class CWMStop implements Command {

    WashingMachine washingmachine;

    public CWMStop(WashingMachine wm) { washingmachine = wm; }

    @Override
    public void execute() {
        washingmachine.Stop();
    }
}
