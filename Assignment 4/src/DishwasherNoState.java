public class DishwasherNoState implements DishwasherState {
    int time = 0;
    Dishwasher dishwasher;

    public DishwasherNoState(Dishwasher dw){
        this.dishwasher = dw;
    }

    @Override
    public void setTimer() {
        dishwasher.setTimer(time);
        System.out.print("Error: No Program was chosen. Timer could not be set.");
    }
}
