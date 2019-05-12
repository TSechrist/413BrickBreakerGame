package dev.game.tiles;

import dev.game.gfx.Assets;

public class SideWall extends Tile{

    public SideWall(int id){
        super(Assets.ground, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
