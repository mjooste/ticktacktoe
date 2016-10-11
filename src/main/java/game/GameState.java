package game;

/**
 * Created by therina on 2016/10/01.
 */
public class GameState {

    private GameStyle gameStyle;

    private BoardState theBoard;
    private Player playerX;
    private Player playerO;
    private Player activePlayer;
    private Point selectedPoint;

    public GameState (GameStyle gameStyle){
        this.gameStyle = gameStyle;
        theBoard = new BoardState();
        theBoard.setCell(new Point(BoardState.MIN, BoardState.MIN, 2), Cell.X);
        theBoard.setCell(new Point(BoardState.MAX, BoardState.MAX, 2), Cell.O);

        playerO = new Player(Cell.O);
        playerX = new Player(Cell.X);

        activePlayer = playerX;

        selectedPoint = null;
    }

    public void switchPlayers() {
        if (activePlayer == playerX) {
            activePlayer = playerO;
        } else {
            activePlayer = playerX;
        }
    }

    public BoardState getTheBoard() {
        return theBoard;
    }

    public boolean hasActiveSelection() {
        return selectedPoint != null;
    }
}
