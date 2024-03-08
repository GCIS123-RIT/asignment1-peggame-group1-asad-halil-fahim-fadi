import org.junit.Test;
import static org.junit.Assert.assertEquals;
//TEST FOR PEG GAME OBJECT CLASS
public class PegGameObjectTest {

    @Test
    public void testRowAndColumnInitialization() {
        // Create an instance of a class that implements PegGameObject

        assertEquals(0, PegGameObject.row);
        assertEquals(0, PegGameObject.column);
    }

}