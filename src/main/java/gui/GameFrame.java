package gui;



import game.*;
import game.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;


/**
 * Created by therina on 2016/10/01.
 */
public class GameFrame extends JFrame {
    private GameState gameState;
    private JLabel messageLabel;
    private Map<Point, BoardCellPanel> boardCellPanels;


    public GameFrame(){
        super();
        boardCellPanels = new HashMap<Point,BoardCellPanel>();
        initGui();

    }

    public void initGui(){
        //Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("New Game...");

        JMenuItem twoPlayerItem = new JMenuItem("New Two-Player Game");
        twoPlayerItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameState = new GameState(GameStyle.TWO_PLAYER);

            }
        });

        JMenuItem networkedItem = new JMenuItem("New Networked Game");
        networkedItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameFrame.this.dispose();

            }
        });
        JMenuItem aiItem = new JMenuItem("New AI Game");

        menu.add(twoPlayerItem);
        menu.add(networkedItem);
        menu.add(aiItem);

        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        //Setup visual board
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(BoardState.MAX+1,BoardState.MAX+1));
        for (int r = BoardState.MIN; r <= BoardState.MAX; r++) {
            for (int c = BoardState.MIN; c <= BoardState.MAX; c++) {
                BoardCellPanel cellPanel = new BoardCellPanel(r,c);
                //gui row and column panel
                for (int b = 0; b < 9; b++) {
//                    JButton button = new JButton(Integer.toString(i + 1));
                    JButton button = new JButton("O");
                    button.setPreferredSize(new Dimension(40, 40));
                    cellPanel.add(button);
                    boardCellPanels.put(new Point(r,c,b), cellPanel);
                    //key: new instance of point, value:gui cell Panel
                    boardPanel.add(cellPanel);
                }


                cellPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));





            }
        }

        messageLabel = new JLabel();
        this.setLayout(new BorderLayout());
        this.add(boardPanel,BorderLayout.CENTER);
        this.add(messageLabel,BorderLayout.SOUTH);

        this.setSize(new Dimension(500,500));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
//    //board buttons
//    private JButton board[][];
//
//    //option buttons
//    private JButton quitButton;
//    private JButton undoButton;
//    private JButton saveButton;
//    private JButton loadButton;
//
//    private JLabel winsX;
//    private JLabel winsO;
//    private JLabel teamX;
//    private JLabel teamO;

    }
