package dev.game.gameobject.moveableobject;

import dev.game.Game;
import dev.game.Handler;
import dev.game.gameobject.GameObject;
import dev.game.gameobject.PowerUp;
import dev.game.gfx.Assets;

public abstract class MoveableObject extends GameObject {

    protected final int SPEED = 8;
    private final int ROTATE_SPEED = 4;

    protected int angle = 0;
    protected float vx, vy;

//    public MoveableObject(int playerNumber, Handler handler, float x, float y, int width, int height){
//        super(handler, x, y, width, height);
//
//    }

    public MoveableObject(Handler handler, float x, float y, int height, int width){
        super(handler, x, y, height, width);

    }

    protected void moveForward() {
        vx = (float) Math.round(SPEED * Math.cos(Math.toRadians(angle)));
        vy = (float) Math.round(SPEED * Math.sin(Math.toRadians(angle)));

        if(this instanceof Tank && getObjectCollide(vx, vy) instanceof PowerUp)
        {
            this.setHealth(100);
            handler.getMap().getObjectManager().removeObject(getObjectCollide(vx, vy));
        }

        if(!checkObjectCollisions(vx, vy))
        {
            x += vx;
            y += vy;
        }
    }
    protected void moveBackward() {
        vx = (float) Math.round(SPEED * Math.cos(Math.toRadians(angle)));
        vy = (float) Math.round(SPEED * Math.sin(Math.toRadians(angle)));
        if(!checkObjectCollisions(-vx, -vy))
        {
            x -= vx;
            y -= vy;
        }

    }
    protected void rotateLeft() {
        this.angle = ((this.angle % 360) - this.ROTATE_SPEED);

    }
    protected void rotateRight() {
        this.angle = ((this.angle % 360) + this.ROTATE_SPEED);

    }

    protected void moveUp(){

        if(!checkObjectCollisions(0, -SPEED)){

            y -= SPEED;
        }

    }

    protected void moveDown(){

        if(!checkObjectCollisions(0, SPEED)){

            y += SPEED;
        }
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
