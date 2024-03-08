// package Workspace;


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




// private void checkdirection(List<Move> moves, int r1, int c1, int verticaloffset, int horizontaloffset)
// { 
//     int targetrow = r1 + verticaloffset;
//     int targetcol = c1 + horizontaloffset;
//     int overRow = r1 + verticaloffset / 2;
//     int overCol = c1 + horizontaloffset / 2;

//     if(targetrow >= 0 && targetrow<game.length && targetcol >= 0 && targetcol < game[0].length &&
//      game[targetrow][targetcol] == '.' && board[overRow][overCol]=='o')
//      {
//         moves.add(new Move(new Location(r1,c1), new Location(targetrow,targetcol)));
//      }
// }




