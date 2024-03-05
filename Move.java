package Workspace;

public class Move {

    //This defines from and to, meaning the actual moving on a board.
    
    public Location from;
    public Location to;

    public Move(Location mFrom, Location mTo)
    {
        this.from = mFrom;
        this.to = mTo;
    }

    public Location getFrom(){return this.from;}
    public Location getTo(){return this.to;}

}