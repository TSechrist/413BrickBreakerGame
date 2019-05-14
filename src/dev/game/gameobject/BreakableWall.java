package dev.game.gameobject;

import dev.game.Handler;
import dev.game.gameobject.moveableobject.PowerUpLives;
import dev.game.gameobject.moveableobject.PowerUpPoints;

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
        handler.getMap().getObjectManager().getSb().addToScore(50);

        if((int)(Math.random() * 4) == 3)
        {
            if((int)(Math.random() * 4) == 3)
            {
                handler.getMap().getObjectManager().addObject(new PowerUpLives(handler, x + 24, y + 24, 16, 16));
            }
            else
            {
                handler.getMap().getObjectManager().addObject(new PowerUpPoints(handler, x + 24, y + 24, 16, 16));

            }
        }

        handler.getMap().getObjectManager().setBoxNum(handler.getMap().getObjectManager().getBoxNum() - 1);
        if(handler.getMap().getObjectManager().getBoxNum() == 0)
        {
            handler.getGame().nextLevel();
        }

    }

    @Override
    public void render(Graphics g) {

    }

    public void damage(int dmgAmt){
        health = health - dmgAmt;
    }
}