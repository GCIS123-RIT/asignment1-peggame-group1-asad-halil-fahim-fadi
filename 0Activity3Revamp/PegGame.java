import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A class representing the Peg Game application.
 */
public class PegGame extends Application {
//all the things that need to be initialized (i cant explain how many times my code wasnt working just to realize that one of these was missing.)
    private static final int PEG_SIZE = 20;
    private Circle selectedPeg = null;
    private Circle selectedHole = null;
    private Pane root;
    private Text gameStateText;
    private String boardFile;

    /**
     * Constructor to initialize the PegGame with a board file.
     * @param boardFile The name of the file containing the board size.
     */
    public PegGame(String boardFile) {
        this.boardFile = boardFile;
    }

    @Override
    public void start(Stage stage) {
        StackPane board = new StackPane();

        List<String> lines = readBoardFromFile(boardFile); //the text file of the selected board will be passed here when selected in the game

        int cellSize = 90;
        int boardSize = lines.size() * cellSize;
        Rectangle box = new Rectangle(boardSize, boardSize, Color.BURLYWOOD);
        box.setStroke(Color.BLACK);
        box.setStrokeWidth(2);
        //all weird calculations for getting the board and pegs centered in the right position. 
        int screenWidth = (int) Screen.getPrimary().getBounds().getWidth();
        int screenHeight = (int) Screen.getPrimary().getBounds().getHeight();

        int centerX = screenWidth / 2;
        int centerY = screenHeight / 2;

        int boardOffsetX = boardSize / 2;
        int boardOffsetY = boardSize / 2;

        root = new Pane();
        //printing the board based off of the selected text file.
        int size = lines.size();
        for (int row = 0; row < size; row++) {
            String rowString = lines.get(row);
            for (int col = 0; col < size; col++) {
                char cell = rowString.charAt(col);
                double x = centerX - boardOffsetX + col * cellSize + 46;
                double y = centerY - boardOffsetY / 2 + row * cellSize + 30;

                if (cell == 'o') {
                    Peg peg = new Peg(x, y - 250, PEG_SIZE);
                    peg.setOnMouseClicked(event -> handlePegClick(peg));
                    root.getChildren().add(peg);
                } else if (cell == '-') {
                    Hole hole = new Hole(x, y - 250, PEG_SIZE);
                    hole.setOnMouseClicked(event -> handleHoleClick(hole));
                    root.getChildren().add(hole);
                }
            }
        }

        board.getChildren().addAll(box, root);
        //buttons to save the game so that the user can come back to it later.
        Menu fileMenu = new Menu("File");
        MenuItem saveItem = new MenuItem("Save Game");
        MenuItem loadItem = new MenuItem("Load Game");
        //the state of the game is saved in a separate text file called "save.txt", then when you want to laod the game again, the program will get it from the save.txt
        saveItem.setOnAction(e -> saveGameState("save.txt"));
        loadItem.setOnAction(e -> loadGameState("save.txt"));

        fileMenu.getItems().addAll(saveItem, loadItem);

        MenuBar menuBar = new MenuBar(fileMenu);
        VBox mainVBox = new VBox();
        mainVBox.getChildren().addAll(menuBar, board);

        Button quitButton = new Button("Quit");
        quitButton.setOnAction(e -> Platform.exit());
        mainVBox.getChildren().add(quitButton);
        //shows the state of the game while the person is playing
        gameStateText = new Text("Game: being played");
        gameStateText.setFont(Font.font("verdana", FontWeight.BOLD, 16));
        VBox.setMargin(gameStateText, new Insets(10, 10, 10, 10));
        mainVBox.getChildren().add(gameStateText);

        Scene scene = new Scene(mainVBox, 300, 300);
        stage.setScene(scene);
        stage.setTitle("Peg Game!");
        stage.setMaximized(true);
        stage.show();
    }

    /**
     * Reads the board size from a file.
     * @param fileName The name of the file containing the board size.
     * @return A list of strings representing the board size.
     */
    private List<String> readBoardFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    /**
     * Handles the click event on a peg.
     * @param peg The peg that was clicked.
     */
    private void handlePegClick(Peg peg) {
        if (selectedPeg != null) {
            selectedPeg.setFill(Color.WHITESMOKE);
        }
        selectedPeg = peg;
        selectedPeg.setFill(Color.LIME);//peg turns lime green when clicked (again, idk why were sticking with the green colors honoestly...)
    }

    /**
     * Handles the click event on a hole.
     * @param hole The hole that was clicked.
     */
    private void handleHoleClick(Hole hole) {
        if (selectedPeg != null) {
            selectedHole = hole;
            swapPegAndHole(selectedPeg, selectedHole);
            selectedPeg = null;
            selectedHole = null;
        }
    }

