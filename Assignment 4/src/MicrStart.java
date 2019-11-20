public class MicrStart implements Command{
    Microwave micr;
    public MicrStart(Microwave m){
        micr=m;
    }

//    starts the microwave
    public void execute(){
        micr.Start();
    }
}