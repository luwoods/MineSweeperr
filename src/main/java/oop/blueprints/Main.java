package oop.blueprints;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        int MAX=3;
        boolean alive = true;
        int[] RawData;
        RawData = new int[MAX];
        String[] Words;
        Words = new String[]{"width","height","number of bombs"};
        String Input="";
        textHandle TextHandle = new textHandle();
        for (int i =0; i<MAX; i++){
            System.out.println("Enter "+Words[i]);
            Input = TextHandle.ReadInput();
            RawData[i]=TextHandle.Convert(Input);
        }
        Grid grid = new Grid(RawData[0], RawData[1],RawData[2]);//i am initilising a basic grid of 5x5 and 1 mine
        while (alive) {
            alive = TextHandle.Click(grid);
        }
    }
}