import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Menu extends Application {

    private Stage scene1; // Stage for the menu

    //sets the main menu's stage
    @Override
    public void start(Stage primaryStage) {
        scene1 = primaryStage;
        showEntranceScreen(); 
    }

    private void showEntranceScreen() {//background size and color(green is non of our favorite colors, idk why we picked it...)
        StackPane root = new StackPane();
        Rectangle background = new Rectangle(980, 720, Color.LIGHTGREEN);
        root.getChildren().add(background);

        Text title = new Text("Welcome to PegGame!");
        title.setFont(Font.font("verdana", FontWeight.BOLD, 60));

        //button to start playing
        Button playButton = new Button("Play Game");
        playButton.setPrefHeight(75);
        playButton.setPrefWidth(175);
        playButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showBoardSizeSelection(); // Shows the screen where you pick the size of the board (3x3, 4x4, 5x5)
            }
        });

        // Button to quit the game (this is for the weak ones who cant play lol)
        Button quitButton = new Button("Quit Game");
        quitButton.setPrefHeight(75);
        quitButton.setPrefWidth(175);
        quitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                scene1.close(); // Closes the main menu stage 
            }
        });

        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(title, playButton, quitButton);
        vbox.setAlignment(Pos.CENTER);
        root.getChildren().add(vbox);

        Scene scene = new Scene(root, 980, 620);
        scene1.setTitle("PegGame!");
        scene1.setScene(scene);
        scene1.show();
    }

    private void showBoardSizeSelection() {
        StackPane root = new StackPane();
        Rectangle background = new Rectangle(980, 720, Color.LIGHTGREEN);
        root.getChildren().add(background);

        // Buttons to select different board sizes
        Button button3x3 = new Button("3x3");
        button3x3.setOnAction(e -> startGame("3x3.txt"));

        Button button4x4 = new Button("4x4");
        button4x4.setOnAction(e -> startGame("4x4.txt"));

        Button button5x5 = new Button("5x5");
        button5x5.setOnAction(e -> startGame("5x5.txt"));

        VBox vbox = new VBox(20);
        vbox.getChildren().addAll(button3x3, button4x4, button5x5);
        vbox.setAlignment(Pos.CENTER);
        root.getChildren().add(vbox);

        Scene scene = new Scene(root, 980, 620);
        scene1.setScene(scene);
        scene1.show();
    }

    private void startGame(String boardFile) {
        Platform.runLater(() -> {
            PegGame game = new PegGame(boardFile); // Creates the game with board size that the user picked
            Stage stage = new Stage();
            try {
                game.start(stage); // Starts the gam
                scene1.close(); // Closes the main menu stage
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }
}
