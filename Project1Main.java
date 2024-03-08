package peggame;

import java.util.Scanner;

import peggame.GameObjects.PegGameObject;

/**This class is the runner for the game */
public class Project1Main {


    /**
    * The main method of the program.
    * Prompts the user to enter a filename, reads the peg game from the file,
    * and then starts the command-line interface for playing the peg game.
    * 
    * @param args The command-line arguments (not used in this program).
    */
    public static void main(String[] args) 
    {
        //Firstly, we open a scanner to prompt for file name, then take input.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the filename: ");
        String filename = scanner.nextLine();

        //Try/Catch block in order to prevent any errors during opening or scanner usage.
        try {
            //Creating an actualboard object using our readFromFile method.

            // use ./peggame/TextFiles/file.txt
            PegGameObject[][] actualBoard = FileReader.readFromFile(filename);

            //Creating an actual game, an interface of PegGame. This is where everything actually runs.
            PegGame theActualGameBeingPlayed = new ActualPegGame(actualBoard);

            //Setting the status to in progress, as to allow other components to work.
            theActualGameBeingPlayed.setCurrentGameState(CurrentGameState.IN_PROGRESS);

            //Now we launch the CLI, and begin playing the game.
            PegGameCLI.playPEGGAME(theActualGameBeingPlayed);

        } 
        //In case of any exceptions, we catch :D
        catch (Exception e)
        {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        //Always close scanner.
        scanner.close(); 
    }
    
    //Danilo is quite literally an exquisite professor.
    //Please help us, we finished this exactly at 11:59pm.

}
