package dev.game.gameobject;

import dev.game.Handler;
import dev.game.gfx.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ScoreBoard extends GameObject{

    private int score = 0;
    private BufferedImage livesImg = Assets.poweruplives;

    public ScoreBoard(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        g.setColor(Color.black);
        g.drawRect((int)x, (int)y, width, height);
        for(int i = 0; i < handler.getMap().getObjectManager().getTank1().getLives(); i++){
//            g.fillRect((int)this.x + (12 * i),(int)this.y, 10, 10);
            g.drawImage(livesImg, (int)this.x + (18 * i), (int)this.y, null);
        }
        g.setColor(Color.black);
        g.fillRect((int)this.x + width, (int)this.y + 20, handler.getMap().getObjectManager().getTank1().getShootDelay(), 30);

//        g.fillRect((int)this.x + width + 200, (int)this.y + 20, handler.getMap().getObjectManager().getTank1().getShootDelay() - 198, 30);
        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 50));
        g.drawString(Integer.toString(score), (int)x + 20, (int)y + height);
    }

    @Override
    public void die(){

    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addToScore(int add)
    {
        this.score += add;
    }
}
