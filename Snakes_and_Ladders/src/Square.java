public class Square {

    public int isOccupied;
    protected int square_number;
    protected int points_to;

    public Square(int number){
        this.square_number = number;
    }
//    occupied = 0 --> is free, occupied = 1 --> is occupied
   protected int occupied = 0;
   public int isOccupied() {
       if (this.occupied == 0) {
           return 0;
       }
       else {
           return 1;
       }
   }

   void ChangeOccupiedState (){
       if (this.occupied == 0) {
           this.occupied = 1;
       }
       else {
           this.occupied = 0;
       }
   }
}

