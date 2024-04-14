import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

//class for creating the hole node
public class Hole extends Circle {
    public Hole(double centerX, double centerY, double radius) {//parameters for the x and y coordinates as well as the size of the hole
        super(centerX, centerY, radius);
        setFill(Color.BLACK); // Set the initial color of the hole
        setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setFill(Color.DIMGRAY); //turns the hole light grey if pressed, to indicate that you cannot move the hole without the peg first.

                PauseTransition pause = new PauseTransition(javafx.util.Duration.seconds(0.4));
                pause.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        setFill(Color.BLACK); //Change the color back to black after clicking the hole and it turning grey
                    }
                });
                pause.play();
            }
        });
    }
}


