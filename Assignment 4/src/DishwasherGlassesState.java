public class DishwasherGlassesState implements DishwasherState {
    int time = 30;
    Dishwasher dishwasher;

    public DishwasherGlassesState(Dishwasher dw){
        this.dishwasher = dw;
    }

    @Override
    public void setTimer() {
        dishwasher.SetTimer(time);
        System.out.print("Dishwasher is now set to wash glasses.");
    }
}
