package game;


import main.Main;

import java.util.HashMap;
import java.util.Map;


public class BoardState {

    public static final int MIN = 0;
    public static final int MAX = 2;

    private Map<Point, Cell> cells;


//hold reference to remote player to send updates to it
    //new board state loop through row and col and inner row and column, add empty cells
    public BoardState() {
        cells = new HashMap<Point, Cell>();

        //cells
       for (int r = MIN; r <= MAX; r++ ){
           for (int c = MIN; c <= MAX; c++) {
               //buttons
               for (int ir = MIN; ir <= MAX; ir++ ) {
                   for (int ic = MIN; ic <= MAX; ic++) {
                       setCell(new Point(r, c,ir,ic), Cell.E);
                   }
               }
           }

        }
    }
    public BoardState(Map<Point, Cell> copyCells) {
        cells = new HashMap<Point, Cell>();
        cells.putAll(copyCells);
    }



    public Cell getCell(Point point) {
        return cells.get(point);
    }

    //populate map
    public void setCell(Point point, Cell cell) {
        cells.put(point, cell);
    }

    public Cell getCell(int row, int column, int innerRow, int innerColumn){
        return getCell(new Point(row,column,innerRow,innerColumn));
    }

    public void setCell(int row, int column, int innerRow, int innerColumn, Cell cell) {
       setCell(new Point(row, column, innerRow, innerColumn), cell);
   }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BoardState boardState = (BoardState) o;

        for (int r = MIN; r <= MAX; r++ ){
            for (int c = MIN; c <= MAX; c++) {
                //buttons
                for (int ir = MIN; ir <= MAX; ir++ ) {
                    for (int ic = MIN; ic <= MAX; ic++) {
                       if (!getCell(new Point(r,c,ir,ic)).equals(boardState.getCell(new Point(r,c,ir,ic)))){
                           return false;
                       }
                    }
                }
            }

        }

        return true;

    }

    @Override
    public int hashCode() {
        return cells != null ? cells.hashCode() : 0;

    }
    public  BoardState copy(){
        //creates an equal but different board
        return new BoardState(cells);
    }


}
