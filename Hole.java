package Workspace;


/*
 * This is a hole object, signifying an empty space.
 * It implements the PegGameObject, and everything is defined and locked to go.
 * toString() methodi s defined.
 */
public class Hole implements PegGameObject
{
    Boolean EmptyorNot = false;

    int row = 0;
    int column = 0;
    int ReferenceNumber = 1;

    public Hole(int mRow, int mColumn, int RefNumb)
    {
        this.row = mRow;
        this.column = mColumn;

        this.ReferenceNumber = RefNumb;
    }


    @Override
    public String toString()
    {
        return "-";
    }
}
