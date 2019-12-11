//implements square, keeps track if square is occupied
public class Square {
    //    occupied = 0 --> is free, occupied = 1 --> is occupied
    protected int occupied = 0;
    protected int square_number;

    public Square(int number){
        this.square_number = number;
    }

    public int get_square_number(){
        return this.square_number;
    }

   public int isOccupied() {
       if (this.occupied == 0) {
           return 0;
       }
       else {
           return 1;
       }
   }

   void ChangeOccupiedState (){
       if (this instanceof FirstSquare){
           return;
       }
       if (this.occupied == 0) {
           this.occupied = 1;
       }
       else {
           this.occupied = 0;
       }
   }
}

