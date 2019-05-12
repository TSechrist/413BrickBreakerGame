package dev.game;

import dev.game.display.Display;

public class Launcher {

    public static void main(String[] args) {

        int width = 1536;
        int height = 832;
        Game game = new Game("Test Game!", width, height);
        game.start();
    }
}