package dev.game.tiles;

import dev.game.gfx.Assets;

public class ObjBox extends Tile {

    public ObjBox(int id){
        super(Assets.objBox, id);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
