package dev.game.tiles;

import dev.game.gfx.Assets;

public class UnbreakableBox extends Tile{

    public UnbreakableBox(int id){
        super(Assets.box2, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
