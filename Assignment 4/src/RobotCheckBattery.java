public class RobotCheckBattery implements Command {
    CleaningRobot rbt;
    public RobotCheckBattery(CleaningRobot r){
        rbt=r;
    }
    //Checks battery percentage
    public void execute() {
        if (rbt.inBaseCharging) {
            rbt.CheckBatteryCharging();
        }
        else {
            rbt.CheckBatteryDischarging();
        }
    }
}
