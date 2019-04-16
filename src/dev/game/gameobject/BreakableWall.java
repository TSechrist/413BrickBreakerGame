package dev.game.gameobject;

import dev.game.Handler;

import java.awt.*;

public class BreakableWall extends GameObject {


    public BreakableWall(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
        health = 25;

    }

    @Override
    public void tick() {

        if(health <= 0){
            die();
        }
    }

    @Override
    public void die(){
//        System.out.println(x / 64 + " " + y / 64);
//        handler.getMap().getTile((int)(x / 64), (int)(y / 64)).setId(0);
//        handler.getMap().getTileArray()[(int)x][(int)y] = 0;

        handler.getMap().setTileArray((int)(x / 64), (int)(y / 64), 0);
        handler.getMap().getObjectManager().removeObject(this);
        handler.getMap().getObjectManager().addObject(new PowerUp(handler, x + 24, y + 24, 16, 16));

    }

    @Override
    public void render(Graphics g) {

    }

    public void damage(int dmgAmt){
        health = health - dmgAmt;
    }
}