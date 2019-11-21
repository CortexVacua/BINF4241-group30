public class RobotCheckCompletion implements Command {
    CleaningRobot rbt;

    public RobotCheckCompletion(CleaningRobot r) {
        rbt = r;
    }

    //Checks cleaning completion
    public void execute() {
        rbt.CheckCleaningCompletion();

    }
}
