package oop.blueprints;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int Xcor=5;
        int Ycor =5;
        int mines = 1;
        System.out.print("Give me an input");
        String read = textHandle.ReadInput();//testint text input
        System.out.println(read);
        Grid grid = new Grid(Xcor, Ycor, mines);//i am initilising a basic grid of 5x5 and 1 mine

        grid.startTiles();
        for (int i=0;i<Xcor; i++) {

            for (int j=0;j<Ycor; j++) {

                boolean truth = grid.tiledGrid[Xcor][Ycor].isMined();
                if (truth){

                }
            }
        }
    }
}