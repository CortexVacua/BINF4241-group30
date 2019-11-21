public class CleaningRobot implements BaseInterface, Charger {
    protected MyThread Robotmt;
    protected Thread Robotrt;
    protected boolean system_on = true;
    protected boolean inBaseCharging = true;
    protected int cleaning_timer = 0;
    private long charging_starttime = ((System.currentTimeMillis() / 1000) - 60) * 1000;
    private long discharging_starttime = 0;
    private long cleaning_elapsedtime = 0;
    private long cleaning_starttime = 0;

    //sets timer
    public void SetTimer(int TimeInSeconds) {
        if (TimeInSeconds <= 0) System.out.println("Timer cannot be set to 0 or to a negative value.\n");
        else {
            cleaning_timer = TimeInSeconds * 1000;
        }
    }

    //checks timer
    public void CheckTimer() {
        if (inBaseCharging) {
            System.out.println("Set timer is: " + cleaning_timer / 1000 + "\n");
        }
        else {
            cleaning_elapsedtime = System.currentTimeMillis() - cleaning_starttime;
            System.out.println("Time remaining: " + (cleaning_timer - cleaning_elapsedtime) / 1000 + "\n");
        }
    }

    //starts cleaning
    public void Start() {
        if (System.currentTimeMillis() / 1000 - charging_starttime / 1000 <= 20 - (20 - (cleaning_elapsedtime / 1000))) {
            System.out.println("The robot has to charge for " + (20 - (System.currentTimeMillis() / 1000 - charging_starttime / 1000)) + " more seconds.\n");
        }
        if (!inBaseCharging) {
            System.out.println("Robot is in the process of cleaning!\n");
        } else {
            if (cleaning_timer == 0) System.out.println("No timer set!\n");
            else {
                Robotmt = new MyThread(cleaning_timer);
                Robotrt = new Thread(Robotmt, "cleaning robot");
                Robotrt.start();
                inBaseCharging = false;
                cleaning_starttime = System.currentTimeMillis();
                discharging_starttime = System.currentTimeMillis();
                charging_starttime = (long) Double.POSITIVE_INFINITY;
                System.out.println("The cleaning robot is now cleaning.\n");
                while (Robotmt != null && Robotrt != null) {
                    cleaning_elapsedtime = System.currentTimeMillis() - cleaning_starttime;
                    if (cleaning_elapsedtime / 1000 >= 20) {
                        Robotmt = null;
                        Robotrt = null;
                        charging_starttime = System.currentTimeMillis();
                        inBaseCharging = true;
                        cleaning_timer = (int) (cleaning_timer - (cleaning_elapsedtime / 1000));
                        break;

                    }
                    if (cleaning_elapsedtime / 1000 >= cleaning_timer) {
                        this.Stop();

                    }
                }
            }
        }
    }

    //stops cleaning robot
    public void Stop() {
        if (Robotmt != null && Robotmt.isRunning()) {
            Robotmt = null;
            Robotrt = null;
            cleaning_timer = 0;
            charging_starttime = System.currentTimeMillis();
            inBaseCharging = true;
            cleaning_elapsedtime = System.currentTimeMillis() - cleaning_starttime;
            cleaning_starttime = 0;
            discharging_starttime = (long) Double.NEGATIVE_INFINITY;
        } else System.out.println("The robot does not seem to be cleaning at the moment.\n");
    }
    //checks battery percentage when cleaning
    public void CheckBatteryDischarging () {
        cleaning_elapsedtime = System.currentTimeMillis() - cleaning_starttime;
        if (cleaning_elapsedtime/1000 < 0) {
            System.out.println("Battery percentage: " + 100 + "%\n");
        }
        else {
            System.out.println("Battery percentage: " + (100 - ((((cleaning_elapsedtime) / 1000) / 20) *100)) + "%\n");
        }
    }
    //checks battery percentage when charging
    public void CheckBatteryCharging() {
        long charging_elapsedtime = System.currentTimeMillis() - charging_starttime;
        if (charging_elapsedtime/1000 > 20) {
            System.out.println("Battery percentage: " + 100 + "%\n");
        }
        if (charging_elapsedtime/1000 < 0) {
            System.out.println("Battery percentage: " + 0 + "%\n");
        }
        else {
            System.out.println("Battery percentage: " + ((((charging_elapsedtime) / 1000) / 20) *100) + "%\n");
        }

    }
    //checks cleaning completion percentage
    public void CheckCleaningCompletion() {
        cleaning_elapsedtime = System.currentTimeMillis() - cleaning_starttime;
        if (cleaning_elapsedtime/cleaning_timer > 1) {
            System.out.println("Cleaning completion: " + 100 + "%\n");
        }
        else {
            System.out.println("Cleaning completion: " + ((cleaning_elapsedtime / cleaning_timer) *100) + "%\n");
        }
    }



}
