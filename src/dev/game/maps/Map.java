package dev.game.maps;

import dev.game.Handler;
import dev.game.gameobject.BreakableWall;
import dev.game.gameobject.ObjectManager;
import dev.game.gameobject.SideWall;
import dev.game.gameobject.SolidWall;
import dev.game.gameobject.moveableobject.Tank;
import dev.game.gfx.Assets;
import dev.game.tiles.Tile;
import dev.game.util.Util;

import java.awt.*;

public class Map {

    private Handler handler;
    private int width, height;
    private int spawnX1, spawnX2, spawnY1, spawnY2;
    private int[][] tiles;
    private ObjectManager objectManager;

    public Map(Handler handler, String path) {

        this.handler = handler;
        objectManager = new ObjectManager(handler, new Tank(handler, Assets.tank, 256, 16, 600, 715));
        loadWorld(path);
    }

    public void tick(){

        objectManager.tick();
    }

    public void render(Graphics g){

        for(int i = 0; i < height; i++)
        {
            for(int j = 0; j < width; j++)
            {
                getTile(j, i).render(g, (int)(j * Tile.TILE_WIDTH - handler.getCamera().getxOff()), (int)(i * Tile.TILE_HEIGHT - handler.getCamera().getyOff()));
            }
        }
        objectManager.render(g);
    }

    public Tile getTile(int x, int y){
        if(x < 0 || x >= width || y < 0 || y >= height)
        {
            return Tile.ground;
        }

        Tile t = Tile.tiles[tiles[x][y]];
        if(t == null)
        {
            return Tile.ground;
        }
        else
        {
            return t;
        }
    }

    private void loadWorld(String path) {

        String file = Util.loadFileAsString(path);
        String[] tokens = file.split("\\s+");
        width = Util.parseInt(tokens[0]);
        height = Util.parseInt(tokens[1]);
        spawnX1 = Util.parseInt(tokens[2]);
        spawnY1 = Util.parseInt(tokens[3]);
        spawnX2 = Util.parseInt(tokens[4]);
        spawnY2 = Util.parseInt(tokens[5]);

        tiles = new int[width][height];
        for(int y = 0; y < height; y++)
        {
            for(int x = 0; x < width; x++)
            {
                tiles[x][y] = Util.parseInt(tokens[(x + y * width) + 6]);
                if(tiles[x][y] == 1)
                {
                    objectManager.addObject(new SolidWall(handler, x * 64, y * 64, 64, 64));
                }
                else if(tiles[x][y] == 2)
                {
                    objectManager.addObject(new BreakableWall(handler, x * 64, y * 64, 64, 64));
                    objectManager.setBoxNum(objectManager.getBoxNum() + 1);
                }
                else if(tiles[x][y] == 3)
                {
                    objectManager.addObject(new SideWall(handler, x * 64, y * 64, 64, 64));
                }
            }
        }
//        objectManager.printContents();

    }

    public int[][] getTileArray(){

        return tiles;
    }

    public void setTileArray(int x, int y, int num){

        this.tiles[x][y] = num;
    }

    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }

    public ObjectManager getObjectManager() {
        return objectManager;
    }


    public void setObjectManager(ObjectManager objectManager) {
        this.objectManager = objectManager;
    }
}
