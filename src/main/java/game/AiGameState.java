package game;

import gui.GameFrame;

import java.util.LinkedList;
import java.util.List;

import static game.BoardState.MAX;
import static game.BoardState.MIN;

/**
 * Created by therina on 2016/10/25.
 */
public class AiGameState extends GameState {
    private GameFrame gameFrame;
    private Player localPlayer;
    private Player aiPlayer;
    private Point minimaxMove;
    private int heuristic;

    List<Point> availablePoints;

    public AiGameState(GameStyle gameStyle, Cell localCharacter){
        super(gameStyle);
        if (localCharacter.equals(Cell.X)){
            localPlayer = playerX;
            aiPlayer = playerO;
        }else {
            localPlayer = playerO;
            aiPlayer = playerX;
        }
    }

    public void setGameFrame(GameFrame gameFrame){
        this.gameFrame = gameFrame;
    }
    public void  doAiMove (Point point){
        super.doMove(point);
        gameFrame.refreshBoard();
    }

    public boolean isLocalPlayerTurn(){
        return localPlayer.equals(getActivePlayer());
    }

    @Override
    public void doMove(Point point){
        //player can only move if it is their turn
        if(getActivePlayer().getCharacter().equals(localPlayer.getCharacter())){
            super.doMove(point);

            if (getActivePlayer().getCharacter().equals(aiPlayer.getCharacter())){
               MoveAndScore bestMove = runMinimax(getTheBoard(), point, aiPlayer,5);
                if (bestMove != null){
                    this.minimaxMove = bestMove.getMove();
                }
                doAiMove(minimaxMove);
            }
        }
    }



    //get every possible move
    public List<Point> getAvailableStates(){
        availablePoints = new LinkedList<Point>();
                //buttons
        for (int r = MIN; r <= MAX; r++ ){
            for (int c = MIN; c <= MAX; c++) {
                if(r == getActivePanel().getRow() && c == getActivePanel().getColumn()){
                    for (int ir = MIN; ir <= MAX; ir++) {
                        for (int ic = MIN; ic <= MAX; ic++) {
                            if (getTheBoard().getCell(r,c,ir,ic) == Cell.E) {
                                availablePoints.add(new Point(r,c,ir,ic));
                            }

                        }

                    }
                    }
                }

            }
        return availablePoints;
        }

    public void doMoveOnClonedBoard(BoardState clonedBoard, Point move, Player player) {
        clonedBoard.setCell(move, player.getCharacter());
    }

     public MoveAndScore runMinimax(BoardState currentBoard, Point moveMade, Player playerToMove, int depth){

         if (isAWinForX(currentBoard)) {
             return new MoveAndScore(moveMade, 1);
         } else if (isAWinForO(currentBoard)) {
             return new MoveAndScore(moveMade, -1);
         }  else if (depth == 0) {
             return new MoveAndScore(moveMade, 0);
         }

         List<Point> pointsAvailable = getAvailableStates();

         if (pointsAvailable.isEmpty()){
             return new MoveAndScore(moveMade, 0);
         }

         List<MoveAndScore> moveAndScores = new LinkedList<MoveAndScore>();

         for (int i = 0; i < pointsAvailable.size(); i++){
             Point point = pointsAvailable.get(i);

             BoardState clonedBoard = currentBoard.copy();
             doMoveOnClonedBoard(clonedBoard,point,playerToMove);
             //best move and best score
             MoveAndScore moveAndScore = runMinimax(clonedBoard, point, otherPlayer(playerToMove), depth - 1);
             moveAndScores.add(moveAndScore);
         }

         MoveAndScore bestMove = null;

         if (playerToMove.equals(aiPlayer)) {
             for (MoveAndScore move: moveAndScores) {
                 if (bestMove == null || bestMove.getScore() < move.getScore()) {
                     bestMove = move;
                 }
             }
         } else {
             for (MoveAndScore move: moveAndScores) {
                 if (bestMove == null || bestMove.getScore() > move.getScore()) {
                     bestMove = move;
                 }
             }
         }

          //bestMove.setMove(moveMade);

         return bestMove;
     }

    private Player otherPlayer(Player player) {
        if (player.equals(playerX)) {
            return playerO;
        } else {
            return playerX;
        }
    }



}
