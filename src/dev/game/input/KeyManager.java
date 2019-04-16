package dev.game.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyManager implements KeyListener {

    private boolean[] keys;
    public boolean up1, down1, left1, right1, up2, down2, left2, right2, shoot1, shoot2;
    public boolean anyKeyPressed = false;

    public KeyManager(){
        keys = new boolean[256];
    }

    public void tick(){
        up1 = keys[KeyEvent.VK_W];
        down1 = keys[KeyEvent.VK_S];
        left1 = keys[KeyEvent.VK_A];
        right1 = keys[KeyEvent.VK_D];
        shoot1 = keys[KeyEvent.VK_SPACE];

        up2 = keys[KeyEvent.VK_UP];
        down2 = keys[KeyEvent.VK_DOWN];
        left2 = keys[KeyEvent.VK_LEFT];
        right2 = keys[KeyEvent.VK_RIGHT];
        shoot2 = keys[KeyEvent.VK_ENTER];
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        keys[e.getKeyCode()] = true;
        anyKeyPressed = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {

        keys[e.getKeyCode()] = false;
    }
}
