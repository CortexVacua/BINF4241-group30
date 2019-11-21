/**
 * This class implements Runnable. That means that you need to
 * implement the run() method to describe the Thread behaviour.
 * Remember: runnable objects are not Threads, so using the
 * run() method on main process will not create a separate process.
 * */

public class RobotThread implements Runnable, BaseInterface, Charger {

    protected int time;  // represent the time of life of the thread
    protected ChargingState charging_state;
    protected CleaningState cleaning_state;
    protected int charge;
    protected int requested_cleaning_time;
    protected int remaining_cleaning_time;

    /**
     * Constructor for MyThread
     * @param timeInMillis: time of life of the thread
     * */
    public RobotThread(int timeInMillis){
        time = timeInMillis;
    }

    /**
     * Default Constructor. It has a default time of 10 seconds.
     * */
    public RobotThread() {
        cleaning_state = CleaningState.NOT_CLEANING;
        charging_state = ChargingState.NEUTRAL;
        charge = 100;
    }

    /**
     * This method contains the behaviour of the thread. Its implementation
     * is mandatory. In this case, the thread will sleep for the amount of time
     * specified in the constructor and handle the state of the Thread.
     * */
    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000);
                if (charging_state == ChargingState.CHARGING && cleaning_state == CleaningState.NOT_CLEANING) {
                    charge++;
                    if (charge >= 100) {
                        charge = 100;
                        if (remaining_cleaning_time > 0) {
                            cleaning_state = CleaningState.CLEANING;
                            charging_state = ChargingState.DISCHARGING;
                        }
                        else {
                            charging_state = ChargingState.NEUTRAL;
                        }
                    }
                }
                if (charging_state == ChargingState.DISCHARGING && cleaning_state == CleaningState.CLEANING) {
                    charge--;
                    remaining_cleaning_time--;
                    if (charge <= 0) {
                        charge = 0;
                        charging_state = ChargingState.CHARGING;
                        cleaning_state = CleaningState.NOT_CLEANING;
                    }
                    if (remaining_cleaning_time <= 0) {
                        remaining_cleaning_time = 0;
                        System.out.println("The "+Thread.currentThread().getName() + " has finished its program successfully.\n");
                        charging_state = ChargingState.CHARGING;
                        cleaning_state = CleaningState.NOT_CLEANING;
                    }
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    //sets timer
    public void SetTimer(int TimeInSeconds) {
        if (TimeInSeconds <= 0) System.out.println("Timer cannot be set to 0 or to a negative value.\n");
        else {
            requested_cleaning_time = TimeInSeconds;
            remaining_cleaning_time = TimeInSeconds;
        }
    }
    //checks timer
    public void CheckTimer() {
        if (charging_state == ChargingState.CHARGING || charging_state == ChargingState.NEUTRAL) {
            System.out.println("Set timer is: " + remaining_cleaning_time + "\n");
        }
        else {
            System.out.println("Time remaining: " + remaining_cleaning_time + "\n");
        }
    }
    //starts cleaning
    public void Start() {
        if (requested_cleaning_time <= 0 || remaining_cleaning_time <= 0) {
            System.out.println("No timer set!\n");
        }
        else if (charge < 100) {
            System.out.println("Please wait for robot to fully charge!\n");
        }
        else {
            charging_state = ChargingState.DISCHARGING;
            cleaning_state = CleaningState.CLEANING;
        }

    }
    //stops cleaning robot
    public void Stop() {
        if (cleaning_state == CleaningState.NOT_CLEANING) {
            System.out.println("Robot is not cleaning right now!\n");
        }
        else {
            remaining_cleaning_time = 0;
        }
    }
    //checks battery percentage when cleaning
    public void CheckBatteryDischarging () {
        System.out.println("Battery percentage: " + charge + "%\n");
    }
    //checks battery percentage when charging
    public void CheckBatteryCharging() {
        System.out.println("Battery percentage: " + charge + "%\n");
    }
    //checks cleaning completion percentage
    public void CheckCleaningCompletion() {
        if (requested_cleaning_time == 0) {
            System.out.println("Cleaning completion: " + 100 + "%\n");
        }
        else {
            System.out.println("Cleaning completion: " + (int)((1-((double)remaining_cleaning_time/(double)requested_cleaning_time)) *100) + "%\n");
        }
    }


}