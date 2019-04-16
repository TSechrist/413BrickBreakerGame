package dev.game.gameobject;

import dev.game.Handler;
import dev.game.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PowerUp extends GameObject {

    private BufferedImage img = Assets.powerup;

    public PowerUp(Handler handler, float x, float y, int width, int height) {
        super(handler, x, y, width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        g.drawImage(img, (int)x - (int)handler.getCamera().getxOff(), (int)y - (int)handler.getCamera().getyOff(), width, height, null);
    }

    @Override
    public void die() {

    }
}
