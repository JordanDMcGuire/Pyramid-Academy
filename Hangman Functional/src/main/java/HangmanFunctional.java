
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class HangmanFunctional {

    // Global game variable are defined here
    public static String word;
    /*
        An ArrayList will hold the values that the player has guessed correctly in the
        given word.
    */
    static ArrayList<Character> guessAttempts = new ArrayList<>();
    static int numberOfCorrectGuesses = 0;
    static int numberOfIncorrectGuesses = 0;
    static String previousWordMap = "";
    static String currentWordMap = "";
    static String userGuess = "";
    static String playAgain;
    static String[] state = new String[7];

    public static void main(String[] args) throws IOException {

        ArrayList<String> stateLoad = new ArrayList<>
                (Collections.singleton(Files.readString(Path.of("src/main/resources/state.txt"))));

        state = stateLoad.get(0).split(",");



        // all global values are reset and a new game begins.
        initialize();
    }



    private static void initialize() throws IOException {

        // reset globals for each play through.
        word = "";
        guessAttempts.clear();
        numberOfCorrectGuesses = 0;
        numberOfIncorrectGuesses = 0;
        previousWordMap = "";
        currentWordMap = "";
        userGuess = "";
        playAgain = "y";

    /*
        A random seed is created and then passed with an upper bound that will allow
        the wordSelect method to choose any word in the word list. The seed exists
        solely for unit testing assertion purposes. In the main method context it is
        just a random number. In the unit testing context it can be a specific word
        in the list.
     */
        Random seed = new Random();
        word = wordSelect(seed.nextInt(11));

        // set an initial value for the previousWordMap to compare to currentWordMap
        previousWordMap = wordMap(guessAttempts);

        // begin game loop.
        boolean gameRunning = gameLoop();
        // once game ends, check if the player wants to play again.
        replay(gameRunning);

    }

    public static boolean gameLoop() throws IOException {

        boolean playing = true;

        while (playing) {

            System.out.println(state[numberOfIncorrectGuesses]);

            // print out the correct/incorrect guesses so far
            System.out.println(previousWordMap);

            // get a guess from the user
            char guess = getGuess();
            // add the current guess to guessAttempts
            guessAttempts.add(guess);
            // update the current word map
            currentWordMap = wordMap(guessAttempts);
            // show the word map
            System.out.println(currentWordMap);

            // check if guess is incorrect by comparing current and previous results.
            if (currentWordMap.equals(previousWordMap)) {
                numberOfIncorrectGuesses++;
            }

            // current map is not the previous map for next loop iteration.
            previousWordMap = currentWordMap;

            // check for win/lose
            if (numberOfIncorrectGuesses == 6) {
                System.out.println("You LOSE! Try again!");
                playing = false;
            }
            if (numberOfCorrectGuesses == word.length()) {
                System.out.println("You WIN!!!");
                playing = false;
            }

        }
        // end loop once playing is set to false
        return playing;

    }

    public static String wordMap(ArrayList<Character> guessAttempts) {

        StringBuilder findGuessMap = new StringBuilder();


        // For each guess attempt, if the index contains the guess, show that letter.
        for (int i = 0; i < word.length(); i++) {
            if (guessAttempts.contains(word.charAt(i))) {
                findGuessMap.append(word.charAt(i));
            }
            // Otherwise, show a dash.
            else {
                findGuessMap.append("-");
            }
        }
        // scrub number of correct guesses value so that it reflects accurate number of guesses
        numberOfCorrectGuesses = 0;
        // update number of correct guesses
        for (int i = 0; i < findGuessMap.length(); i++){
            if (findGuessMap.charAt(i) != '-') {
                numberOfCorrectGuesses++;
            }
        }
        // Keep a clean print structure for the user.
        return findGuessMap.toString();
    }

    public static String wordSelect(int seed) throws IOException {

        ArrayList<String> wordList = new ArrayList<>();
        Random wordSelect = new Random(seed);

        wordList.addAll(Files.readAllLines(Path.of("src/main/resources/word.txt")));
        wordList.addAll(List.of(wordList.get(0).split(",")));
        wordList.remove(0);

        // The method then returns either the random or asserted value.
        return wordList.get(wordSelect.nextInt(wordList.size()));
    }

    public static char getGuess() throws IOException {
        // Prompt user for guess and evaluate keyboard input.

        BufferedReader keyListen;

        keyListen = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please enter a new guess: ");
        userGuess = keyListen.readLine();
        char checker = 0;

        if (userGuess.length() == 1) {
            for (int i = 0; i < 1; i++) {
                checker = userGuess.charAt(i);
            }
            if (guessAttempts.contains(checker)) {
                System.out.println("You already guessed that!");
                getGuess();
            }
        }

        if (userGuess.length() == 1) {
            return userGuess.charAt(0);
        }
        else {
            System.out.println("Incorrect Input.");
            getGuess();
        }

        return userGuess.charAt(0);
    }

    public static void replay (boolean gameRunning) throws IOException {

        // If player would like to play again, call to re-initialize the game.
        BufferedReader choice = new BufferedReader(new InputStreamReader(System.in));

        if (!gameRunning) {
            System.out.println("Would you like to play again (y/n)?");

            playAgain = choice.readLine();
            if (playAgain.equals("y")) {
                initialize();
            }
            else if (playAgain.equals("n")) {
                System.exit(0);
            }
            else {
                System.out.println("Incorrect Input");
                replay(false);
            }

        }
    }
}