package Workspace;

/*
 * This is a Peg object which implements an interface.
 * Everything is defined and ready, and a toString() method is done as well.
 */
public class Peg implements PegGameObject
{
    Boolean EmptyorNot = false;

    int row = 0;
    int column = 0;
    int ReferenceNumber = 1;

    public Peg(int mRow, int mColumn, int RefNumb)
    {
        this.row = mRow;
        this.column = mColumn;

        this.ReferenceNumber = RefNumb;
    }

    public int getRow(){return this.row;}
    public int getCol(){return this.column;}


    @Override
    public String toString()
    {
        return "o";
    }
}
