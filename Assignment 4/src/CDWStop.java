public class CDWStop implements Command {

    Dishwasher dishwasher;
    public CDWStop(Dishwasher dw) { dishwasher = dw; }

    @Override
    public void execute() {
        dishwasher.Stop();
    }
}
