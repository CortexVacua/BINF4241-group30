public class CDWCheckTimer implements Command {

    Dishwasher dishwasher;
    public CDWCheckTimer(Dishwasher dw) { dishwasher = dw; }

    @Override
    public void execute() {
        dishwasher.CheckTimer();
    }
}
