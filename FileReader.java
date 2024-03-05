package Workspace;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader {

    public static void main(String[] args) {

        //This is the file path to be reused.
        String filePath = "Workspace\\State";
        String[][] arrayery = readFromFile(filePath);

        // Printing the 2d array using a for loop inside a for loop.
        for (String[] row : arrayery) {
            for (String element : row) {
                System.out.print(element + " ");
            }
            //System.out.println(arrayery[2][2]);
        }


    }


    /**
     * This is the readFromFile method.
     * We use it to automatically open a file, create the array, and use bufferedreader in java.io to read the contents of the 
     * state.txt file, then put it into a 2d array.
     * 
     * @param filePath
     * @return
     */
    public static String[][] readFromFile(String filePath) {
        //Initilizing an empty 2D array, so we use null.
        String[][] array = null;

        //Try and catch statement for code coverage and whatnot.
        //We are using bufferedreader, InputStreamReader, then FileInputStream. 
        //FileInputStream basically takes the bytes from a file, then streamreader converts them,
        //Then they are finally read by the bufferedreader.
        try 
        (BufferedReader bfReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {

            // Incase we want there to be any mods to the general game state or game size, we will initialize the rows and 
            //columns as 0, then we will check for how many rows and columns.
            int rows = 0;
            int columns = 0;
            String line;

            //While loop which breaks when the text file is finished, as in everything is done reading and we reached null.
            while ((line = bfReader.readLine()) != null) {
                //Increment and add, because rows are in y, so each time this runs it means we have a row.
                rows++;

                //Create an array of elements, use regex for whitespace 
                String[] elements = line.split("\\s+"); 
                //If we're at 0 we increase to make sure its not 0
                if (columns == 0) {
                    columns = elements.length;
                    //condition keeps going. Throwing exception to prevent any leak.
                } else if (columns != elements.length);
            }

            // Initialize the actual array to hold.
            array = new String[rows][columns];

            // Reset the reader to start reading from the beginning of the file
            int row = 0;
            bfReader.close();
            //Use same method as before.        
            try (BufferedReader newBfReader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))) {
                // Populate the array with our values, and we use regex for split.
                while ((line = newBfReader.readLine()) != null) {
                    String[] elements = line.split("\\s+");
                    array[row++] = elements;
                }
                newBfReader.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File has not been found");
        } catch (IOException e) {
            System.out.println("There was an issue opening the file.");
        }

        return array;
    }
}
