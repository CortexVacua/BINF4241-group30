public class Dishwasher implements BaseInterface,Switch {
    private boolean system_on = false;
    private  int timer;
    private MyThread dishwasher_thread;
    private long elapsedtime;
    private long starttime;

    DishwasherState glassesState;
    DishwasherState pansState;
    DishwasherState platesState;
    DishwasherState mixedState;

    DishwasherState dishwasher_state;

    public Dishwasher(){
        timer = 0;
        glassesState = new DishwasherGlassesState(this);
        pansState = new DishwasherPansState(this);
        platesState = new DishwasherPlatesState(this);
        mixedState = new DishwasherMixedState(this);
    }

    @Override
    public void SwitchOn() {
        if (system_on==false) {
            system_on = true;
            System.out.print("Dishwasher is switched on successfully.\n");
        }
        else System.out.print("Dishwasher is already switched on.\n");
    }

    @Override
    public void SwitchOff() {
        if (system_on == true) {
            system_on = false;
            System.out.print("Dishwasher is switched off successfully.\n");
        }
        else System.out.print("Dishwasher is already switched off.\n");
    }

    public void chooseProgram(DishwasherState state){
        if(system_on == true){
            dishwasher_state = state;
            dishwasher_state.setTimer();
        }
        else System.out.print("Dishwasher is switched off.\n");
    }

    @Override
    public void SetTimer(int time){
        timer = time*1000;
    }

    // still some stuff to do
    @Override
    public void CheckTimer(){
        if(system_on = true){
            if(dishwasher_thread == null){
                System.out.print("Set timer is: " +timer / 1000 + " seconds.\n");
            }
            else{
                elapsedtime = System.currentTimeMillis() - starttime;
                System.out.print("Time remaining: " + (timer - elapsedtime) / 1000 + " seconds.\n");
            }
        }
        else System.out.print("Dishwasher is switched off.\n");

    }

    @Override
    public void Start() {
        if(system_on == true){
            if(dishwasher_thread == null){
                if(dishwasher_state == null){
                    System.out.print("No dishwasher method set.\n");
                }
                else {
                    dishwasher_thread = new MyThread(timer);
                    starttime = System.currentTimeMillis();
                    System.out.print("The dishwasher is running.\n");
                    dishwasher_thread.run();
                    System.out.print("The dishwasher is finished.\n");
                }
            }
            else System.out.print("Dishwasher is already running.\n");
        }
        else System.out.print("Dishwasher is switched off.\n");

    }

    @Override
    public void Stop() {
        if(system_on == true){
            dishwasher_thread = null;
            dishwasher_state = null;
            timer = 0;
            starttime = 0;
            elapsedtime = 0;
            System.out.print("Dishwasher was forced to stop washing. QwQ\n");
        }
        else System.out.print("Dishwasher is switched off.\n");
    }

}
