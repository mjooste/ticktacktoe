package game;

import javafx.scene.layout.Pane;
import main.Main;

import java.util.HashMap;
import java.util.Map;


public class BoardState {

    public static final int MIN = 0;
    public static final int MAX = 2;

    private Map<Point, Cell> cells;



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

//    public void setPanel(Point point, Panel panel){
//        panels.put(point,panel);
//    }
//
//    public void setPanel(int innerRow, int innerColumn, Panel panel) {
//        setPanel(new Point(innerRow,innerColumn),panel);
//    }
//
////    public void  getPanel(Point point){
////    return getPanel(new Point(row, coloumn))
////}
}
