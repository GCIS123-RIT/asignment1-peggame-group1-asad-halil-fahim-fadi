package Workspace;

import java.util.ArrayList;

import Workspace.Functions.Location;
import Workspace.GameObjects.PegGameObject;


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
    public static void main(String[] args)
    {
        

    }



    public static void printGameState(PegGameObject[][] gameState) {
        // Print the game state in a formatted manner
        for (int i = 0; i < gameState.length; i++) 
        {
            for (int j = 0; j < gameState[i].length; j++) 
            {
                System.out.print(gameState[i][j] + " ");
            }
            System.out.println(); // Move to the next line after printing each row
        }
    }

  
//ALERT please keep in mind theres an input issue, it takes input as ROW,COLUMN but gives you result as COLUMN,ROW.
@Override
public ArrayList<String> getPossibleMoves(int column, int row, PegGameObject[][] gameWeAreCheckingForMoves)  
{
    // Initializing Array
    ArrayList<String> possibleMoves = new ArrayList<>(6);
    try
    {
        // Checking column+2, row-2
        if(column < gameWeAreCheckingForMoves[row].length - 2 && row >= 2 && gameWeAreCheckingForMoves[row - 2][column + 2].isEmpty())
        {
            String toRow = String.valueOf(row - 2);
            String toCol = String.valueOf(column + 2);
            String encapsulatedMoves = toRow + toCol;
            possibleMoves.add(encapsulatedMoves);
        }
        // Checking column, row-2
        if(row >= 2 && gameWeAreCheckingForMoves[row - 2][column].isEmpty())
        {
            String toRow = String.valueOf(row - 2);
            String toCol = String.valueOf(column);
            String encapsulatedMoves = toRow + toCol;
            possibleMoves.add(encapsulatedMoves);
        }
        // Checking column-2, row-2
        if(column >= 2 && row >= 2 && gameWeAreCheckingForMoves[row - 2][column - 2].isEmpty())
        {
            String toRow = String.valueOf(row - 2);
            String toCol = String.valueOf(column - 2);
            String encapsulatedMoves = toRow + toCol;
            possibleMoves.add(encapsulatedMoves);
        }
        // Checking column+2, row
        if(column < gameWeAreCheckingForMoves[row].length - 2 && gameWeAreCheckingForMoves[row][column + 2].isEmpty())
        {
            String toRow = String.valueOf(row);
            String toCol = String.valueOf(column + 2);
            String encapsulatedMoves = toRow + toCol;
            possibleMoves.add(encapsulatedMoves);
        }
        // Checking column-2, row
        if(column >= 2 && gameWeAreCheckingForMoves[row][column - 2].isEmpty())
        {
            String toRow = String.valueOf(row);
            String toCol = String.valueOf(column - 2);
            String encapsulatedMoves = toRow + toCol;
            possibleMoves.add(encapsulatedMoves);
        }
        // Checking column, row+2
        if(row < gameWeAreCheckingForMoves.length - 2 && gameWeAreCheckingForMoves[row + 2][column].isEmpty())
        {
            String toRow = String.valueOf(row + 2);
            String toCol = String.valueOf(column);
            String encapsulatedMoves = toRow + toCol;
            possibleMoves.add(encapsulatedMoves);
        }
        // Checking column+2, row+2
        if(column < gameWeAreCheckingForMoves[row].length - 2 && row < gameWeAreCheckingForMoves.length - 2 && gameWeAreCheckingForMoves[row + 2][column + 2].isEmpty())
        {
            String toRow = String.valueOf(row + 2);
            String toCol = String.valueOf(column + 2);
            String encapsulatedMoves = toRow + toCol;
            possibleMoves.add(encapsulatedMoves);
        }
        // Checking column-2, row+2
        if(column >= 2 && row < gameWeAreCheckingForMoves.length - 2 && gameWeAreCheckingForMoves[row + 2][column - 2].isEmpty())
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
    public Location makeMove(Location firstPos, Location secondPos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeMove'");
    }

    @Override
    public int makeMove(String[] parsedMoves, PegGameObject[][] gameWeAreCheckingForMoves) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeMove'");
    }

    @Override
    public CurrentGameState getGameState() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getGameState'");
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


    

}


