package dev.game.states;

import dev.game.Game;
import dev.game.Handler;
import dev.game.gfx.Assets;

import java.awt.*;

public class MenuState extends State {

    public MenuState(Handler handler){
        super(handler);

    }

    @Override
    public void tick() {

        if(handler.getKeyManager().anyKeyPressed)
        {
            State.setState(handler.getGame().gameState);
        }

    }

    @Override
    public void render(Graphics g) {

        g.drawImage(Assets.menuScreen, 0, 0, 1600, 800, null);
    }
}
