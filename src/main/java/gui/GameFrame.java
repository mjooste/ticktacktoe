package gui;



import game.*;
import game.Point;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;


import java.awt.BorderLayout;

import static java.awt.SystemColor.text;


public class GameFrame extends JFrame {
    private GameState gameState;
    private JLabel messageLabel;
    private Map<Point, BoardCellPanel> boardCellPanels;
    private Map<Point, BoardCellButton> boardCellButtons;



    public GameFrame(){
        super();
        boardCellPanels = new HashMap<Point,BoardCellPanel>();
        boardCellButtons = new HashMap<Point,BoardCellButton>();
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
                new NetworkSetupFrame();

            }
        });
        JMenuItem aiItem = new JMenuItem("New AI Game");

        JMenuItem instructions = new JMenuItem("Instructions");

        menu.add(twoPlayerItem);
        menu.add(networkedItem);
        menu.add(aiItem);
        menu.add(instructions);

        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        //Setup visual board
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(BoardState.MAX+1,BoardState.MAX+1));
        for (int r = BoardState.MIN; r <= BoardState.MAX; r++) {
            for (int c = BoardState.MIN; c <= BoardState.MAX; c++) {
                BoardCellPanel cellPanel = new BoardCellPanel(r,c);
                cellPanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                cellPanel.setForeground(Color.WHITE);



                for (int ir = BoardState.MIN; ir <= BoardState.MAX; ir++) {
                    for (int ic = BoardState.MIN; ic <= BoardState.MAX; ic++) {
                        BoardCellButton cellButton = new BoardCellButton(cellPanel, ir,ic);
                        cellButton.setPreferredSize(new Dimension(40, 40));
                        cellButton.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                        cellPanel.setBackground(new Color(130, 184, 189));


                        // style cell buttons
                        cellButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                        cellButton.setMargin(new Insets(0,0,0,0));


                        cellButton.addActionListener(new ActionListener() {
                            public void actionPerformed(ActionEvent actionEvent) {
                                BoardCellButton clickedButton = (BoardCellButton) actionEvent.getSource();
                                gameState.doMove(clickedButton.getPanel().getRow(), clickedButton.getPanel().getColumn(), clickedButton.getInnerRow(),clickedButton.getInnerColumn());
                                refreshBoard();
                            }
                        });
                        boardCellButtons.put(new Point(r,c,ir,ic),cellButton);
                        cellPanel.add(cellButton);
                        boardCellButtons.getClass();


                        }
                    }
                boardCellPanels.put(new Point(r,c), cellPanel);
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
            }
        }
        Point activePanelPoint = new Point(gameState.getActivePanel().getRow(), gameState.getActivePanel().getColumn());
        for (Point point: boardCellPanels.keySet()) {
            boardCellPanels.get(point).setBackground(new Color(130, 184, 189));
        }
        boardCellPanels.get(activePanelPoint).setBackground(new Color(149, 189, 174));

        //styles message label
        messageLabel.setForeground(new Color(74, 74, 74));
        messageLabel.setBackground(Color.WHITE);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setVerticalAlignment(SwingConstants.CENTER);


        if (gameState.gameIsOver()) {
            if (gameState.isAWinForX()) {

                messageLabel.setText("Game Over! X Won");
            }else if (gameState.isAWinForO()) {
                messageLabel.setText("Game Over! O Won");

            } else {
                messageLabel.setForeground(Color.BLACK);
                messageLabel.setText("Game Over! This game is a draw.");
            }
        } else {
            if (gameState.getActivePlayer().getCharacter().equals(Cell.X)) {

                messageLabel.setText("X's turn.");
            } else {
                messageLabel.setText("O's turn.");
            }
        }
        this.repaint();
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
        refreshBoard();
    }


    }
