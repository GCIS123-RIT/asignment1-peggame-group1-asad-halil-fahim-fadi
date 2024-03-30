package Workspace.GameObjects;

/*
 * This is a Peg object which implements an interface.
 * Everything is defined and ready, and a toString() method is done as well.
 */
public class Peg implements PegGameObject
{
    Boolean EmptyorNot = false;

    int row = 0;
    int column = 0;

    public Peg(int mRow, int mColumn)
    {
        this.row = mRow;
        this.column = mColumn;
    }

    public int getRow(){return this.row;}
    public int getCol(){return this.column;}


    @Override
    public String toString()
    {
        return "o";
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
