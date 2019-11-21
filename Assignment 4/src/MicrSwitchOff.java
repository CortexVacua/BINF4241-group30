public class MicrSwitchOff implements Command{
    Microwave micr;
    public MicrSwitchOff(Microwave m){
        micr=m;
    }

//    switches microwave off
    public void execute(){
        micr.SwitchOff();
    }
}