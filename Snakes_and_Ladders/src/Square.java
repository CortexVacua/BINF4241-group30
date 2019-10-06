public class Square {

    protected int square_number;

    public Square(int number){
        this.square_number = number;
    }
//    occupied = 0 --> is free, occupied = 1 --> is occupied
   protected int occupied = 0;
   int isOccupied() {
       if (this.occupied == 0) {
           return 0;
       }
       else {
           return 1;
       }
   }
   void ChangOccupiedState (){
       if (this.occupied == 0) {
           this.occupied = 1;
       }
       else {
           this.occupied = 0;
       }
   }
}

