package dev.game.gameobject.moveableobject;

import dev.game.Game;
import dev.game.Handler;
import dev.game.gameobject.PowerUp;
import dev.game.gfx.Assets;
import dev.game.states.State;
import dev.game.tiles.Tile;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class Tank extends MoveableObject {

    private BufferedImage img;
    private int lives = 2;
    private float spawnX, spawnY;
    private int shootDelay = 0;

    public Tank(Handler handler, BufferedImage img, int width, int height, float x, float y){

        super(handler, x, y, width, height);
        spawnX = x;
        spawnY = y;
        this.img = img;

    }

    @Override
    public void tick() {

        getInput();
        shootDelay--;
    }

    @Override
    public void die(){

        if(lives <= 0){
            handler.getKeyManager().anyKeyPressed = false;
            handler.getGame().setState(handler.getGame().endState);
        }
        else{

            this.x = spawnX;
            this.y = spawnY;
            health = 100;
            lives--;
        }

    }

    public void damage(int dmgAmt){

        health = health - dmgAmt;
    }

    private void getInput() {

//        if(handler.getKeyManager().up)
//            moveUp();
//        if(handler.getKeyManager().down)
//            moveDown();
        if (handler.getKeyManager().left)
            moveLeft();
        if (handler.getKeyManager().right)
            moveRight();
        if (handler.getKeyManager().shoot){

            if (shootDelay < 0) {
                tankShoot();
                shootDelay = 20;
            }
        }
    }

    @Override
    public void render(Graphics g) {

//        AffineTransform rotation = AffineTransform.getTranslateInstance(x - handler.getCamera().getxOff(), y - handler.getCamera().getyOff());
//        rotation.rotate(Math.toRadians(angle), img.getWidth() / 2.0, img.getHeight() / 2.0);
//        Graphics2D g2d = (Graphics2D) g;
//        g2d.drawImage(img, rotation, null);

        g.drawImage(img, (int)x, (int)y, width, height, null);
        g.setColor(Color.red);
        g.drawRect((int)x, (int)y, bounds.width, bounds.height);
    }

    protected void tankShoot(){

        Ball b = new Ball(handler, Assets.bullet, (int)(x + (this.width / 2)), y - 50, 225, 16, 16);
        handler.getMap().getObjectManager().addObject(b);
    }
}
