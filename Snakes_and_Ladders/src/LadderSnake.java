public class LadderSnake extends Square {
//    snake or ladder leads to points_to
   int points_to;
   int start_square;

   public LadderSnake(int start_square, int points_to) {
      super(start_square);
      this.start_square = start_square;
      this.points_to = points_to;
   }
}
