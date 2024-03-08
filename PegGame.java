package peggame;

import java.util.ArrayList;


/**
 * This is the PegGame interface which we will implement in order to intiliaze our game. 
 */
public interface PegGame {

    CurrentGameState GameStatery = CurrentGameState.NOT_STARTED; 
    
    //This is supposed to return an array of possible moves that can be applied.
    public ArrayList<String> getPossibleMoves(int row, int column);

    //This will return the current game state.
    public CurrentGameState getGameState();

    //This will essentially allow the user to make a move from one position to another.
    public int makeMove(String[] parsedMoves);

    public String[] moveParse(String CLILine);

    public void printGameState();

    public CurrentGameState setCurrentGameState(CurrentGameState inProgress);




}
