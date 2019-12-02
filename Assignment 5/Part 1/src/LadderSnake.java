//parent class for ladders and snakes
public class LadderSnake extends Square {
//    snake or ladder leads to points_to
   protected int points_to;
   protected int start_square;


   public LadderSnake(int start_square, int points_to) {
      super(start_square);
      this.start_square = start_square;
      this.points_to = points_to;
   }
}
