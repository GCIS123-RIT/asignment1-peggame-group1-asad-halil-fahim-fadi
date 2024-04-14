import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
//class to create the peg node
public class Peg extends Circle {
    public Peg(double centerX, double centerY, double radius) {//parameters for the x and y coordinates as well as the size of the peg
        super(centerX, centerY, radius);
        setFill(Color.WHITESMOKE); // Set the color of the peg to white
    }
}
