public class DishwasherPansState implements DishwasherState {
    int time = 400;
    Dishwasher dishwasher;

    public DishwasherPansState(Dishwasher dw){
        this.dishwasher = dw;
    }

    @Override
    public void setTimer() {
        dishwasher.SetTimer(time);
        System.out.print("Dishwasher is now set to wash glasses.\n");
    }
}
