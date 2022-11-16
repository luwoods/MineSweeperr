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
    private boolean EdgeChecker(int TopEdge, int TileCounter,int BottomEdge){// deprecated EdgeChecker module
        if(TopEdge==0){/*if we're on an edge*/
            return true;/* skip the first row*/
        } else if (TopEdge+TileCounter<BottomEdge) {
            return true;
        }
        return false;
    }

    public Grid(int x, int y, int No) {//constructor
        this.xSize = x;
        this.ySize = y;
        this.TotalMines = No;
        Random random = new Random();
        int RunningTotal;
        this.tiledGrid = new Tile[xSize][ySize];
        for (int i =0; i<xSize;i++){
            for(int j=0; j<ySize;j++){
                tiledGrid[i][j] = new Tile(false);
            }

        }
        for(int i =0; i<TotalMines; i++){ /* radnomly generates mines*/
            int randX = random.nextInt(xSize);// nextInt is between 0 and xSize-1
            int randY = random.nextInt(ySize);// nextInt is between 0 and ySize-1
            while (tiledGrid[randX][randY].isMined()==false){
                tiledGrid[randX][randY].setMined(true);
            }
        }
        for(int i=0;i<xSize;i++){/* We re going to look at the whole grid */
            for(int j=0;j<ySize;j++) {
                if (tiledGrid[i][j].isMined() == false) { /* only assign a number if it is not a mine*/
                    RunningTotal=0;
                    for (int k = -1; k < 1; k++) { /* one of the tiles will look at every tile ABOVE it first, row first */
                        for (int l = -1; l < 1; l++){
                            if((i+k>=0) && (i+k<=xSize) &&(j+l>=0)&&(j+l<=ySize) ){/*checking if its inside the edges*/
                                if (tiledGrid[i+k][j+l].isMined()) { /*We cant put this statement onto the same one above because we dont't know if we can access it*/
                                    RunningTotal++;
                                }
                            }
                        }
                    }
                    tiledGrid[i][j].setNumber(RunningTotal);
                }
            }
        }
    }
}
