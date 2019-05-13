package dev.game.gameobject.moveableobject;

import dev.game.Handler;
import dev.game.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tank extends MoveableObject {

    private BufferedImage img;
    private int lives = 2;
    private float spawnX, spawnY;
    private int shootDelay = 0;
    private boolean tankStartedGame = false;
    private boolean tankPowerUp = false;


    public Tank(Handler handler, BufferedImage img, int width, int height, float x, float y){

        super(handler, x, y, width, height);
        spawnX = x;
        spawnY = y;
        this.img = img;
        this.SPEED = 12;
    }

    @Override
    public void tick() {

        getInput();
        if(shootDelay >= 0)
        {
            shootDelay--;
        }
    }

    @Override
    public void die(){

        if(lives <= 0){
            handler.getKeyManager().anyKeyPressed = false;
            handler.getGame().setState(handler.getGame().endState);
        }
        else{
            health = 100;
            lives--;
            tankPowerUp = false;
            tankStartedGame = false;
        }

    }

    public void damage(int dmgAmt){

        health = health - dmgAmt;
    }

    private void getInput() {

        if (handler.getKeyManager().left)
            moveLeft();
        if (handler.getKeyManager().right)
            moveRight();
        if (handler.getKeyManager().gameStart && !tankStartedGame)
        {
            tankStart();
            tankStartedGame = true;
        }
        if (handler.getKeyManager().shoot && tankPowerUp){

            if (shootDelay <= 0) {
                tankShoot();
                shootDelay = 200;
            }
        }
    }

    @Override
    public void render(Graphics g) {

        if(!tankStartedGame)
        {
            g.drawImage(Assets.bullet34, (int)(x + (this.width / 2)), (int)y - 50, 16, 16, null);
        }
        g.drawImage(img, (int)x, (int)y, width, height, null);
        g.setColor(Color.red);
        g.drawRect((int)x, (int)y, bounds.width, bounds.height);
    }

    protected void tankShoot(){

        Bullet b1 = new Bullet(handler, Assets.bullet, (int)x - 36, y - 50, 270, 16, 16);
        Bullet b2 = new Bullet(handler, Assets.bullet, (int)x + this.width - 48, y - 50, 270, 16, 16);
        handler.getMap().getObjectManager().addObject(b1);
        handler.getMap().getObjectManager().addObject(b2);
    }

    protected void tankStart(){

        Ball b = new Ball(handler, Assets.bullet, (int)(x + (this.width / 2)), y - 50, 225, 16, 16);
        handler.getMap().getObjectManager().addObject(b);
        tankPowerUp = true;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public boolean isTankStartedGame() {
        return tankStartedGame;
    }

    public void setTankStartedGame(boolean tankStartedGame) {
        this.tankStartedGame = tankStartedGame;
    }

    public boolean isTankPowerUp() {
        return tankPowerUp;
    }

    public void setTankPowerUp(boolean tankPowerUp) {
        this.tankPowerUp = tankPowerUp;
    }

    public int getShootDelay()
    {
        return shootDelay;
    }

}
