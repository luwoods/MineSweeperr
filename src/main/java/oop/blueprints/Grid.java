package oop.blueprints;
import java.util.Random;
public class Grid {
    private int xSize;

    public int getxSize() {
        return xSize;
    }

    public int getySize() {
        return ySize;
    }

    public int getTotalMines() {
        return TotalMines;
    }

    private int ySize;
    private int TotalMines;

    public Tile[][] tiledGrid;

    public Grid(int x, int y, int No) {//constructor
        this.xSize = x;
        this.ySize = y;
        this.TotalMines = No;
        Random random = new Random();
        this.tiledGrid = new Tile[xSize][ySize];
        for (int i =0; i<xSize;i++){
            for(int j=0; j<ySize;j++){
                tiledGrid[i][j] = new Tile(false);
            }

        }
        for(int i =0; i<TotalMines; i++){
            int randX = random.nextInt(xSize);// nextInt is between 0 and xSize-1
            int randY = random.nextInt(ySize);// nextInt is between 0 and ySize-1
            tiledGrid[randX][randY].setMined(true);
        }

    }
}
