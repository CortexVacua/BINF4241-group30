public class Square {
   protected int occupied = 0;
   int isOccupied() {
       if (this.occupied == 0) {
           return 1;
       }
       else {
           return 0;
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

