package Workspace;

public class Move {

    
    private Location[] from;
    private Location[] to;

    public Move(Location[] mFrom, Location[] mTo)
    {
        this.from = mFrom;
        this.to = mTo;
    }

    public Location[] getFrom(){return this.from;}
    public Location[] getTo(){return this.to;}

}
