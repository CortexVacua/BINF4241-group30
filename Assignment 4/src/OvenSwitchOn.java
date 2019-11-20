public class OvenSwitchOn implements Command{
    Oven oven;
    public OvenSwitchOn(Oven o){
        oven=o;
    }

//    switches oven on
    public void execute(){
        oven.SwitchOn();
    }
}
