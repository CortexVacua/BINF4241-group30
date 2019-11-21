public class RobotStop implements Command{
    CleaningRobot rbt;
    public RobotStop(CleaningRobot r){
        rbt=r;
    }

    //stops cleaning
    public void execute(){
        rbt.Stop();
    }
}
