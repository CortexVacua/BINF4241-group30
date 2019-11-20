public class OvenStart implements Command{
    Oven oven;
    public OvenStart(Oven o){
        oven=o;
    }
    public void execute(){
        oven.Start();
    }
}