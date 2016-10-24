package game;

import java.awt.*;

public class Point {

    private int row;
    private int column;
    private int innerRow;
    private int innerColumn;

//    //declare new cell/point on board
    public Point(int row, int column, int innerRow, int innerColumn ){
        //cells
        this.row = row;
        this.column = column;
        //buttons
        this.innerRow = innerRow;
        this.innerColumn = innerColumn;
    }

    public Point(int innerRow, int innerColumn){
        this.innerColumn = innerColumn;
        this.innerRow = innerRow;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (row != point.row) return false;
        if (column != point.column) return false;
        if (innerRow != point.innerRow) return false;
        return innerColumn == point.innerColumn;

    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + column;
        result = 31 * result + innerRow;
        result = 31 * result + innerColumn;
        return result;
    }




    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public int getInnerRow() {
        return innerRow;
    }

    public int getInnerColumn() {
        return innerColumn;
    }
}
