import javafx.scene.layout.Pane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.w3c.dom.Node;

/**
 * A class to read a board from a file and create a board layout in a JavaFX Pane based off of the text files.
 */
public class FileReaderGUI {
    private Pane root;
    private static final int PEG_SIZE = 20; // Size of each peg/hole

    /**
     * Constructor to initialize the FileReaderGUI with a Pane.
     * @param root The JavaFX Pane to add pegs and holes to.
     */
    public FileReaderGUI(Pane root) {
        this.root = root;
    }

    /**
     * Reads a board from a file and creates a board layout.
     * @param fileName name of the file containing the board configuration.
     * @param boardSize size of the board.
     */
    public void createBoardFromFile(String fileName, int boardSize) {
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            int row = 0;
            int col = 0;
            // Read each line of the file
            while ((line = bufferedReader.readLine()) != null) {
                for (col = 0; col < line.length(); col++) {
                    char symbol = line.charAt(col);
                    if (symbol == 'o') {
                        //Create a Peg at the calculated position
                        Peg peg = new Peg(0, 0, PEG_SIZE); //Placeholder values, actual position will be calculated later
                        root.getChildren().add(peg);
                    } else if (symbol == '-') {
                        //Create a Hole at the calculated position
                        Hole hole = new Hole(0, 0, PEG_SIZE); //Placeholder values, actual position will be calculated later
                        root.getChildren().add(hole);
                    }
                }
                row++;
            }

            bufferedReader.close();

            //Calculate and set the position of each peg/hole based on the board size and layout
            int size = row;
            for (int i = 0; i < root.getChildren().size(); i++) {
                Node node = (Node) root.getChildren().get(i);
                double x = boardSize / 2 - (size / 2 - i / size) * 90 - PEG_SIZE / 2;
                double y = boardSize / 2 - (size / 2 - i % size) * 90 - PEG_SIZE / 2;
                if (node instanceof Peg) {
                    ((Peg) node).setCenterX(x);
                    ((Peg) node).setCenterY(y);
                } else if (node instanceof Hole) {
                    ((Hole) node).setCenterX(x);
                    ((Hole) node).setCenterY(y);
                }
            }
        } catch (IOException e) {
            //Print the stack trace if an exception occurs
            e.printStackTrace();
        }

        //Set the width and height of the root Pane to match the board size
        root.setPrefWidth(boardSize);
        root.setPrefHeight(boardSize);
    }
}
