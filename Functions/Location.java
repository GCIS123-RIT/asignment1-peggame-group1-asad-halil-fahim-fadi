package Workspace.Functions;

public class Location {

    //This defines the actual location on the board.
    //TODO Attention, the fileReader.java file has essentially done everything that is needed.
    //TODO I will be working on this soon to optimize it. -FADI
    
    public int row;
    public int col;


    public Location(int mRow, int mCol)
    {
        this.row = mRow;
        this.col = mCol;
    }


    public int getRow(){return this.row;}
    public int getCol(){return this.col;}

}