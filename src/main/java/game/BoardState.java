package game;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by therina on 2016/10/01.
 */
public class BoardState {

    public static final int MIN = 0;
    public static final int MAX = 3;

    private Map<Point, Cell> cells;

    //new board state loop through row and col and add empty cells
    public BoardState() {
        cells = new HashMap<Point, Cell>();
       for (int r = MIN; r <= MAX; r++ ){
           for (int c = MIN; c <= MAX; c++) {
               setCell(new Point(r,c), Cell.E);
           }

        }
    }


    //populate map
    public void setCell(Point point, Cell cell) {
        cells.put(point, cell);
    }


}
