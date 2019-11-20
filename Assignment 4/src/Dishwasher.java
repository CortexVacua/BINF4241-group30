public class Dishwasher {
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

    public void chooseProgram(DishwasherState state){
        dishwasher_state = state;
        dishwasher_state.setTimer();
    }

    protected void setTimer(int time){
        timer = time*1000;
    }

}
