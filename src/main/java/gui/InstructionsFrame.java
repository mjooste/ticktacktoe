package gui;

import game.*;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InstructionsFrame extends JFrame{

    private GameState gameState;
    private JLabel text;
    private JButton backButton;

    public InstructionsFrame() {


        //Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Back");


//        backButton = new JButton("Back to Menu");
//        backButton.addActionListener(new ActionListener() {
//            public void actionPerformed()
//        }
//


//        JMenuBar.add(backButton);
//
//        backButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent actionEvent) {
//                try{
//                    InstructionsFrame.this.dispose();
//                    GameFrame gameFrame = new GameFrame();
//                    gameFrame.setGameState(gameState);
//                    //gameState.setGameFrame(gameFrame);
//                }
//                catch (IOException ex){
//                    ex.printStackTrace();
//                }
//            }
//        });

//        InstructionsFrame.this.dispose();
//        GameFrame gameFrame = new GameFrame();
//        gameFrame.setGameState(gameState);
















//        gameState.setGameFrame(gameFrame);


        //JButton backButton = new JButton("hello");

//        backButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                InstructionsFrame.this.dispose();
//                new GameState(GameStyle.TWO_PLAYER);
//            }
//        });

        menuBar.add(menu);
        this.setJMenuBar(menuBar);





        setTitle("Instructions");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("instructions.png"));
        add(background);
        background.setLayout(new GridLayout(1, 1, 40, 30));

//        backButton = new JButton("Go Back");
        text = new JLabel("<html> <p> <br><br><br><br><br><br>Like the original Tic-Tac-Toe, Player 1 is represented by X and Player 2 is represented by O. " +
                "To start the game, Player 1 places an X on any one of the 81 empty squares, and then players alternate turns. " +
                "However, after the initial move, players must play the board that mirrors the square from the previous player. " +
                "<br><br>If the next move is to a board that has already been won, then that player may choose an open square on any board for that turn. " +
                "You win boards as usual, but you win the game when you win three boards together (across rows, columns or diagnols)." +
                "\n" +
                "<br><br>For instance, if the first move by X is the first image, player O is forced to play in the top-right corner as shown in the right image.<p></html>", SwingConstants.CENTER);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("SansSerif", Font.BOLD, 14));
        background.add(text);
        background.add(backButton);

    }

}


