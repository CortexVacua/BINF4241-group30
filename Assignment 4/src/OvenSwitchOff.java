public class OvenSwitchOff implements Command{
    Oven oven;
    public OvenSwitchOff(Oven o){
        oven=o;
    }

//    switches oven off
    public void execute(){
        oven.SwitchOff();
    }
}