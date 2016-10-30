package game;

/**
 * Created by therina on 2016/10/25.
 */
public class MoveAndScore {
    private Point move;
    private int score;

   public  MoveAndScore(Point move, int score){
        this.score = score;
        this.move = move;
    }

    public Point getMove() {
        return move;
    }

    public int getScore() {
        return score;
    }

    public void setMove(Point move) {
        this.move = move;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
