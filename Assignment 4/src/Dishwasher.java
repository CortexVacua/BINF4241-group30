public class Dishwasher implements BaseInterface,Switch {
    private boolean system_on = false;
    private  int timer;
    DishwasherState glassesState;
    DishwasherState noState;
    DishwasherState dishwasher_state;

    public Dishwasher(){
        timer = 0;
        glassesState = new DishwasherGlassesState(this);
        noState = new DishwasherNoState(this);
        dishwasher_state = noState;

    }

    @Override
    public void SwitchOn() {
        if (system_on==false) {
            system_on = true;
            System.out.println("Dishwasher is switched on successfully.");
        }
        else System.out.println("Dishwasher is already switched on.");
    }

    @Override
    public void SwitchOff() {
        if (system_on == true) {
            system_on = false;
            System.out.print("Dishwasher is switched off successfully.");
        }
        else System.out.println("Dishwasher is already switched off.");
    }

    public void chooseProgram(DishwasherState state){
        if(system_on == true){
            dishwasher_state = state;
            dishwasher_state.setTimer();
        }
        else System.out.print("Dishwasher is switched off.");
    }

    @Override
    public void SetTimer(int time){
        timer = time*1000;
    }

    @Override
    public void CheckTimer(){

    }

    @Override
    public void Start() {

    }

    @Override
    public void Stop() {

    }

}
