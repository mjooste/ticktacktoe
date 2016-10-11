package game;

import java.awt.*;

/**
 * Created by therina on 2016/10/01.
 */
public class Point {
//    private int outerRow;
//    private int innerRow;
//    private int outerColumn;
//    private int innerColumn;

    private int row;
    private int column;
    private int button;

//    //declare new cell/point on board
//    public Point(int outerRow, int outerColumn, int innerRow, int innerColumn ){
//        this.outerRow = outerRow;
//        this.outerColumn = outerColumn;
//        this.innerRow = innerRow;
//        this.innerColumn = innerColumn;
//    }

    //declare new cell/point on board
    public Point(int row, int column, int button ){
        this.row = row;
        this.column = column;
        this.button = button;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (row != point.row) return false;
        if (column != point.column) return false;
        return button == point.button;

    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        result = 31 * result + button;
        return result;
    }

    //
//    public int getOuterRow() {
//        return outerRow;
//    }
//
//    public int getInnerRow() {
//        return innerRow;
//    }
//
//    public int getOuterColumn() {
//        return outerColumn;
//    }
//
//    public int getInnerColumn() {
//        return innerColumn;
//    }
//
//    public void setOuterRow(int outerRow) {
//        this.outerRow = outerRow;
//    }
//
//    public void setInnerRow(int innerRow) {
//        this.innerRow = innerRow;
//    }
//
//    public void setOuterColumn(int outerColumn) {
//        this.outerColumn = outerColumn;
//    }
//
//    public void setInnerColumn(int innerColumn) {
//        this.innerColumn = innerColumn;
//    }
}
