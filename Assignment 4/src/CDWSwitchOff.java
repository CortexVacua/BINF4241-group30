public class CDWSwitchOff implements Command {

    Dishwasher dishwasher;

    public CDWSwitchOff(Dishwasher dw){
        dishwasher = dw;
    }

    public void execute(){
        dishwasher.SwitchOff();
    }
}
