package game;

import java.io.IOException;

/**
 * Created by therina on 2016/10/24.
 */

//sends messages to the other player, to say a move is made. Please update the board
public class CommunicationLink extends Thread {

    private NetworkedGameState gameState;
    private String role;
    private String hostName;
    private int portNum;
    private Point moveToSend;

    //sends the point as a string to the local player
    public CommunicationLink(String role, String hostName, int portNum ) throws IOException{
        this.role = role;
        this.hostName = hostName;
        this.portNum = portNum;
    }

    //link to NetworkedGameState
    public void setNetworkedGameState(NetworkedGameState networkedGameState){
        this.gameState = networkedGameState;
    }

    public void sendMove(Point movePoint){
        //sends the move point as a string to the remote player
        moveToSend = movePoint;
    }

    public void receiveSelectionAndMove(Point movePoint){
        //receives the move point as a string from the remote player
    }

}
