package dev.game.states;

import dev.game.Game;
import dev.game.Handler;
import dev.game.gameobject.moveableobject.Tank;
import dev.game.gfx.Assets;
import dev.game.maps.Map;
import dev.game.tiles.Tile;

import java.awt.*;

public class GameState extends State {

    private Map map;

    public GameState(Handler handler){
        super(handler);
        map = new Map(handler, "\\src\\res\\mapresourses\\map3.txt");
        handler.setMap(map);

    }

    @Override
    public void tick() {
        map.tick();
    }

    @Override
    public void render(Graphics g) {
        map.render(g);

    }
}

