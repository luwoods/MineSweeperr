package oop.blueprints;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class textHandle {
    public String ReadInput() throws IOException {
        BufferedReader ConsoleText = new BufferedReader(new InputStreamReader(System.in));
        return ConsoleText.readLine();
    }
    public void screenRefresh(Grid grid){
        int x=grid.getxSize();
        int y=grid.getySize();
        for (int i=0;i<x; i++) {
            for (int j=0;j<y; j++) {
                boolean t1 = grid.tiledGrid[i][j].isRevealed();
                boolean t2 = grid.tiledGrid[i][j].isMined();
                if (t1 && t2){
                    System.out.print(":(");
                } else if (!t1){
                    System.out.print("--");
                }
                else if (t2){
                    System.out.print("#");
                }
                else if (t1 && !t2){
                    int number = grid.tiledGrid[i][j].getNumber();
                    System.out.print("."+number);
                }
            }
            System.out.print("\n");}
    }
    public int Convert(String str){
        int number=0;
        try{
        number = Integer.parseInt(str);
    }
        catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return number;
    }
    public boolean Click(Grid grid) throws IOException {
        this.screenRefresh(grid);
        int x;
        int y;
        boolean alive = true;
        System.out.println("Please enter an X coordinate.");
        String Input = this.ReadInput();
        x = this.Convert(Input)-1;
        System.out.println("Please enter a Y coordinate.");
        Input = this.ReadInput();
        y = this.Convert(Input)-1;
        grid.tiledGrid[x][y].setRevealed(true);
        if (grid.tiledGrid[x][y].isMined()) {
            alive = false;
            this.screenRefresh(grid);
        }
        return alive;
    }
}

