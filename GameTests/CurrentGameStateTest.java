package Workspace.GameTests;

import org.junit.jupiter.api.Test;
import Workspace.CurrentGameState;
import static org.junit.jupiter.api.Assertions.*;

public class CurrentGameStateTest {

    @Test
    public void testInitialState() {//tests to see if the NOT_STARTED game state is correct
        assertEquals(CurrentGameState.NOT_STARTED, CurrentGameState.NOT_STARTED);
    }

    @Test
    public void testInProgressState() {//tests to see if the IN_PROGRESS game state is correct
        assertEquals(CurrentGameState.IN_PROGRESS, CurrentGameState.IN_PROGRESS);
    }

    @Test
    public void testStalemateState() {//tests to see if the STALEMATE game state is correct
        assertEquals(CurrentGameState.STALEMATE, CurrentGameState.STALEMATE);
    }

    @Test
    public void testWonState() {//tests to see if the WON game state is correct
        assertEquals(CurrentGameState.WON, CurrentGameState.WON);
    }

}
