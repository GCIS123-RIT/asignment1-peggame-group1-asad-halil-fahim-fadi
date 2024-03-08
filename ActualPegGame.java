package Workspace;

import java.util.Scanner;

import Workspace.Functions.Location;
import Workspace.GameObjects.PegGameObject;

import java.util.ArrayList;

public class ActualPegGame implements PegGame {
    CurrentGameState GameStatery = CurrentGameState.NOT_STARTED;
    public static void main(String[] args)
    {

    }


    @Override
    public CurrentGameState getGameState() {
        return null;
    }
    @Override
    public Location makeMove(Location firstPos, Location secondPos) {
        return null;
    }


    public static PegGameObject[][] printGame(PegGameObject[][] theArray)
    {
        System.out.println("This is the actual game being printed.");
        for (int i = 0; i < theArray.length; i++) 
        {
            for (int j = 0; j < theArray[i].length; j++) 
            {
                System.out.print(theArray[i][j] + " ");
            }
            System.out.println(); // Move to the next line after printing each row
        }

        return theArray;
    }

    


    @Override
    public ArrayList<String> getPossibleMoves(int row, int column, PegGameObject[][] gameWeAreCheckingForMoves) 
    {

        return null;
    }


    @Override
    public int makeMove(String[] parsedMoves, PegGameObject[][] gameWeAreCheckingForMoves) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'makeMove'");
    }


    @Override
    public String[] moveParse(String CLILine) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moveParse'");
    }
}

