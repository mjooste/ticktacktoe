package gui;

import javax.swing.*;

/**
 * Created by therina on 2016/10/12.
 */
public class BoardCellButton extends JButton {

    private BoardCellPanel panel;
    private int innerRow;
    private int innerColumn;

    //send through the cell to which the buttons belong to
    public BoardCellButton( BoardCellPanel panel, int innerRow, int innerColumn) {
        super();

        this.panel = panel;
        this.innerRow = innerRow;
        this.innerColumn = innerColumn;


    }

    public BoardCellPanel getPanel() {
        return panel;
    }

    public int getInnerColumn() {
        return innerColumn;
    }


    public int getInnerRow() {
        return innerRow;
    }
}
