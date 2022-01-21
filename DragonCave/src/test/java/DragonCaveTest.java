import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DragonCaveTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void main() {
    }

    @Test
    void prompt() {
        assertEquals("""
                You are in a land full of dragons. In front of you,
                you see two caves. In one cave, the dragon is friendly
                and will share his treasure with you. The other dragon
                is greedy and hungry and will eat you on sight.
                Which cave will you go into? (1 or 2):\s""", DragonCave.prompt(), "Test For prompt() Failed");
    }

    @Test
    void input() {

    }

    @Test
    void badDecision() {
        assertEquals("""
                You approach the cave...
                It is dark and spooky...
                A large dragon jumps out in front of you! He opens his jaws and...
                Gobbles you down in one bite!""", DragonCave.badDecision(), "Test For badDecision() Failed");
    }

    @Test
    void goodDecision() {
        assertEquals("""
                You approach the cave...
                You see bright dancing lanterns, and it smells wonderful...
                A large dragon jumps out in front of you! He makes you a business proposition...
                You develop his app and now you are both rich!""", DragonCave.goodDecision(),
                "Test For goodDecision() Failed");
    }

    @AfterEach
    void tearDown() {
    }

}