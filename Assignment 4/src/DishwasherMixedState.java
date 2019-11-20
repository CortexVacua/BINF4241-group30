public class DishwasherMixedState implements DishwasherState {
    int time = 500;
    Dishwasher dishwasher;

    public DishwasherMixedState(Dishwasher dw){
        this.dishwasher = dw;
    }

    @Override
    public void setTimer() {
        dishwasher.SetTimer(time);
        System.out.print("Dishwasher is now set to wash glasses.\n");
    }
}
