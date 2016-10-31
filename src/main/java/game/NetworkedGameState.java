package game;

import gui.GameFrame;

/**
 * Created by therina on 2016/10/24.
 */
public class NetworkedGameState extends GameState {
    private GameFrame gameFrame;
    private Player localPlayer;
    private CommunicationLink communicationLink;


    //set what type of game it is
    public NetworkedGameState(GameStyle gameStyle, Cell localCharacter) {
        super(gameStyle);

        //which character is the local player
        //the board should only be active when the active player's character is equal to the local player's character
        if (localCharacter.equals(Cell.X)) {
            localPlayer = playerX;
        } else {
            localPlayer = playerO;
        }
    }

    //link
    public void setCommunicationLink(CommunicationLink communicationLink) {
        this.communicationLink = communicationLink;
    }

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    @Override
    public void doMove(Point point) {
        //player can only move something on the board if it is their turn
        if (getActivePlayer().getCharacter().equals(localPlayer.getCharacter())) {
            //do the move
            super.doMove(point);

            //move must gave been a success, so send the info to remote
            if (!getActivePlayer().getCharacter().equals(localPlayer.getCharacter())) {
                communicationLink.sendMove(point);
            }


        }
    }

    public void doCommunicationMove(Point point) {
        super.doMove(point);
        gameFrame.refreshBoard();
    }

    public boolean isLocalPlayerTurn() {
        return localPlayer.equals(getActivePlayer());

    }
}

