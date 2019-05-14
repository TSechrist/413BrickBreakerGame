package dev.game.gameobject;

import dev.game.Handler;
import dev.game.gameobject.moveableobject.PowerUpLives;
import dev.game.gameobject.moveableobject.PowerUpPoints;

import java.awt.*;

public class ObjBox extends GameObject {


    public ObjBox(Handler handler, float x, float y, int width, int height){
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
        handler.getMap().setTileArray((int)(x / 64), (int)(y / 64), 0);
        handler.getMap().getObjectManager().removeObject(this);
        handler.getMap().getObjectManager().getSb().addToScore(250);

        handler.getMap().getObjectManager().setObjNum(handler.getMap().getObjectManager().getObjNum() - 1);
        if(handler.getMap().getObjectManager().getObjNum() == 0)
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