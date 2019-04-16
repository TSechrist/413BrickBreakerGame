package dev.game.tiles;

import dev.game.gfx.Assets;

public class Ground extends Tile {

    public Ground(int id){
        super(Assets.ground, id);
    }

    @Override
    public boolean isSolid() {
        return false;
    }

}
