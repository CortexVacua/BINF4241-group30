public class MicrStop implements Command{
    Microwave micr;
    public MicrStop(Microwave m){
        micr=m;
    }

//    stops the microwave
    public void execute(){
        micr.Stop();
    }
}