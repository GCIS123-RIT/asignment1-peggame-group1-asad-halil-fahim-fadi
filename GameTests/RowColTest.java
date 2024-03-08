package Workspace.GameTests;

import org.junit.Test;

import Workspace.GameObjects.Peg;

import static org.junit.Assert.assertEquals;
//TEST FOR THE PEG CLASS
public class RowColTest {

    @Test // creates a test to see whether the getRow() method returns the correct Row
    public void testGetRow() {
        Peg peg = new Peg(2, 3, 1); 
        assertEquals(2, peg.getRow());// tests that 2 and the row number (also 2) are equal
    }

    @Test // creates a test to see whether the getCol() method returns the correct column
    public void testGetCol() {
        Peg peg = new Peg(2, 3, 1); 
        assertEquals(3, peg.getCol());// tests that 3 and the column number (also 3) are equal
    }
}
