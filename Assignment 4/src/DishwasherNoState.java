public class DishwasherNoState implements DishwasherState {
    int time = 0;
    Dishwasher dishwasher;

    public DishwasherNoState(Dishwasher dw){
        this.dishwasher = dw;
    }

    @Override
    public void setTimer() {
        dishwasher.SetTimer(time);
        System.out.print("Error: No Program was chosen. Timer could not be set.");
    }
}
