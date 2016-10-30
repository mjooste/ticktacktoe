package gui;

import game.*;

import game.Cell;
import game.CommunicationLink;
import game.GameStyle;
import game.NetworkedGameState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class NetworkSetupFrame extends JFrame {
    public static final int PORTNUM = 9933;

    private JComboBox comboBox;
    private JLabel outputLabel;
    private JLabel hostLabel;
    private JTextField hostName;
    private JButton startButton;

    private GameState gameState;



    public NetworkSetupFrame() {
        super();
        initGui();


        setTitle("Network");
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


        setLayout(new BorderLayout());
        JLabel background = new JLabel(new ImageIcon("network.png"));
        add(background);
        background.setLayout(new GridLayout(1, 1, 40, 30));

    }


    public void initGui() {
        this.setLayout(new GridLayout(5, 1));
        comboBox = new JComboBox();
        comboBox.addItem("Host");
        comboBox.addItem("Join");

        hostLabel = new JLabel("<html><br><br><br><br>Host Name<html>");
        hostName = new JTextField();

        hostLabel.setVisible(false);
        hostName.setVisible(false);

        comboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                if (comboBox.getSelectedItem().equals("Join")) {
                    hostLabel.setVisible(true);
                    hostName.setVisible(true);
                } else {
                    hostLabel.setVisible(false);
                    hostName.setVisible(false);
                }
            }
        });
        outputLabel = new JLabel("");

        startButton = new JButton("Start");
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                NetworkedGameState gameState = null;
                if (comboBox.getSelectedItem().equals("Host")) {
                    outputLabel.setText("Hosting on port " + PORTNUM);
                    //host plays X
                    gameState = new NetworkedGameState(GameStyle.NETWORKED, Cell.X);
                } else {
                    outputLabel.setText("Connecting to " + hostName.getText() + " " + PORTNUM);
                    //client plays O
                    gameState = new NetworkedGameState(GameStyle.NETWORKED, Cell.O);
                }
                try {
                    CommunicationLink communicationLink = new CommunicationLink(comboBox.getSelectedItem().toString(), hostName.getText(), PORTNUM);
                    communicationLink.setNetworkedGameState(gameState);
                    gameState.setCommunicationLink(communicationLink);
                    communicationLink.start();
                    NetworkSetupFrame.this.dispose();
                    GameFrame gameFrame = new GameFrame();
                    gameFrame.setGameState(gameState);
                    gameState.setGameFrame(gameFrame);

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        hostLabel.setForeground(Color.WHITE);
        hostLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        this.add(comboBox);
        this.add(hostLabel);
        this.add(hostName);
        this.add(startButton);
        this.add(outputLabel);

        //this.setSize(new Dimension(500,600));
        //this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //this.setVisible(true);

    }
}
























//public class NetworkSetupFrame extends JFrame {
//    public static final int PORTNUM = 9933;
//
//    private JComboBox comboBox;
//    private JLabel outputLabel;
//    private JLabel hostLabel;
//    private JTextField hostName;
//    private JButton startButton;
//
//    public NetworkSetupFrame(){
//        super();
//        initGui();
//    }
//
//    public void initGui(){
//        this.setLayout(new GridLayout(5,1));
//        comboBox = new JComboBox();
//        comboBox.addItem("Host");
//        comboBox.addItem("Join");
//
//        hostLabel = new JLabel("Host Name");
//        hostName = new JTextField();
//
//        hostLabel.setVisible(false);
//        hostName.setVisible(false);
//
//        comboBox.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent actionEvent) {
//                if (comboBox.getSelectedItem().equals("Join")) {
//                    hostLabel.setVisible(true);
//                    hostName.setVisible(true);
//                } else {
//                    hostLabel.setVisible(false);
//                    hostName.setVisible(false);
//                }
//            }
//        });
//        outputLabel = new JLabel("");
//
//        startButton = new JButton("Start");
//        startButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent actionEvent) {
//                NetworkedGameState gameState = null;
//                if(comboBox.getSelectedItem().equals("Host")){
//                    outputLabel.setText("Hosting on port " + PORTNUM);
//                    //host plays X
//                    gameState = new NetworkedGameState(GameStyle.NETWORKED, Cell.X);
//                }else{
//                    outputLabel.setText("Connecting to " + hostName.getText() +" " + PORTNUM);
//                    //client plays O
//                    gameState = new NetworkedGameState(GameStyle.NETWORKED,Cell.O);
//                }
//                try{
//                    CommunicationLink communicationLink = new CommunicationLink(comboBox.getSelectedItem().toString(), hostName.getText(), PORTNUM);
//                    communicationLink.setNetworkedGameState(gameState);
//                    gameState.setCommunicationLink(communicationLink);
//                    communicationLink.start();
//                    NetworkSetupFrame.this.dispose();
//                    GameFrame gameFrame = new GameFrame();
//                    gameFrame.setGameState(gameState);
//                    gameState.setGameFrame(gameFrame);
//
//                }catch (IOException ex){
//                    ex.printStackTrace();
//                }
//            }
//        });
//        this.add(comboBox);
//        this.add(hostLabel);
//        this.add(hostName);
//        this.add(startButton);
//        this.add(outputLabel);
//
//        this.setSize(new Dimension(500,600));
//        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        this.setVisible(true);
//    }
//
//
//
//
//}
