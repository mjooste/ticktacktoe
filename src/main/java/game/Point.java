package game;

import java.awt.*;

/**
 * Created by therina on 2016/10/01.
 */
public class Point {
    private int row;
    private int column;

    //declare new cell/point on board
    public Point(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
