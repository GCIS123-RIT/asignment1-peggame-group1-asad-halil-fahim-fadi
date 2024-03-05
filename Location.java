package Workspace;

import Workspace.FileReader;
public class Location {

    //This defines the actual location on the board.
    
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