package Workspace.GameTests;

import org.junit.jupiter.api.Test;

import Workspace.Functions.Location;

import static org.junit.jupiter.api.Assertions.*;

public class LocationTest {

    @Test
    public void testNegativeValues() {
        int row = -1;
        int col = -1;
        Location location = new Location(row, col);

        assertEquals(row, location.getRow());
        assertEquals(col, location.getCol());
    }
}

