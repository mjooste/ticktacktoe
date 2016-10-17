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
    private Map<Point, BoardCellButton> boardCellButtons;


    public GameFrame(GameState gameState){
        super();
        boardCellPanels = new HashMap<Point,BoardCellPanel>();
        boardCellButtons = new HashMap<Point,BoardCellButton>();
        this.gameState = gameState;
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
                refreshBoard();

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
                cellPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                for (int ir = BoardState.MIN; ir <= BoardState.MAX; ir++) {
                    for (int ic = BoardState.MIN; ic <= BoardState.MAX; ic++) {
                        BoardCellButton cellButton = new BoardCellButton(cellPanel, ir,ic);
                        cellButton.setPreferredSize(new Dimension(40, 40));

                        cellButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent actionEvent) {
                                BoardCellButton clickedButton = (BoardCellButton) actionEvent.getSource();
                                gameState.doMove(clickedButton.getPanel().getRow(), clickedButton.getPanel().getColumn(), clickedButton.getInnerRow(),clickedButton.getInnerColumn());
                                refreshBoard();
                            }
                        });
                        boardCellButtons.put(new Point(r,c,ir,ic),cellButton);
                        cellPanel.add(cellButton);

                        }
                    }

                boardPanel.add(cellPanel);
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

    public void refreshBoard(){
        for (int r = BoardState.MIN; r <= BoardState.MAX; r++) {
            for (int c = BoardState.MIN; c <= BoardState.MAX; c++) {
                for (int ir = BoardState.MIN; ir <= BoardState.MAX; ir++){
                    for (int ic = BoardState.MIN; ic <= BoardState.MAX; ic++) {
                        switch (gameState.getTheBoard().getCell(r,c,ir,ic)) {
                            case X:
                                boardCellButtons.get(new Point(r, c,ir,ic)).setText("X");
                                break;
                            case O:
                                boardCellButtons.get(new Point(r, c,ir,ic)).setText("O");
                                break;
                            case E:
                                boardCellButtons.get(new Point(r, c,ir,ic)).setText("");
                                break;
                        }
                    }
                }
//
            }
        }


        this.repaint();
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
        refreshBoard();
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
