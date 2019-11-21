public class MicrCheckTimer implements Command{
    Microwave micr;
    public MicrCheckTimer(Microwave m){
        micr=m;
    }

//    checks timer
    public void execute(){
        micr.CheckTimer();
    }
}