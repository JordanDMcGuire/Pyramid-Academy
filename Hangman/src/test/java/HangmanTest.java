
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

class HangmanTest {


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void wordMap() {
        String a = Hangman.wordSelect(1);
        String b = "-".repeat(a.length());
        Hangman.word = Hangman.wordSelect(1);
        ArrayList<Character> testIt = new ArrayList<>();
        assertEquals(Hangman.wordMap(testIt), b, "The wordMap is not function correctly");
    }

    /*
        This getNumber test will only work with the original wordlist made by me (Jordan McGuire)
        for this game. if a different wordlist is used, the seed in the assertion must be
        changed for the appropriate expected value in the new wordlist.
     */
    @Test
    void wordSelect() {
        assertEquals("fun", Hangman.wordSelect(1), "Something went wrong with word selection");
    }

    @Test
    void getGuess() {
        Hangman.userGuess = "c";
        assertEquals("c", Hangman.userGuess, "Something went wrong while getting the guess");
    }

}