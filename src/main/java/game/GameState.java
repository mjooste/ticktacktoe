package game;

import gui.BoardCellPanel;

import javax.swing.plaf.basic.BasicOptionPaneUI;
import java.awt.*;


public class GameState {

    private GameStyle gameStyle;

    private BoardState theBoard;
    protected Player playerX;
    protected Player playerO;
    private Player activePlayer;
    private BoardCellPanel activePanel;

    //track local player- sees the board

    //track remote player- uses some other input method

    public GameState (GameStyle gameStyle){
        this.gameStyle = gameStyle;
        theBoard = new BoardState();
        //theBoard.setCell(new Point(BoardState.MIN, BoardState.MIN, BoardState.MIN, BoardState.MIN), Cell.X);
        //theBoard.setCell(new Point(BoardState.MAX, BoardState.MAX, BoardState.MAX,BoardState.MAX), Cell.O);

        playerO = new Player(Cell.O);
        playerX = new Player(Cell.X);

        activePlayer = playerX;


    }


    public void switchPlayers() {
        if (activePlayer == playerX) {
            activePlayer = playerO;
        } else {
            activePlayer = playerX;
        }
    }


    public void doMove(Point point){
        if(isLegalMove(point)){
            theBoard.setCell(point, activePlayer.getCharacter());

            // Set new active panel

            activePanel = new BoardCellPanel(point.getInnerRow(), point.getInnerColumn());
            switchPlayers();
        }
    }



    public boolean isLegalMove(Point point) {
        boolean isEmpty = theBoard.getCell(point).equals(Cell.E);
        boolean onActivePanel = activePanel == null || theBoard.getCell(point).equals(Cell.E) && point.getRow() == activePanel.getRow() && point.getColumn() == activePanel.getColumn();
        return isEmpty && onActivePanel;


    }

    public void doMove(int row, int column, int innerRow, int innerColumn ){
        doMove(new Point(row,column,innerRow,innerColumn));
    }


    public boolean gameIsOver(){
        return isAWinForX() || isAWinForO();
    }

    public boolean isAWinForX(){

        //look for all in a row
        for (int r = BoardState.MIN; r <= BoardState.MAX; r++ ) {
            for (int c = BoardState.MIN; c <= BoardState.MAX; c++) {
                for (int ir = BoardState.MIN; ir <= BoardState.MAX; ir++ ) {
                    for (int ic = BoardState.MIN; ic <= BoardState.MAX; ic++) {
                        if (theBoard.getCell(r,c,ir,ic) != Cell.X){
                            break;
                        }
                        if ( ic >= 2){
                            return true;
                        }
                    }
                }
            }
        }

        //look for all in a column
        for (int r = BoardState.MIN; r <= BoardState.MAX; r++ ) {
            for (int c = BoardState.MIN; c <= BoardState.MAX; c++) {
                for (int ic = BoardState.MIN; ic <= BoardState.MAX; ic++) {
                    for (int ir = BoardState.MIN; ir <= BoardState.MAX; ir++ ) {
                        if (theBoard.getCell(r,c,ir,ic) != Cell.X){
                            break;
                        }
                        if ( ir >= 2){
                            return true;
                        }
                    }
                }
            }
        }

        //look for all the diagonals
        for (int r = BoardState.MIN; r <= BoardState.MAX; r++ ) {
            for (int c = BoardState.MIN; c <= BoardState.MAX; c++) {
                if (theBoard.getCell(r,c,0,0).equals(Cell.X) && theBoard.getCell(r,c,1,1).equals(Cell.X) && theBoard.getCell(r,c,2,2).equals(Cell.X) )
                {
                    return true;
                }
            }
        }

        for (int r = BoardState.MIN; r <= BoardState.MAX; r++ ) {
            for (int c = BoardState.MIN; c <= BoardState.MAX; c++) {
                if (theBoard.getCell(r,c,0,2).equals(Cell.X) && theBoard.getCell(r,c,1,1).equals(Cell.X) && theBoard.getCell(r,c,2,0).equals(Cell.X) )
                {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isAWinForO(){

        //look for all in a row
        for (int r = BoardState.MIN; r <= BoardState.MAX; r++ ) {
            for (int c = BoardState.MIN; c <= BoardState.MAX; c++) {
                for (int ir = BoardState.MIN; ir <= BoardState.MAX; ir++ ) {
                    for (int ic = BoardState.MIN; ic <= BoardState.MAX; ic++) {
                        if (theBoard.getCell(r,c,ir,ic) != Cell.O){
                            break;
                        }
                        if ( ic >= 2){
                            return true;
                        }
                    }
                }
            }
        }

        //look for all in a column
        for (int r = BoardState.MIN; r <= BoardState.MAX; r++ ) {
            for (int c = BoardState.MIN; c <= BoardState.MAX; c++) {
                for (int ic = BoardState.MIN; ic <= BoardState.MAX; ic++) {
                    for (int ir = BoardState.MIN; ir <= BoardState.MAX; ir++ ) {
                        if (theBoard.getCell(r,c,ir,ic) != Cell.O){
                            break;
                        }
                        if ( ir >= 2){
                            return true;
                        }
                    }
                }
            }
        }

        //look for all the diagonals
        for (int r = BoardState.MIN; r <= BoardState.MAX; r++ ) {
            for (int c = BoardState.MIN; c <= BoardState.MAX; c++) {
                if (theBoard.getCell(r,c,0,0).equals(Cell.O) && theBoard.getCell(r,c,1,1).equals(Cell.O) && theBoard.getCell(r,c,2,2).equals(Cell.O))
                {
                    return true;
                }
            }
        }

        for (int r = BoardState.MIN; r <= BoardState.MAX; r++ ) {
            for (int c = BoardState.MIN; c <= BoardState.MAX; c++) {
                if (theBoard.getCell(r,c,0,2).equals(Cell.O) && theBoard.getCell(r,c,1,1).equals(Cell.O) && theBoard.getCell(r,c,2,0).equals(Cell.O) )
                {
                    return true;
                }
            }
        }
        return false;
    }


    public Player getActivePlayer() {
        return activePlayer;
    }

    public BoardState getTheBoard() {
        return theBoard;
    }

    public BoardCellPanel getActivePanel() {
        return activePanel;
    }
}
