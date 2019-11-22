public class CDWSwitchOn implements Command {

    Dishwasher dishwasher;

    public CDWSwitchOn(Dishwasher dw){
        dishwasher = dw;
    }

    public void execute(){
        dishwasher.SwitchOn();
    }
}
