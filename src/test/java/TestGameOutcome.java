import game.*;
import junit.framework.Assert;
import org.junit.Test;




/**
 * Created by therina on 2016/10/30.
 */
public class TestGameOutcome {


    @Test
    public void TestWinConditionForXHorisontal() {
        GameState gameState1 = new GameState(GameStyle.TWO_PLAYER);

        Point point1 = new Point(0,0,0,0);
        Point point2 = new Point(0,0,0,1);
        Point point3 = new Point(0,0,0,2);


        BoardState board1 = new BoardState();
        board1.setCell(point1,Cell.X);
        board1.setCell(point2,Cell.X);
        board1.setCell(point3,Cell.X);

        gameState1.isAWinForX(board1);
        org.junit.Assert.assertEquals(true,gameState1.isAWinForX(board1));

    }

    @Test
    public void TestWinConditionForXVertical() {
        GameState gameState1 = new GameState(GameStyle.TWO_PLAYER);

        Point point1 = new Point(0,0,0,0);
        Point point2 = new Point(0,0,1,0);
        Point point3 = new Point(0,0,2,0);


        BoardState board1 = new BoardState();
        board1.setCell(point1,Cell.X);
        board1.setCell(point2,Cell.X);
        board1.setCell(point3,Cell.X);

        gameState1.isAWinForX(board1);
        org.junit.Assert.assertEquals(true,gameState1.isAWinForX(board1));

    }

    @Test
    public void TestWinConditionForXDiagonal() {
        GameState gameState1 = new GameState(GameStyle.TWO_PLAYER);

        Point point1 = new Point(0,0,0,0);
        Point point2 = new Point(0,0,1,1);
        Point point3 = new Point(0,0,2,2);


        BoardState board1 = new BoardState();
        board1.setCell(point1,Cell.X);
        board1.setCell(point2,Cell.X);
        board1.setCell(point3,Cell.X);

        gameState1.isAWinForX(board1);
        org.junit.Assert.assertEquals(true,gameState1.isAWinForX(board1));

    }

}
