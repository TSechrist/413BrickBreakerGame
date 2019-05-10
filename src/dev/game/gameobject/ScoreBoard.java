package dev.game.gameobject;

import dev.game.Handler;

import java.awt.*;

public class ScoreBoard extends GameObject{


    public ScoreBoard(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.blue);
        g.drawRect((int)x, (int)y, width, height);
    }

    @Override
    public void die(){

    }
}
