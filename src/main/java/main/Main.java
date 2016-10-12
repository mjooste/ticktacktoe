package main;

import game.GameState;
import game.GameStyle;
import gui.GameFrame;

import java.io.IOException;

/**
 * Created by therina on 2016/10/01.
 */
public class Main {
    public static void main(String[] args)  {

        //Open the GUI
        new GameFrame(new GameState(GameStyle.TWO_PLAYER));

    }
}
