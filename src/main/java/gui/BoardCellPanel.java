package gui;

import javax.swing.*;

/**
 * Created by therina on 2016/10/01.
 */
public class BoardCellPanel extends JPanel {

    private int row;
    private int column;

    public BoardCellPanel(int row, int column) {
        super();
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}