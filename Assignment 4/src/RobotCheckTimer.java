public class RobotCheckTimer implements Command{
    CleaningRobot rbt;
    public RobotCheckTimer(CleaningRobot r){
        rbt=r;
    }

    //    checks timer
    public void execute(){
        rbt.CheckTimer();
    }
}