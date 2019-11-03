import java.util.ArrayList;

public class ScoreBoard implements ObserverSB{
    private int white_score = 0;
    private int black_score = 0;

    public int[] getScores(){
//        getter function to get the scores of the players
        int[] Scores =new int[2];
        Scores[0]=white_score;
        Scores[1]=black_score;
        return Scores;
    }

    public void update(Piece dead_piece) {
//        implements the update method which updates the scores
        if (dead_piece.getColor()==Color.BLACK){
            if (dead_piece instanceof Queen) white_score+=5;
            else white_score+=1;
        }
        else if (dead_piece instanceof Queen) black_score+=5;
        else black_score+=1;
    }
}
