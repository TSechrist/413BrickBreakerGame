package dev.game.gameobject.moveableobject;

import dev.game.Game;
import dev.game.Handler;
import dev.game.gameobject.GameObject;
import dev.game.gameobject.PowerUp;
import dev.game.gfx.Assets;

public abstract class MoveableObject extends GameObject {

    private final int ROTATE_SPEED = 4;

    protected int angle = 0;
    protected int SPEED = 8;

    protected float vx, vy;

//    public MoveableObject(int playerNumber, Handler handler, float x, float y, int width, int height){
//        super(handler, x, y, width, height);
//
//    }

    public MoveableObject(Handler handler, float x, float y, int height, int width){
        super(handler, x, y, height, width);

    }

    protected void moveLeft(){

        if(!checkObjectCollisions(-SPEED, 0)){

            x -= SPEED;
        }
    }

    protected void moveRight(){

        if(!checkObjectCollisions(SPEED, 0)){

            x += SPEED;
        }
    }
    protected boolean CollisionWithTile(int x, int y){
        return handler.getMap().getTile(x, y).isSolid();
    }

    protected int getAngle(){
        return angle;
    }

}
