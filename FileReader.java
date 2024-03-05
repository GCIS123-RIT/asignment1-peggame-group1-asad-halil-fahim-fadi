package Workspace;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class FileReader {

    public static void main(String[] args) {

        //This is the file path to be reused.

        String[][] myArrayery = readFromFile("Workspace/State");
        
        for (int i = 0; i < myArrayery.length; i++) {
            for (int j = 0; j < myArrayery[i].length; j++) {
                System.out.print(myArrayery[i][j] + " ");
            }
            System.out.println(); // Move to the next line after printing each row
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
        //2D ARRAY 4 BY 4
        String[][] TwoDeeArray = new String[4][4];


        try 
        {
            //Try and catch statement for code coverage and whatnot.
            //We are using bufferedreader, InputStreamReader, then FileInputStream. 
            //FileInputStream basically takes the bytes from a file, then streamreader converts them,
            //Then they are finally read by the bufferedreader.
            FileInputStream theInputStream = new FileInputStream(filePath);
            InputStreamReader readerStream = new InputStreamReader(theInputStream);
            BufferedReader bfReader = new BufferedReader(readerStream);

            
            //int rows = 0;
            //int columns = 0;
            //String line;
            String line;
            int row = 0; // Track the current row index in TwoDeeArray


            //Gangsterly Reading the file, we have to use a WHILE LOP with FOR LOOP inside of it.
            //Smart, I know.
            while ((line = bfReader.readLine()) != null) {
            String[] lineIN = line.trim().split("");
            if (lineIN.length <= TwoDeeArray[0].length) {
                //READING LINE BY LINE, LESS LENGHT, INCREMENT.
                for (int j = 0; j < lineIN.length; j++) 
                {
                    TwoDeeArray[row][j] = lineIN[j];
                }
                row++;
            }       
        else
        {
            System.err.println("Error: Line length exceeds column count.");
        }
}
            bfReader.close();
        
        //CODE COVERAGE.
        //TODO Halil prep for junit tests
        } catch (FileNotFoundException e) {
            System.out.println("File has not been found");
        } catch (IOException e) {
            System.out.println("There was an issue opening the file.");
        }

        return TwoDeeArray;
    }
}
