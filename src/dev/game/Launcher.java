package dev.game;

import dev.game.display.Display;

public class Launcher {

    public static void main(String[] args) {

        int width = 1600;
        int height = 800;
        Game game = new Game("Test Game!", width, height);
        game.start();
    }
}