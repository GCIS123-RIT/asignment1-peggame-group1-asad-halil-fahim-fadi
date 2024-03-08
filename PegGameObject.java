package Workspace;

/**
 * This is the PegGameObject, meaning an object in the peg game.
 * This is an interface so we can take advantage of polymorphism in our implementation of the game.
 * It contains certain default values.
 */
public interface PegGameObject
        {
            //This part here lets us determine if an object is empty or not, good for distinction.
            public Boolean EmptyorNot = null;
            
            //This is very important, helps to determine the board location of an object.
            public int row = 0;
            public int column = 0;

            public boolean isEmpty();
    
        }
