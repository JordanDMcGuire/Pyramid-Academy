import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class MapTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void buildMap() {

        Map map1 = new Map();
        Human testHuman = new Human("Test Human", 23, 7);
        Goblin testGoblin = new Goblin("Test Goblin", 7, 2);

        assertEquals("""
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                | | | | | | | | | | | | | | | |\s
                | | | | | | | | | | | | | | | |\s
                | | | |X| | | | | | | | | | | |\s
                | | | | | | | | | | | | | | | |\s
                | | | | | | | | | | | | | | | |\s
                | | | | | | | | | | | | | | | |\s
                | | | | | | | | | | | | | | | |\s
                | | | | | | | | | | | |♥| | | |\s
                | | | | | | | | | | | | | | | |\s
                | | | | | | | | | | | | | | | |\s
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~""", map1.buildMap(testHuman, testGoblin),
                "The map was not printed correctly");

    }

    @Test
    void testToString() {

        Map map2 = new Map();

        assertEquals("""
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                | | | | | | | | | | | | | | | |\s
                | | | | | | | | | | | | | | | |\s
                | | | |X| | | | | | | | | | | |\s
                | | | | | | | | | | | | | | | |\s
                | | | | | | | | | | | | | | | |\s
                | | | | | | | | | | | | | | | |\s
                | | | | | | | | | | | | | | | |\s
                | | | | | | | | | | | |♥| | | |\s
                | | | | | | | | | | | | | | | |\s
                | | | | | | | | | | | | | | | |\s
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                ♥ = Human | X = Goblin""", map2.toString(), "The map was not printed correctly");

    }
}