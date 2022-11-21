package oop.blueprints;
public class Tile{
    private boolean flagged;
    private boolean mined; //we only need to flip 0s into 1s
    private boolean revealed = false;
    private int number;

    public boolean isRevealed() {return revealed;}

    public void setRevealed(boolean revealed) {
        this.revealed = revealed;
    }

    public boolean isFlagged() {
        return flagged;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public Tile(boolean mined){
        this.mined = mined;
    }
    public void setMined(boolean mined){this.mined =mined;}
    public boolean isMined() {return this.mined;}
    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }
}