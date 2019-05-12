package dev.game.gameobject;

import dev.game.Handler;
import dev.game.gameobject.moveableobject.Ball;
import dev.game.gameobject.moveableobject.Bullet;
import dev.game.gameobject.moveableobject.Tank;
import dev.game.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PowerUp extends GameObject {

    private BufferedImage img = Assets.powerup;
    private int SPEED = 5;

    public PowerUp(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

    @Override
    public void tick() {

        if(!checkObjectCollisions(0, y + SPEED))
        {
            this.y += SPEED;
        }

        if(this.checkObjectCollisions(0, y + SPEED)) {

            if (getObjectCollide(0, y + SPEED) instanceof BreakableWall || getObjectCollide(0, y + SPEED) instanceof Ball ||
                    getObjectCollide(0, y + SPEED) instanceof Bullet)
            {
                this.y += SPEED;
            }
            else if(getObjectCollide(0, y + SPEED) instanceof SideWall || getObjectCollide(0, y + SPEED) instanceof ScoreBoard)
            {
                handler.getMap().getObjectManager().removeObject(this);
            }
            else if(getObjectCollide(0, y + SPEED) instanceof Tank)
            {
                handler.getMap().getObjectManager().getSb().addToScore(500);
                handler.getMap().getObjectManager().removeObject(this);
            }
        }
    }

    @Override
    public void render(Graphics g) {

        g.drawImage(img, (int)x, (int)y, width, height, null);
    }

    @Override
    public void die() {

    }
}
