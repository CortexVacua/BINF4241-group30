public class OvenSwitchOff implements Command{
    Oven oven;
    public OvenSwitchOff(Oven o){
        oven=o;
    }
    public void execute(){
        oven.SwitchOff();
    }
}