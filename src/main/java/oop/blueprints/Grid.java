package oop.blueprints;
import java.util.Random;
public class Grid {
    private int xSize;
    private int ySize;
    private int TotalMines;
    private class tiled{
        boolean Flagged;
        boolean Mined = false; //we only need to flip 0s into 1s
        public tiled(boolean mined){
            this.Mined = mined;
        }
        public void setMined(boolean mined) {
            Mined = mined;
        }

        public boolean isMined() {
            return Mined;
        }

        public void setFlagged(boolean flagged) {
            Flagged = flagged;
        }
    }
    public Grid(int x, int y, int No) {//constructor
        this.xSize = x;
        this.ySize = y;
        this.TotalMines = No;
    }

    public tiled[][] tiledGrid = new tiled[xSize][ySize];
    public void startTiles(){
        Random random = new Random();
        for(int i =0; i<TotalMines; i++){
            int randX = random.nextInt(xSize);
            int randY = random.nextInt(ySize);
            tiledGrid[randX][randY].setMined(true);
        }
    }
}
