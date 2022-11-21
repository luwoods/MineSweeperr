package oop.blueprints;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class TextHandle {
    public String ReadInput() throws IOException {
        BufferedReader ConsoleText = new BufferedReader(new InputStreamReader(System.in));
        return ConsoleText.readLine();
    }
    public void screenRefresh(Grid grid){
        int x=grid.getxSize();
        int y=grid.getySize(); //we need to show x and y swapped because arrays are transposed to how a grid would look
        for (int i=0;i<x; i++) {
            for (int j=0;j<y; j++) {
                boolean t1 = grid.tiledGrid[j][i].isRevealed();
                boolean t2 = grid.tiledGrid[j][i].isMined();
                boolean t3 = grid.tiledGrid[j][i].isFlagged();
                if (t1 && t2){
                    System.out.print(" :( ");
                }else if (t3){
                    System.out.print(" |> ");
                }
                else if (!t1){
                    System.out.print(" -- ");
                }
                else{
                    int number = grid.tiledGrid[j][i].getNumber();
                    if (number == 0){
                        System.out.print("  . ");
                    }else{
                        System.out.print("  " + number + " ");
                    }
                }
            }
            System.out.print("\n");}
    }
    public int Convert() throws IOException {//method to check if the input string is valid or not
        int number=0;
        boolean flag;
        String input="";
        do {
            input=this.ReadInput();
            try {
                number = Integer.parseInt(input);
                flag = true;
            } catch (NumberFormatException ex) {
                System.out.println("Sorry, that's not a valid format");
                flag = false;
            }
        } while (!flag);
        return number;
    }
    public boolean[] Click(Grid grid) throws IOException {
        this.screenRefresh(grid);
        int[] coordinates={-1,-1};
        boolean markerForRepeat=false;
        boolean[] status ={true,false};//Status[0] is Alive/dead,status[1] is are you flagging
        System.out.println("Type F for flag, otherwise press any key to reveal");
        String Input = this.ReadInput();
        if (Objects.equals(Input, "F") || Objects.equals(Input, "f")){
            status[1]=true;
        }
        while(coordinates[0]<0||coordinates[0]>= grid.getxSize() || coordinates[1]<0 || coordinates[1]>=grid.getySize()) {
            if (markerForRepeat){
                System.out.println("Sorry, your coordinates are illegal, try again.");
            }
            coordinates = askCoordinates();
            markerForRepeat=true;
        }
        Tile DummyTile = grid.tiledGrid[coordinates[0]][coordinates[1]];//Adding for readability
        if (status[1]) {
            //if it's  not flagged, flag
            //unflag
            DummyTile.setFlagged(!DummyTile.isFlagged() && !DummyTile.isRevealed());
        }else
        {
            if (!DummyTile.isRevealed()&&(!DummyTile.isFlagged())) {  //you cant reveal something twice and you cant click on a flag
                if (DummyTile.getNumber() == 0) {
                    grid.Reveal(coordinates[0], coordinates[1]);
                }
                DummyTile.setRevealed(true);
                if (DummyTile.isMined()) {
                    for (int i = 0; i < grid.getxSize(); i++) { //when you die you want to be shown every mine
                        for (int j = 0; j < grid.getySize(); j++) {
                            if (grid.tiledGrid[i][j].isMined()) {
                                grid.tiledGrid[i][j].setRevealed(true);
                            }
                        }
                    }
                    status[0] = false;
                    this.screenRefresh(grid);
                    System.out.println("You have died.");
                }
            }
            if (grid.getRevealedLeft() <= 0 && status[0]) { //Checking win condition, you have to be alive still
                this.screenRefresh(grid);
                System.out.println("Congratulations, you've won");
                status[0] = false;
            }
        }
        return status;
    }

    private int[] askCoordinates() throws IOException {
        int[] coord = {0, 0};
        System.out.println("Please enter a X coordinate.");
        coord[0] = this.Convert() - 1; //I'm using human convention to ask the human to type in the coordinate
        //I've also transposed the grid because my internal coordinates actually display as Y vs X
        System.out.println("Please enter an Y coordinate.");
        coord[1] = this.Convert() - 1;
        return coord;
    }
}


