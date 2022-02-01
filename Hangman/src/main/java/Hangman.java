
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class Hangman {

    // Global game variable are defined here
    public static String word;
    /*
        An ArrayList will hold the values that the player has guessed correctly in the
        given word.
    */
    public static ArrayList<Character> guessAttempts = new ArrayList<>();
    public static int numberOfCorrectGuesses = 0;
    public static int numberOfIncorrectGuesses = 0;
    public static String previousWordMap = "";
    public static String currentWordMap = "";
    public static String userGuess = "";
    public static String playAgain;

    public static void main(String[] args) {

        // all global values are reset and a new game begins.
        initialize();

    }

    private static void initialize() {

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

    public static boolean gameLoop() {

        boolean playing = true;

        while (playing) {

            // Begin print gallows and/or man.
            System.out.println(" -------");
            System.out.println(" |     |");
            if (numberOfIncorrectGuesses >= 1) {
                System.out.println(" O     |");
            }
            else {
                System.out.println("       |");
            }

            if (numberOfIncorrectGuesses >= 2) {
                System.out.print("\\ ");
                if (numberOfIncorrectGuesses >= 3) {
                    System.out.println("/    |");
                }
                else {
                    System.out.println("     |");
                }
            }
            else {
                System.out.println("       |");
            }

            if (numberOfIncorrectGuesses >= 4) {
                System.out.println(" |     |");
            }
            else {
                System.out.println("       |");
            }

            if (numberOfIncorrectGuesses >= 5) {
                System.out.print("/ ");
                if (numberOfIncorrectGuesses >= 6) {
                    System.out.println("\\    |");
                }
                else {
                    System.out.println("     |");
                }
            }
            else {
                System.out.println("       |");
            }
            System.out.println("       |");
            System.out.println("========");
            // End printing gallows and/or man.

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

    public static String wordSelect(int seed) {

        /*
            Here there are three variables being created. One is Scanner object that will
            capture the word list from this project file. The next is an ArrayList that
            holds the contents of the wordlist. The last is a Random generator object that
            selects a word based on the seed. Since main passes a random seed to this, it
            will choose a random word. The seed is used for unit testing purposes so that
            this method's unit test can assert a specific value in the wordlist.
         */
        Scanner getWords = null;
        ArrayList<String> wordList = new ArrayList<>();
        Random wordSelect = new Random(seed);

        // This statement tries to find the wordlist. If it fails, the program also fails.
        try {
            getWords = new Scanner(new File("D:\\Pyramid-Academy\\Hangman\\word.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Hangman Exit Codes:");
            System.out.println("0: Normal Exit");
            System.out.println("1: No Word List Found");
            System.out.println(e.getMessage());
            System.exit(1);
        }

        // This statement adds the wordlist to the ArrayList.
        while (getWords.hasNext()) {
            wordList.add(getWords.nextLine());
        }

        // The method then returns either the random or asserted value.
        return wordList.get(wordSelect.nextInt(wordList.size()));
    }

    public static char getGuess() {
        // Prompt user for guess and evaluate keyboard input.

        BufferedReader keyListen;

        try {

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
                throw new InputMismatchException();
            }
        } catch (InputMismatchException | IOException e) {
            System.out.println("Incorrect Input.");
            getGuess();
        }
        return userGuess.charAt(0);
    }

    public static void replay (boolean gameRunning) {

        // If player would like to play again, call to re-initialize the game.
        BufferedReader choice = new BufferedReader(new InputStreamReader(System.in));

        if (!gameRunning) {
            System.out.println("Would you like to play again (y/n)?");
            try{
                playAgain = choice.readLine();
                if (playAgain.equals("y")) {
                    initialize();
                }
                else if (playAgain.equals("n")) {
                    System.exit(0);
                }
                else {
                    throw new InputMismatchException();
                }
            } catch(InputMismatchException | IOException f){
                System.out.println("Incorrect Input");
                replay(false);
            }
        }
    }
}


