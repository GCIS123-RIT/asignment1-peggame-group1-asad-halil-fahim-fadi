package Workspace.GameTests;




import org.junit.jupiter.api.Test;

import Workspace.PegGameCLI;

import static org.junit.jupiter.api.Assertions.*;

public class PegGameCLITest {

    @Test
    public void testMoveParse_BoundaryCases() {
        PegGameCLI pegGameCLI = new PegGameCLI();

        // Test with coordinates at the edges of the board
        assertArrayEquals(new String[]{"r0", "c0", "r0", "c2"}, pegGameCLI.moveParse("move r0 c0 r0 c2"));
        assertArrayEquals(new String[]{"r4", "c0", "r4", "c2"}, pegGameCLI.moveParse("move r4 c0 r4 c2"));
        assertArrayEquals(new String[]{"r2", "c0", "r4", "c0"}, pegGameCLI.moveParse("move r2 c0 r4 c0"));
        assertArrayEquals(new String[]{"r2", "c4", "r4", "c4"}, pegGameCLI.moveParse("move r2 c4 r4 c4"));

        // Test with invalid coordinates
        assertThrows(IllegalArgumentException.class, () -> pegGameCLI.moveParse("move r5 c0 r4 c2")); // Row out of bounds
        assertThrows(IllegalArgumentException.class, () -> pegGameCLI.moveParse("move r0 c5 r4 c2")); // Column out of bounds
        assertThrows(IllegalArgumentException.class, () -> pegGameCLI.moveParse("move r0 c0 r5 c2")); // Row out of bounds
        assertThrows(IllegalArgumentException.class, () -> pegGameCLI.moveParse("move r0 c0 r4 c5")); // Column out of bounds
    }

}
