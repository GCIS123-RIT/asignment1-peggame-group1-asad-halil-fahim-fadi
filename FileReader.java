package Workspace;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import Workspace.GameObjects.Hole;
import Workspace.GameObjects.Peg;
import Workspace.GameObjects.PegGameObject;

public class FileReader {
    
    //Main function used for tests & runs.
    public static void main(String[] args) {

        //This is the file path to be reused.

    }
    
    

    //Two Dimensional Array being initialized. It is a PegorHole.
     public static PegGameObject[][] TwoDeeArray = new PegGameObject[4][4];

    
    static { // the "static" is used to initialize the 2D array with null elements before starting. 

         for (int i = 0; i < TwoDeeArray.length; i++) {
             for (int j = 0; j < TwoDeeArray[i].length; j++) {
                 TwoDeeArray[i][j] = null; // or any initial value you prefer
             }
         }
     }
     
    /*
     * readFromFile() function is a function that takes a text file, and reads it.
     * It then creates the actual game environment, and it results in a two dimensional array
     * -filled with game objects.
     * 
     * @return PegGameObject[][]
     */
     public static PegGameObject[][] readFromFile(String filePath) {
        //2D ARRAY 4 BY 4
        try 
        {
            //Reading Section of the File. Binary(FileInpStream)-->Chars(InputStrmReader)-->Usable(Bfreader)
            FileInputStream theInputStream = new FileInputStream(filePath);
            InputStreamReader readerStream = new InputStreamReader(theInputStream);
            BufferedReader bfReader = new BufferedReader(readerStream);

            //Initializing some variables used for holding, then row for tracking number of rows.
            String line;
            int row = 0; 

            //Using while loop to read through each line until there are no more lines in text file.
            while ((line = bfReader.readLine()) != null) 
                {
                //We create an Array, that takes the readline then trims it, then splits based on whitespace.
                String[] lineIN = line.trim().split(""); 

                //Condition checks length of read file, to check if it can be put into 2d array. Prevents Errors.
                if (lineIN.length <= TwoDeeArray[0].length) 
                {
                    //A for loop goes through each part of the array.
                    for (int j = 0; j < lineIN.length; j++) 
                    {
                        //Now here are a collection of if statements.
                        //We create the actual game here by putting an object inside of the array.
                    
                        // - - -  Bunch of polymorphism here...

                        //TODO Improve Row/Col Sys + RefNum Sys.

                        //If "o" is detected, then a peg is created.
                        if (lineIN[j].equals("o"))
                        {
                            //Addition of peg at that certain position, peg tracking info is provided.
                            TwoDeeArray[row][j] = new Peg(row,j);
                        }

                        // if "-" is found, then a hole is created.
                        else if(lineIN[j].equals("-"))
                        {
                            //Addition of hole at that position. Info is provided.
                            TwoDeeArray[row][j] = new Hole(row,j);
                        }

                        //If it's a different letter, it will go to this.
                        else
                        {
                            System.out.println("ERROR, NOT DETECTED CHAR");
                        }
                    }
                    //Increment to continue.
                    row++;
                }     
                //Else statement incase of issue between row-column synch.  
                else
                {
                    System.err.println("ROW-COLUMN PROBLEM, REFER.");
                }
                }
                
                //Close reader to prevent any resource leakage.
                bfReader.close();

        } //The various exception handling which are required, file not found and IO exception.
        catch (FileNotFoundException e) {
            System.out.println("File has not been found");
        } catch (IOException e) {
            System.out.println("There was an issue opening the file.");
        }
        //Returnal of the actual 2d array that is passed by and used anywhere else.
        return TwoDeeArray;
    }

     @Override
    public int hashCode() {
        return Arrays.deepHashCode(TwoDeeArray);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FileReader other = (FileReader) obj;
        return Arrays.deepEquals(TwoDeeArray, other.TwoDeeArray);
    }
}

