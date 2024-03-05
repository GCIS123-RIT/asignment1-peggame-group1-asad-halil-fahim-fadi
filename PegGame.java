package Workspace;

import java.util.ArrayList;

/**
 * This is the PegGame interface which we will implement in order to intiliaze our game. 
 */
public interface PegGame {
    
    //This is supposed to return an array of possible moves that can be applied.
    public ArrayList<Move> getPossibleMoves();

    //This will return the current game state.
    public CurrentGameState getGameState();

    //This will essentially allow the user to make a move from one position to another.
    public Move makeMove(Move firstPos, Move secondPos);


}
