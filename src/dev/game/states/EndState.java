package dev.game.states;

import dev.game.Game;
import dev.game.Handler;
import dev.game.gfx.Assets;

import java.awt.*;
import java.awt.event.WindowEvent;

public class EndState extends State {

    public EndState(Handler handler){
        super(handler);

    }

    @Override
    public void tick() {

        if(handler.getKeyManager().anyKeyPressed)
        {
            handler.getGame().getDisplay().getFrame().dispatchEvent(new WindowEvent(handler.getGame().getDisplay().getFrame(), WindowEvent.WINDOW_CLOSING));
        }

    }

    @Override
    public void render(Graphics g) {

        g.drawImage(Assets.gameover, 0, 0, 1600, 800, null);
    }
}