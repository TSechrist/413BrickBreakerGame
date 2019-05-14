package dev.game.tiles;

import dev.game.gameobject.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {

    public static Tile[] tiles = new Tile[20];
    public static Tile ground = new Ground(0);
    public static Tile unbreakableBox = new UnbreakableBox(1);
    public static Tile breakableBox = new BreakableBox(2);
    public static Tile sideWall = new SideWall(3);
    public static Tile objBox = new ObjBox(4);

    public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;

    protected BufferedImage img;
    protected int id;

    public Tile(BufferedImage img, int id){
        this.img = img;
        this.id = id;

        tiles[id] = this;
    }

    public void tick(){

    }

    public void render(Graphics g, int x, int y){

        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }


    public int getId(){
        return id;
    }

    public void setId(int num){

        this.id = num;
    }

    public boolean isSolid(){
        return false;
    }
}
