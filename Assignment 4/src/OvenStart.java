public class OvenStart implements Command{
    Oven oven;
    public OvenStart(Oven o){
        oven=o;
    }

//    starts the oven
    public void execute(){
        oven.Start();
    }
}