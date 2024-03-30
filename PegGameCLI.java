package Workspace;

import java.util.Objects;
import java.util.Scanner;


/**
 * This is the PegGame Command Line Interface, this is where the user input is taken, and output is communicated.
 * As seen, we are using some fancy colors in order to make everything look even better.
 * 
 * It starts by prompting the user, then going into a while loop as long as the game is enabled. 
 */
public class PegGameCLI {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";

    public static void playPEGGAME(PegGame game) {

        Scanner gameScanner = new Scanner(System.in);

        System.out.println("Welcome to The Peg Game!");

        while (game.getGameState() == CurrentGameState.IN_PROGRESS) {

            System.out.println("\nPlease enter your move (Example: move r1 c2 r4 c2, or type 'q' to quit):");
            game.printGameState();

            String input = gameScanner.nextLine();

            //This if is incase the user wants to quit. It thanks for playing, then sets to Stalemate.
            if (input.equals("q")) {
                System.out.println("\nThank you for playing!");
                game.setCurrentGameState(CurrentGameState.STALEMATE);
                break;

            } 
            //This else is for anything else.
            else {
                //Firstly, we parse the move into an array so our other method scan use it.
                String[] parsedMove = game.moveParse(input);

                //We put in try catch block, and begin the other operations.
                try {

                    //We check the move results, this uses a getpossiblemoves inside of it.
                    int moveResult = game.makeMove(parsedMove);

                    //Checking result of move, if valid green will be printed. If not.. well not.
                    if (moveResult == 1) {
                        System.out.println(ANSI_GREEN + "Valid Move! Well done." + ANSI_RESET);
                        game.printGameState();
                    } 
                    else {
                        System.out.println(ANSI_RED+"Move was not valid or not possible.\n"+ANSI_RESET);
                    }
                    //Catching any errors, in case of wrong input.
                } catch (NumberFormatException nfe) {
                    System.out.println("Invalid input format. Please enter in the correct format.");
                }
            }
        }

        gameScanner.close();

        System.out.println("\nGame over!\n");

        // Printing game's feedback
        if (game.getGameState() == CurrentGameState.WON) {
            System.out.println("Hooray!");
        } else {
            System.out.println("You lost. Better luck next time!");
        }
    }

    public void setCurrentGameState(CurrentGameState stalemate) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCurrentGameState'");
    }

    public String[] moveParse(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'moveParse'");
    }

     @Override
    public int hashCode() {
        return Objects.hash(ANSI_RESET, ANSI_GREEN, ANSI_RED);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PegGameCLI other = (PegGameCLI) obj;
        return Objects.equals(ANSI_RESET, other.ANSI_RESET)
                && Objects.equals(ANSI_GREEN, other.ANSI_GREEN)
                && Objects.equals(ANSI_RED, other.ANSI_RED);
    }
    @Override
    public String toString() {
    return "PegGameCLI{" +
            "ANSI_RESET='" + ANSI_RESET + '\'' +
            ", ANSI_GREEN='" + ANSI_GREEN + '\'' +
            ", ANSI_RED='" + ANSI_RED + '\'' +
            '}';
}

}
