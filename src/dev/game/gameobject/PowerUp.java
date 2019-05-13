package dev.game.gameobject;

import dev.game.Handler;
import dev.game.gameobject.moveableobject.Ball;
import dev.game.gameobject.moveableobject.Bullet;
import dev.game.gameobject.moveableobject.MoveableObject;
import dev.game.gameobject.moveableobject.Tank;
import dev.game.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PowerUp extends MoveableObject {

    private BufferedImage img = Assets.powerup;
    private int SPEED = 5;

    public PowerUp(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {

        g.drawImage(img, (int)x, (int)y, width, height, null);
    }

    @Override
    public void die() {

    }
}
