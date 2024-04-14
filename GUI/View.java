package Workspace.GUI;

import Workspace.PegGame;
import Workspace.GameObjects.PegGameObject;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/*
 * The View component is used for all the UI logic of the application. 
 * It generates a user interface for the user. 
 * Views are created by the data which is collected by the model component but these data aren’t taken directly ` but through the controller. 
 * It only interacts with the controller.
 */

public class View extends Application{
    //Knowledge Class
    /* 
    @Override
    public void start(Stage myStage) throws Exception {
        /* 
        Label label1 = labelMaker("Hey",Color.RED,Color.BLUE,Pos.CENTER);
        Label label2 = labelMaker("What's up"  , Color.BLUE, Color.RED, Pos.CENTER);
        Label label3 = labelMaker("BLUD!", Color.YELLOW, Color.BLACK, Pos.CENTER);

        //Text field creation
        TextField myTextField = new TextField();
        myTextField.setMaxWidth(Double.MAX_VALUE);
        myTextField.setAlignment(Pos.CENTER);
        
        //Button Creation
        Button myButton = new Button("Welcome!");
        myButton.setMaxWidth(Double.MAX_VALUE);
        myButton.setAlignment(Pos.CENTER);

        //Image creation
        Image myImage = new Image("file:./R.png");
        ImageView theView = new ImageView(myImage);
        theView.setFitWidth(0);
        theView.setFitHeight(0);

        //Audio Creation
        
        String path = "./click.mp3";
        String uri = new File(path).toURI().toString();
        Media media = new Media(uri);
        MediaPlayer player = new MediaPlayer(media);
        
        //player.play();        
        


        //This makes a borderpane!  
        //THINK ABOUT MAKING A HBOX OR VBOX MADE OF PANES O_O  

        BorderPane myPane = new BorderPane(); 

        myPane.setLeft(label1);
        myPane.setCenter(label2);
        myPane.setRight(label3);
        myPane.setBottom(myButton);
        myPane.setTop(myTextField);


        //Creates Horizonal Box and adds stuff to it.
        //KEEP IN MIND WHEN RUNNING IT, YOU HAVE TO ADD IT TO THE SCENE.
        HBox hbox = new HBox();
        hbox.getChildren().addAll(myPane);


        
        //This is essentially adding it to the scene, aka the stuff being shown.
        Scene scene = new Scene(hbox);

        myStage.setTitle("My Stage!");
        myStage.setScene(scene);
        myStage.show();
        */
    


    @Override
    public void start(Stage myStage) throws Exception 
    {
        //Main Menu Labels/Buttons Creation
        Label WelcomeLabel = labelMaker("Welcome to Peg Game!",Color.WHITE,Color.BLUE,Pos.CENTER);
        Button PlayGameButton = buttonMaker("Play", Color.BLACK, Color.WHITE, Pos.CENTER);
        Button SavesButton = buttonMaker("Your Saves", Color.BLACK, Color.WHITE, Pos.CENTER);
        Button ExitButton = buttonMaker("Exit", Color.BLACK, Color.WHITE, Pos.CENTER);

        //VBox
        VBox MainVerticalBoxMenu = new VBox();
        MainVerticalBoxMenu.getChildren().addAll(PlayGameButton,SavesButton,ExitButton);
        MainVerticalBoxMenu.setAlignment(Pos.CENTER);
        MainVerticalBoxMenu.setSpacing(5);


        //Final Vbox Main Menu
        VBox finalMainMenuVBox = new VBox();
        finalMainMenuVBox.getChildren().addAll(WelcomeLabel,MainVerticalBoxMenu);
        finalMainMenuVBox.setAlignment(Pos.CENTER);
        finalMainMenuVBox.setSpacing(10);


        Scene mainMenuScene = new Scene(finalMainMenuVBox);

        myStage.setTitle("peggame.exe");
        myStage.setScene(mainMenuScene);
        myStage.show();
    }
    //Helper Method to make us a Label!    
    public static Label labelMaker(String text, Color foreground, Color background, Pos position)
    {
        Label newLabel = new Label(text);
        
        //Font Setter
        newLabel.setFont(new Font("Times New Roman",40));

        //Setting max sizes.
        newLabel.setMaxHeight(Double.POSITIVE_INFINITY);
        newLabel.setMaxWidth(Double.POSITIVE_INFINITY);

        newLabel.setAlignment(position);

        newLabel.setPadding(new Insets(10));
        newLabel.setTextFill(foreground);
    
        newLabel.setBackground(new Background(new BackgroundFill(background, CornerRadii.EMPTY, Insets.EMPTY)));

        return newLabel;
    }

    public static Button buttonMaker(String text, Color textColor, Color background, Pos position)
    {
        Button newButton = new Button(text);

        newButton.setMaxHeight(50);
        newButton.setMaxWidth(100);

        newButton.setAlignment(position);

        newButton.setPadding(new Insets(10));
        newButton.setTextFill(textColor);

        newButton.setBackground(new Background(new BackgroundFill(background, CornerRadii.EMPTY, Insets.EMPTY)));

        return newButton;
    }
    /*
     * The idea here is to make the GUI allow the player to pick an option
     * From the SYSTEM GUI, EXAMPLE:
     * 
     * ---
     * Welcome!
     * 
     * Play Game
     * Saves
     * Exit
     * ---
     * *Play Game Pressed*
     * ---
     * INITIATE GAME !
     * 
     * Enter Game Size
     * [  ] x [  ]
     * [CREATE !]
     * ---
     * Once create is pressed, a table of that certain size is created.
     * 
     */
    public static void actualGameTableGUICreator()
    {

    }
    public static void main(String[] args)
    {
        //For testing purposes. 
        launch(args);
    }
    
}