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
        g.setColor(Color.red);
        for(int i = 0; i < handler.getMap().getObjectManager().getTank1().getLives(); i++){
            g.fillRect((int)this.x + (12 * i),(int)this.y, 10, 10);
        }
    }

    @Override
    public void die(){

    }
}
