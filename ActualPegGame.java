//package Workspace;

import java.util.Scanner;
import java.util.ArrayList;


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
        
        System.out.println("   Welcome To The Peg Game ! \n");
        System.out.println("\t Main Menu \t \n");
        System.out.println("1. Press P to play! \n2. Q to Quit!");
        
        //Thank you halil... ^ ^ ^

        Scanner myScanner = new Scanner(System.in);
        String UserPlayOrNo = myScanner.nextLine();
        myScanner.close();



        //Created The Actual 2D Array for the Game.
        if(UserPlayOrNo.equals("P"))
        {
            CurrentGameState GameStatery = CurrentGameState.IN_PROGRESS;

            PegGameObject[][] TheGameRunningRightNow = Workspace.FileReader.readFromFile("./Workspace/State");

            printGame(TheGameRunningRightNow);


            System.out.println("What's your move, Human?\n");

            Scanner scanningHuman = new Scanner(System.in);
            String humanMove = scanningHuman.nextLine();
            scanningHuman.close();


            while(UserPlayOrNo != "Q")
            {
                
            }




        }

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

  
   


    @Override
    public ArrayList<Move> getPossibleMoves() {


        return null;
    }
    @Override
    public CurrentGameState getGameState() {
        return null;
    }
    @Override
    public Location makeMove(Location firstPos, Location secondPos) {
        return null;
    }


    

}


