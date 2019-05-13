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
    private int mapNumber = 0;
    private int scoreTotal = 0;
    private int lifeTotal = 0;

    public GameState(Handler handler){
        super(handler);
        map = new Map(handler, "\\src\\res\\mapresourses\\map3.txt");
        handler.setMap(map);
        mapNumber++;
        System.out.println("****: " + handler.getMap().getObjectManager().getBoxNum());

    }

    @Override
    public void tick() {
        map.tick();
    }

    @Override
    public void render(Graphics g) {
        map.render(g);

    }
    public void nextMap()
    {
        if(mapNumber == 1)
        {
            scoreTotal += handler.getMap().getObjectManager().getSb().getScore();
            lifeTotal = handler.getMap().getObjectManager().getTank1().getLives();
            map = new Map(handler, "\\src\\res\\mapresourses\\map2.txt");
            handler.setMap(map);
            mapNumber++;
            System.out.println("****: " + handler.getMap().getObjectManager().getBoxNum());
            handler.getMap().getObjectManager().getSb().setScore(scoreTotal);
            handler.getMap().getObjectManager().getTank1().setLives(lifeTotal);

        }
        else
        {
            handler.getGame().setState(handler.getGame().endState);
        }
    }
}

