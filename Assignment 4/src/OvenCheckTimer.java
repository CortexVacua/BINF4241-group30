public class OvenCheckTimer implements Command{
    Oven oven;
    public OvenCheckTimer(Oven o){
        oven=o;
    }
    public void execute(){
        oven.CheckTimer();
    }
}