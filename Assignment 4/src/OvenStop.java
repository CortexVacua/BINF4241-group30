public class OvenStop implements Command{
    Oven oven;
    public OvenStop(Oven o){
        oven=o;
    }

//    stops the oven
    public void execute(){
        oven.Stop();
    }
}