    /**
     * Swaps a peg with a hole.
     * @param peg The peg to be swapped.
     * @param hole The hole to be swapped.
     */
    private void swapPegAndHole(Circle peg, Circle hole) {//this method swaps the peg and the hole when a valid move occurs, also deletes the middle peg because thats how the game works obviously
        double pegX = peg.getCenterX();
        double pegY = peg.getCenterY();
        double holeX = hole.getCenterX();
        double holeY = hole.getCenterY();

        double midX = (pegX + holeX) / 2;
        double midY = (pegY + holeY) / 2;

        boolean hasPegAtMidpoint = false;
        Circle pegAtMidpoint = null;
        for (Node node : root.getChildren()) {
            if (node instanceof Peg) {
                Peg p = (Peg) node;
                if (p.getCenterX() == midX && p.getCenterY() == midY) {
                    hasPegAtMidpoint = true;
                    pegAtMidpoint = p;
                    break;
                }
            }
        }

        if (hasPegAtMidpoint) {
            Peg newPeg = new Peg(holeX, holeY, PEG_SIZE);
            newPeg.setOnMouseClicked(event -> {
                if (selectedPeg != null) {
                    selectedPeg.setFill(Color.WHITESMOKE);
                }
                selectedPeg = newPeg;
                selectedPeg.setFill(Color.LIME);
            });

            if (selectedPeg == newPeg) {
                selectedPeg.setFill(Color.RED);
                newPeg.setFill(Color.RED);
                PauseTransition pause = new PauseTransition(Duration.seconds(0.4));
                pause.setOnFinished(e -> {
                    selectedPeg.setFill(Color.WHITESMOKE);
                    newPeg.setFill(Color.WHITESMOKE);
                });
                pause.play();
            } else {
                Hole newHole = new Hole(pegX, pegY, 20);
                newHole.setOnMouseClicked(event -> {
                    if (selectedPeg != null) {
                        selectedHole = newHole;
                        swapPegAndHole(selectedPeg, selectedHole);
                        selectedPeg = null;
                        selectedHole = null;
                    }
                });

                Hole newMidHole = new Hole(midX, midY, 20);
                newMidHole.setOnMouseClicked(event -> {
                    if (selectedPeg != null) {
                        selectedHole = newMidHole;
                        swapPegAndHole(selectedPeg, selectedHole);
                        selectedPeg = null;
                        selectedHole = null;
                    }
                });

                root.getChildren().remove(pegAtMidpoint);
                root.getChildren().add(newMidHole);

                root.getChildren().remove(peg);
                root.getChildren().remove(hole);
                root.getChildren().add(newPeg);
                root.getChildren().add(newHole);

                if (root.getChildren().stream().filter(node -> node instanceof Peg).count() == 1) {
                    showWinScreen();
                }
            }
        } else {//prints "ILLEGAL MOVE" to show that the move played, is in fact illegal, the message pops up for 1 second then goes away
            Text illegalMoveText = new Text("Illegal Move!");
            illegalMoveText.setFont(Font.font("verdana", FontWeight.BOLD, 20));
            root.getChildren().add(illegalMoveText);

            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(e -> root.getChildren().remove(illegalMoveText));
            pause.play();
        }
        checkForStalemate();
    }

    /**
     * Saves the current game state to a file.
     * @param fileName The name of the file to save the game state to.
     */
    private void saveGameState(String fileName) {//saves the state of the game
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Node node : root.getChildren()) {
                if (node instanceof Peg) {
                    Peg peg = (Peg) node;
                    writer.write("Peg " + peg.getCenterX() + " " + peg.getCenterY() + "\n");
                } else if (node instanceof Hole) {
                    Hole hole = (Hole) node;
                    writer.write("Hole " + hole.getCenterX() + " " + hole.getCenterY() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Loads a game state from a file.
     * @param fileName The name of the file to load the game state from.
     */
    private void loadGameState(String fileName) {//loads back the saved state of the game
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            root.getChildren().clear();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    double x = Double.parseDouble(parts[1]);
                    double y = Double.parseDouble(parts[2]);
                    if (parts[0].equals("Peg")) {
                        Peg peg = new Peg(x, y, PEG_SIZE);
                        addPegEventHandlers(peg);
                        root.getChildren().add(peg);
                    } else if (parts[0].equals("Hole")) {
                        Hole hole = new Hole(x, y, PEG_SIZE);
                        addHoleEventHandlers(hole);
                        root.getChildren().add(hole);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Adds event handlers to a peg.
     * @param peg The peg to add event handlers to.
     */
    private void addPegEventHandlers(Peg peg) {
        peg.setOnMouseClicked(event -> {
            if (selectedPeg != null) {
                selectedPeg.setFill(Color.WHITESMOKE);
            }
            selectedPeg = peg;
            selectedPeg.setFill(Color.LIME);
        });
    }

    /**
     * Adds event handlers to a hole.
     * @param hole The hole to add event handlers to.
     */
    private void addHoleEventHandlers(Hole hole) {
        hole.setOnMouseClicked(event -> {
            if (selectedPeg != null) {
                selectedHole = hole;
                swapPegAndHole(selectedPeg, selectedHole);
                selectedPeg = null;
                selectedHole = null;
            }
        });
    }

    /**
     * Checks for a stalemate in the game.
     */
    private void checkForStalemate() {
        boolean hasHoles = false;
        for (Node node : root.getChildren()) {
            if (node instanceof Hole) {
                hasHoles = true;
                break;
            }
        }
        if (!hasHoles) {
            Platform.runLater(() -> gameStateText.setText("Game: Stalemate"));//when a stalemate happens, this message will pop up on the screen
        }
    }

    /**
     * Shows the win screen.
     */
    private void showWinScreen() {//method to pop up a message saying that the user won if there is only 1 peg left on the board (which means the user won, obviously)
        StackPane root = new StackPane();
        Rectangle background = new Rectangle(980, 720, Color.LIGHTGREEN);
        root.getChildren().add(background);

        Text winText = new Text("Congratulations, You Won!");
        winText.setFont(Font.font("verdana", FontWeight.BOLD, 60));

        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(winText);
        vbox.setAlignment(Pos.CENTER);
        root.getChildren().add(vbox);

        Scene winScene = new Scene(root, 980, 620);
        Stage winStage = new Stage();
        winStage.setScene(winScene);
        winStage.setTitle("You Won!");
        winStage.show();
    }

    public static void main(String[] args) {//finally finished lol
        launch(args);
    }
}
