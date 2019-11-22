public class CDWStart implements Command {

    Dishwasher dishwasher;
    public CDWStart(Dishwasher dw) { dishwasher = dw; }

    @Override
    public void execute() {
        dishwasher.Start();
    }
}
