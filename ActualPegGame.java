package Workspace;

import java.util.ArrayList;

import Workspace.GameObjects.*;


/*
 * 1. row-2, column
 * 2. row-2, column-2
 * 3. r+2, column
 * 4. r+2, c+2
1. Read User Input
2. GetPossibleMoves + if else statements
3. (If illegal) throw Exception
4. (If legal) Pass the move and repeat the process until game end/process killed

Idea: Clear Algorithm after every user input as a move
 */

public class ActualPegGame implements PegGame {
    CurrentGameState GameStatery = CurrentGameState.NOT_STARTED;
    public PegGameObject[][] pegboard;

    public ActualPegGame(PegGameObject[][] boardgame)
    {
        this.GameStatery = CurrentGameState.NOT_STARTED;
        this.pegboard = boardgame;

    }

    public void printGameState() {
        // Print the game state in a formatted manner
        for (int i = 0; i < pegboard.length; i++) 
        {
            for (int j = 0; j < pegboard[i].length; j++) 
            {
                System.out.print(pegboard[i][j] + " ");
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }

//ALERT please keep in mind theres an input issue, it takes input as ROW,COLUMN but gives you result as COLUMN,ROW.
@Override
public ArrayList<String> getPossibleMoves(int column, int row)  
{
    // Initializing Array
    ArrayList<String> possibleMoves = new ArrayList<>(6);
    try
    {
        // Checking column+2, row-2
        if(column < pegboard[row].length - 2 && row >= 2 && pegboard[row - 2][column + 2].isEmpty())
        {
            String toRow = String.valueOf(row - 2);
            String toCol = String.valueOf(column + 2);
            String encapsulatedMoves = toRow + toCol;
            possibleMoves.add(encapsulatedMoves);
        }
        // Checking column, row-2
        if(row >= 2 && pegboard[row - 2][column].isEmpty())
        {
            String toRow = String.valueOf(row - 2);
            String toCol = String.valueOf(column);
            String encapsulatedMoves = toRow + toCol;
            possibleMoves.add(encapsulatedMoves);
        }
        // Checking column-2, row-2
        if(column >= 2 && row >= 2 && pegboard[row - 2][column - 2].isEmpty())
        {
            String toRow = String.valueOf(row - 2);
            String toCol = String.valueOf(column - 2);
            String encapsulatedMoves = toRow + toCol;
            possibleMoves.add(encapsulatedMoves);
        }
        // Checking column+2, row
        if(column < pegboard[row].length - 2 && pegboard[row][column + 2].isEmpty())
        {
            String toRow = String.valueOf(row);
            String toCol = String.valueOf(column + 2);
            String encapsulatedMoves = toRow + toCol;
            possibleMoves.add(encapsulatedMoves);
        }
        // Checking column-2, row
        if(column >= 2 && pegboard[row][column - 2].isEmpty())
        {
            String toRow = String.valueOf(row);
            String toCol = String.valueOf(column - 2);
            String encapsulatedMoves = toRow + toCol;
            possibleMoves.add(encapsulatedMoves);
        }
        // Checking column, row+2
        if(row < pegboard.length - 2 && pegboard[row + 2][column].isEmpty())
        {
            String toRow = String.valueOf(row + 2);
            String toCol = String.valueOf(column);
            String encapsulatedMoves = toRow + toCol;
            possibleMoves.add(encapsulatedMoves);
        }
        // Checking column+2, row+2
        if(column < pegboard[row].length - 2 && row < pegboard.length - 2 && pegboard[row + 2][column + 2].isEmpty())
        {
            String toRow = String.valueOf(row + 2);
            String toCol = String.valueOf(column + 2);
            String encapsulatedMoves = toRow + toCol;
            possibleMoves.add(encapsulatedMoves);
        }
        // Checking column-2, row+2
        if(column >= 2 && row < pegboard.length - 2 && pegboard[row + 2][column - 2].isEmpty())
        {
            String toRow = String.valueOf(row + 2);
            String toCol = String.valueOf(column - 2);
            String encapsulatedMoves = toRow + toCol;
            possibleMoves.add(encapsulatedMoves);
        }

    }
    catch (ArrayIndexOutOfBoundsException e) {
        System.err.println("An array index is out of bounds.");
        e.printStackTrace(); // Print the stack trace for debugging purposes
        return null; // or handle the exception in any other way that suits your application
    }

    return possibleMoves;
}   

    @Override
    public int makeMove(String[] parsedMoves) 
    { 

        String fromRow1 = parsedMoves[1].substring(1); // Removing the 'r' prefix
        String fromColumn1 = parsedMoves[2].substring(1); // Removing the 'c' prefix
        String toRow2 = parsedMoves[3].substring(1); // Removing the 'r' prefix
        String toColumn2 = parsedMoves[4].substring(1); // Removing the 'c' prefix
        
        // Convert strings to integers
        int fromRow = Integer.parseInt(fromRow1);
        int fromColumn = Integer.parseInt(fromColumn1);
        int toRow = Integer.parseInt(toRow2);
        int toColumn = Integer.parseInt(toColumn2);

        ArrayList<String> myPossibleMoves = getPossibleMoves(fromRow,fromColumn);

        // Comparing possible moves to the destination row and column
        if (myPossibleMoves.contains(String.valueOf(toColumn) + String.valueOf(toRow))) {
            // Make the move by updating the game state


            //POLYMORPHISM!!!! 
            pegboard[fromColumn][fromRow] = new Hole(fromRow,fromColumn); // Leaving the from position
            pegboard[toColumn][toRow] = new Peg(toRow,toColumn); // Moving the peg to the to position
    
            // Calculate the position of the peg to remove
            int removeRow = (fromRow + toRow) / 2;
            int removeColumn = (fromColumn + toColumn) / 2;
    
            // Remove the peg in between
            pegboard[removeColumn][removeRow] = (PegGameObject) new Hole(removeColumn,removeColumn); // Replace with a hole
            return 1; // Successful move
        }
        
        return 0; 
    }

    @Override
    public CurrentGameState getGameState() 
    {
        //if one peg remaining, won.
        //if more than one remaining, stalemate.
        //else in progress.    

        return GameStatery;
    }

    public CurrentGameState setCurrentGameState(CurrentGameState state)
    {
        //If there is 0 pegs remaining, win.
        //If there is 1 peg remaining, stalemate.
        //If there is more than 1 remaining, lose.
        return this.GameStatery = state;
    }

    @Override
    public String[] moveParse(String CLILine)
    {

        //move r1 c2 r3 c3
        String input = CLILine;
        
        // Split the input string by spaces
        String[] parts = input.split(" ");

        //GUIDE
        //String fromRow1 = parts[1].substring(1); // Removing the 'r' prefix
        //String fromColumn1 = parts[2].substring(1); // Removing the 'c' prefix
        //String toRow2 = parts[3].substring(1); // Removing the 'r' prefix
        //String toColumn2 = parts[4].substring(1); // Removing the 'c' prefix

        return parts;

    }

    /**
     * Counts objects inside of the actual gameboard, pegboard.
     * @param ObjShape
     * @return
     */
    public int CountObject(String ObjShape)
    {
        int numOfObjs = 0;
        for (int i = 0; i < pegboard.length; i++) 
        {
            for (int j = 0; j < pegboard[i].length; j++) 
            {
                if(pegboard[i][j].equals(ObjShape))
                {
                    numOfObjs=numOfObjs+1;
                }
            }
            System.out.println(); // Move to the next line after printing each row
        }

        return numOfObjs;
    }


    

}


