public class RobotCompleteCleaning implements Command {
    CleaningRobot rbt;
    public RobotCompleteCleaning(CleaningRobot r){
        rbt=r;
    }

    //completes cleaning
    public void execute(){
        rbt.Start();
    }
}
