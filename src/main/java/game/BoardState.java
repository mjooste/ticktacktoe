package game;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by therina on 2016/10/01.
 */
public class BoardState {

    public static final int MIN = 0;
    public static final int MAX = 2;

    private Map<Point, Cell> cells;

    //new board state loop through row and col and add empty cells
//    public BoardState() {
//        cells = new HashMap<Point, Cell>();
//       for (int or = MIN; or <= MAX; or++ ){
//           for (int oc = MIN; oc <= MAX; oc++) {
//               for (int ir = MIN; ir <= MAX; ir++ ) {
//                   for (int ic = MIN; ic <= MAX; oc++) {
//                       setCell(new Point(or, oc,ir,ic), Cell.E);
//                   }
//               }
//           }
//
//        }
//    }

    public BoardState() {
        cells = new HashMap<Point, Cell>();
        for (int r = MIN; r <= MAX; r++ ){
            for (int c = MIN; c <= MAX; c++) {
              for(int b = 0; b <9; b++) {
                  setCell(new Point(r, c, b), Cell.E);
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

    public Cell getCell(int row, int column, int button) {
        return getCell(new Point(row,column,button));
    }


    public void setCell(int row, int column, int button, Cell cell) {
        setCell(new Point(row, column, button), cell);
    }





}
