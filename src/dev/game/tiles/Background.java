package dev.game.tiles;

import dev.game.Game;
import dev.game.gfx.Assets;

import java.awt.*;

public class Background extends Tile{

    public Background(int id){
        super(Assets.background, id);
    }

    @Override
    public boolean isSolid() {
        return super.isSolid();
    }

    @Override
    public void render(Graphics g, int x, int y){

//        g.drawImage(img, x, y, Game.width, Game.height, null);
        g.drawImage(img, x, y, 1920, 1080, null);
    }
}
