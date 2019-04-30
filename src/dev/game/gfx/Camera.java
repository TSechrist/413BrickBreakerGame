package dev.game.gfx;

import dev.game.Game;
import dev.game.Handler;
import dev.game.gameobject.GameObject;
import dev.game.tiles.Tile;

public class Camera {

    private float xOff, yOff;
    private Handler handler;

    public Camera(Handler handler, float xOff, float yOff) {

        this.handler = handler;
        this.xOff = xOff;
        this.yOff = yOff;

    }

    public void checkBlankSpace(){

        if(xOff < 0){
            xOff = 0;
        }
        else if(xOff > handler.getMap().getWidth() * Tile.TILE_WIDTH - handler.getWidth()){
            xOff = handler.getMap().getWidth() * Tile.TILE_WIDTH - handler.getWidth();
        }

        if(yOff < 0){
            yOff = 0;
        }
        else if(yOff > handler.getMap().getHeight() * Tile.TILE_HEIGHT - handler.getHeight()){
            yOff = handler.getMap().getHeight() * Tile.TILE_HEIGHT - handler.getHeight();
        }
    }

    public void move(float xMove, float yMove){

        xOff += xMove;
        yOff += yMove;
//        checkBlankSpace();
    }

    public void centerOnTank(GameObject o){

        xOff = o.getX() - handler.getWidth() / 2 + o.getWidth() / 2;
        yOff = o.getY() - handler.getHeight() / 2 + o.getHeight() / 2;
        checkBlankSpace();
    }

    public float getxOff() {
        return xOff;
    }

    public void setxOff(float xOff) {
        this.xOff = xOff;
    }

    public float getyOff() {
        return yOff;
    }

    public void setyOff(float yOff) {
        this.yOff = yOff;
    }
}
