import oop.blueprints.Tile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class maintest {
    @Test
    public void testConstructor() {
        Tile tile1 = new Tile(false);
        Assertions.assertEquals(false, tile1.isMined(),"no mines");
    }

}