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
    public int getRevealedLeft(){
        int runningTotal=0;
        for (int i=0;i<xSize;i++){
            for(int j=0;j<ySize;j++){
                if (this.tiledGrid[i][j].isRevealed()){
                    runningTotal++;
                }
            }
        }
        return (xSize*ySize - TotalMines-runningTotal);
    }

    private int ySize;
    private int TotalMines;

    public Tile[][] tiledGrid;
    private boolean EdgeChecker(int TopEdge, int TileCounter,int BottomEdge){// deprecated EdgeChecker module
        if(TopEdge==0){/*if we're on an edge*/
            return true;/* skip the first row*/
        } else return TopEdge + TileCounter < BottomEdge;
    }
    private boolean ifNotOOB(int distFromTop, int distFromLeft, int width, int height, int checkX, int checkY){
        //Our technique uses double for loops to iterate in a 3x3 grid. Its important to check that the squares actually
        //exist BEFORE attempting to access them and this method works with that.
        return ((distFromTop + checkX >= 0) && (distFromTop + checkX < width) && (distFromLeft + checkY >= 0) && (distFromLeft + checkY < height));
    }


    public void Reveal(int posX , int posY) {
        if(!this.tiledGrid[posX][posY].isMined() ){
            if ((this.tiledGrid[posX][posY].getNumber() == 0) && (!this.tiledGrid[posX][posY].isRevealed())) {
                for (int k = -1; k < 2; k++) { /* one of the tiles will look at every tile ABOVE it first, row first */
                    for (int l = -1; l < 2; l++) {
                        if (ifNotOOB(posX, posY, this.xSize, this.ySize, k, l)) {

                            this.tiledGrid[posX][posY].setRevealed(true);
                            Reveal(posX + k, posY + l); //If we click on a zero we want that zero to also reveal around itself

                        }
                    }
                }
            } else{
                this.tiledGrid[posX][posY].setRevealed(true);
            }
        }
    }


    public Grid(int x, int y, int No) {//constructor
        this.xSize = x;
        this.ySize = y;
        this.TotalMines = No; //need a way to track when you win
        int count=0;
        Random random = new Random();
        int RunningTotal;
        this.tiledGrid = new Tile[this.xSize][this.ySize];
        for (int i =0; i<this.xSize;i++){
            for(int j=0; j<this.ySize;j++){
                this.tiledGrid[i][j] = new Tile(false);
            }

        }
        //for(int i =0; i<TotalMines; i++){ /* radnomly generates mines*/
            do {
                int randX = random.nextInt(this.xSize);// nextInt is between 0 and xSize-1
                int randY = random.nextInt(this.ySize);// nextInt is between 0 and ySize-1
                if (!this.tiledGrid[randX][randY].isMined()) {
                    this.tiledGrid[randX][randY].setMined(true);
                    count ++;
                }
        } while (count < TotalMines);


        for(int i=0;i<this.xSize;i++){/* We re going to look at the whole grid */
            for(int j=0;j<this.ySize;j++) {
                if (!this.tiledGrid[i][j].isMined()) { /* only assign a number if it is not a mine*/
                    RunningTotal=0;
                    for (int k = -1; k < 2; k++) { /* one of the tiles will look at every tile ABOVE it first, row first */
                        for (int l = -1; l < 2; l++){
                            if(ifNotOOB(i,j,this.xSize,this.ySize,k,l)){/*checking if its inside the edges*/
                                if (this.tiledGrid[i+k][j+l].isMined()) { /*We cant put this statement onto the same one above because we dont't know if we can access it*/
                                    RunningTotal++;
                                }
                           }
                        }
                    }
                    this.tiledGrid[i][j].setNumber(RunningTotal);
                }
            }
        }
    }
}
