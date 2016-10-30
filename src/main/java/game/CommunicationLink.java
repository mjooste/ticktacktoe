package game;

//import sun.security.ntlm.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//sends messages to the other player, to say a move is made. Please update the board
public class CommunicationLink extends Thread {

    private NetworkedGameState gameState;
    private String role;
    private String hostName;
    private int portNum;
    private Point moveToSend;

    private DataInputStream in;
    private DataOutputStream out;

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

    public void receiveMove(Point movePoint){
        //receives the move point as a string from the remote player
        gameState.doCommunicationMove(movePoint);
    }

    //called when we call .start
    @Override
    public void run(){
        try{
            ServerSocket serverSocket = null;
            Socket socket = null;

            if (role.equals("Host")){
                serverSocket = new ServerSocket(portNum);
                //server socket waits for a client to connect with it
                socket = serverSocket.accept();
            }else {
                socket = new Socket(hostName,portNum);
            }
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            //if is local player's turn. Sending mode = true
            //if true sending mode
            //if false receiving mode
            boolean sendingMode = gameState.isLocalPlayerTurn();

            while (!gameState.gameIsOver()){
                if(sendingMode){
                    //check if we have a move to send
                    if (moveToSend == null){
                        System.out.println("sleeping");
                        sleep(1000L);
                    }else {
                        //convert point to a string
                        String pointString = moveToSend.toString();
                        out.writeUTF(pointString);
                        System.out.println("Write " + pointString);
                        moveToSend = null;
                        sendingMode = false;
                    }
                }
                //receive move
                else {
                    String pointString = in.readUTF();
                    //convert point string into a new point
                    System.out.println("Read " + pointString);
//                    Point point = new Point(pointString);
                    Point movePoint = new Point(pointString);
                    receiveMove(movePoint);
                    sendingMode = true;
                }
            }

            //send final move
            if (sendingMode && moveToSend!=null){
                String pointString = moveToSend.toString();
                out.writeUTF(pointString);
                System.out.println("Write " + pointString);
                moveToSend = null;
            }



            in.close();
            out.close();
            socket.close();
            if (serverSocket != null){
                serverSocket.close();
            }
        }catch (Exception e){
            System.out.print("Error: " + e.getMessage());
        }
    }

}
