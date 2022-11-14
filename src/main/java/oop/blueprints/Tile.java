package oop.blueprints;
public class Tile{
    private boolean Flagged;
    private boolean Mined; //we only need to flip 0s into 1s
    private boolean Revealed= false;
    private int Number;

    public boolean isRevealed() {return Revealed;}

    public void setRevealed(boolean revealed) {
        Revealed = revealed;
    }

    public boolean isFlagged() {
        return Flagged;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public int getNumber() {
        return Number;
    }

    public Tile(boolean mined){
        this.Mined = mined;
    }
    public void setMined(boolean mined){this.Mined=mined;}
    public boolean isMined() {return this.Mined;}
    public void setFlagged(boolean flagged) {
        this.Flagged = flagged;
    }
}