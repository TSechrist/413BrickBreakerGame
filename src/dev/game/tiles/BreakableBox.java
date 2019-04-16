package dev.game.tiles;

import dev.game.gfx.Assets;

public class BreakableBox extends Tile {

    public BreakableBox(int id){
        super(Assets.box1, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
