package dev.game.gameobject.moveableobject;

import dev.game.Handler;
import dev.game.gameobject.BreakableWall;
import dev.game.gameobject.ScoreBoard;
import dev.game.gameobject.SideWall;
import dev.game.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PowerUpPoints extends MoveableObject {

    private BufferedImage img = Assets.powerup;
    private int SPEED = 5;

    public PowerUpPoints(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

    @Override
    public void tick() {

        if(!checkObjectCollisions(0, SPEED))
        {
            this.y += SPEED;
        }

        if(checkObjectCollisions(0, SPEED)) {

            if (getObjectCollide(0, SPEED) instanceof BreakableWall || getObjectCollide(0, SPEED) instanceof Ball ||
                    getObjectCollide(0, SPEED) instanceof Bullet)
            {
                this.y += SPEED;
            }
            else if(getObjectCollide(0, SPEED) instanceof SideWall || getObjectCollide(0, SPEED) instanceof ScoreBoard)
            {
                handler.getMap().getObjectManager().removeObject(this);
            }
            else if(getObjectCollide(0, SPEED) instanceof Tank)
            {
                handler.getMap().getObjectManager().getSb().addToScore(100);
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
