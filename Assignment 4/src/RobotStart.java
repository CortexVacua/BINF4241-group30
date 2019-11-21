public class RobotStart implements Command {
    CleaningRobot rbt;
    public RobotStart(CleaningRobot r){
        rbt=r;
    }

    //starts cleaning
    public void execute(){
        rbt.Start();
    }
}
