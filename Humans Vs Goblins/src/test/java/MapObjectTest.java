import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class MapObjectTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getXPosition() {
        MapObject test1 = new MapObject("test1", 23, 0);
        assertEquals(23, test1.getXPosition(), "The position is not correct");
    }

    @Test
    void getYPosition() {
        MapObject test2 = new MapObject("test2", 0, 7);
        assertEquals(7, test2.getYPosition(), "The position is not correct");
    }

    @Test
    void getStrength() {
        MapObject test3 = new MapObject("test3", 0, 0, 25, 0);
        assertEquals(25, test3.getStrength(), "The strength value is not correct");
    }

    @Test
    void getHealth() {
        MapObject test4 = new MapObject("test4", 0, 0, 0, 25);
        assertEquals(25, test4.getHealth(), "The health value is not correct");
    }

    @Test
    void collisionDetection() {
        MapObject test5 = new MapObject("test5", 1, 5);
        MapObject test6 = new MapObject("test6", 3, 5);
        assertEquals(true, test5.collisionDetection(test5, test6), "Collision Detection Failed");
    }

    @Test
    void testToString() {
        MapObject test7 = new MapObject("John Doe", 15, 7, 25, 25);
        test7.symbol = '♥';
        assertEquals("♥ |Name: John Doe | Position: (15,7) | Health: 25 | Strength: 25|", test7.toString(),
                "The objects information did not print correctly");
    }
}