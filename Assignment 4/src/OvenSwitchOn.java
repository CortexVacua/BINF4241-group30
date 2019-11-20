public class OvenSwitchOn implements Command{
    Oven oven;
    public OvenSwitchOn(Oven o){
        oven=o;
    }
    public void execute(){
        oven.SwitchOn();
    }
}
