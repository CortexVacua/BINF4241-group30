public class MicrSwitchOn implements Command{
    Microwave micr;
    public MicrSwitchOn(Microwave m){
        micr=m;
    }

//    switches microwave on
    public void execute(){
        micr.SwitchOn();
    }
}
