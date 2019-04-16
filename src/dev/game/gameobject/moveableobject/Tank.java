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
    private int width, height;
    private int playerNumber;
    private int shootDelay = 0;
    private int lives = 2;
    private float spawnX, spawnY;

    public Tank(int playerNumber, Handler handler, BufferedImage img, int width, int height, float x, float y){

        super(playerNumber, handler, x, y, width, height);
        spawnX = x;
        spawnY = y;
        this.img = img;
        this.playerNumber = playerNumber;

    }

    @Override
    public void tick() {

        if(health <= 0)
        {
            die();
        }
        shootDelay--;
        getInput();
        handler.getCamera().centerOnTank(this);
    }

    @Override
    public void die(){

        if(lives <= 0){
//            handler.getMap().getObjectManager().removeObject(this);
//            System.out.println("Game Over");
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

    private void getInput(){

        if(playerNumber == 1)
        {
            if(handler.getKeyManager().up1)
                moveForward();
            if(handler.getKeyManager().down1)
                moveBackward();
            if(handler.getKeyManager().left1)
                rotateLeft();
            if(handler.getKeyManager().right1)
                rotateRight();
            if(handler.getKeyManager().shoot1)
            {
                if(shootDelay < 0)
                {
                    tankShoot();
                    shootDelay = 20;
                }
            }

        }
        if(playerNumber == 2)
        {
            if(handler.getKeyManager().up2)
                moveForward();
            if(handler.getKeyManager().down2)
                moveBackward();
            if(handler.getKeyManager().left2)
                rotateLeft();
            if(handler.getKeyManager().right2)
                rotateRight();
            if(handler.getKeyManager().shoot2)
            {
                if(shootDelay < 0)
                {
                    tankShoot();
                    shootDelay = 20;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {

        AffineTransform rotation = AffineTransform.getTranslateInstance(x - handler.getCamera().getxOff(), y - handler.getCamera().getyOff());
        rotation.rotate(Math.toRadians(angle), img.getWidth() / 2.0, img.getHeight() / 2.0);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(img, rotation, null);
        g.setColor(Color.red);
        for(int i = 0; i < lives; i++){
            g.fillRect((int)(x - handler.getCamera().getxOff() + (i * 12)), (int)(y - handler.getCamera().getyOff() + 66), 10, 10);
        }
//        g.drawRect((int)(x + bounds.x - handler.getCamera().getxOff()),
//                (int)(y + bounds.y - handler.getCamera().getyOff()),
//                bounds.width, bounds.height);
        g.setColor(Color.green);
        g.fillRect((int)(x - handler.getCamera().getxOff()), (int)(y - handler.getCamera().getyOff() - 12), (int)(health * .6), 10);
    }

    public int getPlayerNumber(){

        return playerNumber;
    }


}
