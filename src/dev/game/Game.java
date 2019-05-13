package dev.game;

import dev.game.display.Display;
import dev.game.gfx.Assets;
import dev.game.gfx.Camera;
import dev.game.gfx.ImageLoader;
import dev.game.input.KeyManager;
import dev.game.states.EndState;
import dev.game.states.GameState;
import dev.game.states.MenuState;
import dev.game.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game implements Runnable {

    private int width, height;

    private Display display;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;
    private Graphics g1;

    public State gameState;
    public State menuState;
    public State endState;

    private KeyManager keyManager;

    private Camera camera;

    private Handler handler;


    public Game(String title,int width, int height){
        this.width = width;
        this.height = height;
        this.title = title;
        keyManager = new KeyManager();
    }

    private void init(){
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        handler = new Handler(this);
        camera = new Camera(handler, 0, 0);

        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        endState = new EndState(handler);
        State.setState(gameState);
    }

    private void tick(){
        keyManager.tick();
        if(State.getState() != null)
            State.getState().tick();

    }

    private void render(){

        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy((3));
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0,0, width, height);
        //Draw Here

        if(State.getState() != null)
            State.getState().render(g);

        //End End Drawing
        bs.show();
        g.dispose();
    }

    public void run(){

        init();

        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                tick();
                render();
                ticks++;
                delta--;
            }

        }
        stop();
    }

    public KeyManager getKeyManager(){

        return keyManager;
    }

    public Camera getCamera(){
        return camera;
    }

    public synchronized void start(){
        if(running){
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();

    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getWidth(){
            return width;
        }

    public int getHeight(){
        return height;
    }

    public Display getDisplay(){
        return display;
    }

    public void nextLevel(){
        if(State.getState() instanceof GameState)
        {
            ((GameState) State.getState()).nextMap();
        }

    }

    public State getState(){
        return State.getState();
    }

    public void setState(State state){

        State.setState(state);
    }

}


