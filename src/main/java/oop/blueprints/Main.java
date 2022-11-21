package oop.blueprints;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int MAX=3;
        boolean alive = true;
        boolean Flag = false;
        boolean[] status= {alive,Flag};
        int[] RawData;
        RawData = new int[MAX]; //Creating an array of input words
        String[] OnScreenInstructions;
        OnScreenInstructions = new String[]{"height","width","number of bombs"};
        textHandle TextHandle = new textHandle();
        for (int i =0; i<MAX; i++){ //asking user for grid data
            System.out.println("Enter "+OnScreenInstructions[i]);
            do {
                Flag=false;
                RawData[i]=TextHandle.Convert();
                if (RawData[i]<=0){
                    Flag=true;
                    System.out.println("Please enter a number larger than 0");
                }
            } while (Flag);
        }
        Grid grid = new Grid(RawData[0], RawData[1],RawData[2]);//i am initilising a basic grid of 5x5 and 1 mine
        while (status[0]) {
            status = TextHandle.Click(grid);
        }
    }
}