package gui;

import javax.swing.*;


public class BoardCellButton extends JButton {

    private BoardCellPanel panel;
    private int innerRow;
    private int innerColumn;
    public JButton[] cellButton;

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

    public void enableCell() {
        for (int i = 0; i < cellButton.length; i++)
            cellButton[i].setEnabled(false); //Reset Board
    }
}
