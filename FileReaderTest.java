package Workspace;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
//TEST FOR THE FILE READER CLASS
public class FileReaderTest {

    @Test
    public void testReadFromFile() {
        String filePath = "./Workspace/test.txt";

        // get the 2D array of PegGame
        PegGameObject[][] result = FileReader.readFromFile(filePath);

        // makes sure that the text file given is not null
        assertNotNull(result);

        // checks to see whether the amount of rows and columns are equal to each other
        int rows = result.length;
        int cols = result[0].length; // gets length of first row (index 0) because they will all have the same length anyway.
        assertEquals(rows, cols);
    }
}

