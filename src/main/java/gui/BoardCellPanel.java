package gui;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by therina on 2016/10/01.
 */
public class BoardCellPanel extends JPanel {

    private int row;
    private int column;
    private List<JButton> buttons;

    public BoardCellPanel(int row, int column) {
        super();
        this.row = row;
        this.column = column;
        this.buttons = new ArrayList<JButton>(9);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public List<JButton> getButtons() {
        return buttons;
    }
}