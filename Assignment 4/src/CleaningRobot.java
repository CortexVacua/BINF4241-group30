public class CleaningRobot implements BaseInterface, Charger {
    protected RobotThread Robot;
    protected Thread Robotrt;
    protected boolean system_on = true;
    protected boolean inBaseCharging = true;
    protected long cleaning_timer = 0;
    private long charging_starttime = ((System.currentTimeMillis() / 1000) - 60) * 1000;
    private long discharging_starttime = 0;
    private long cleaning_elapsedtime = 0;
    private long cleaning_starttime = 0;

    public CleaningRobot() {
         Robot = new RobotThread();
         Robotrt = new Thread(Robot, "cleaning robot");
         Robotrt.start();
             }

    //sets timer
    public void SetTimer(int TimeInSeconds) {
        Robot.SetTimer(TimeInSeconds);
    }

    //checks timer
    public void CheckTimer() {
        Robot.CheckTimer();
    }

    //starts cleaning
    public void Start() {
        Robot.Start();
        System.out.println("The cleaning robot is now in operation.\n");
    }

    //stops cleaning robot
    public void Stop() {
        Robot.Stop();
    }
    //checks battery percentage when cleaning
    public void CheckBatteryDischarging () {
        Robot.CheckBatteryDischarging();
    }
    //checks battery percentage when charging
    public void CheckBatteryCharging() {
        Robot.CheckBatteryCharging();

    }
    //checks cleaning completion percentage
    public void CheckCleaningCompletion() {
        Robot.CheckCleaningCompletion();
    }



}
