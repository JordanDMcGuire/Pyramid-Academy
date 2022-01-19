/**
 * Jordan McGuire *
 This is a guessing game. The program generates a random number from 1 to 20 and prompts the user for
 a guess. The program keeps track of how many guesses it takes the user to find the number. The program
 also notifies the user if their guess is too high or too low. The user can play as many times as they
 wish until terminating the program.
 **/

import java.util.*;

public class GuessTheNumber {

    // Generate random number for answer
    public static Random generator = new Random();
    public static int correctNumber = generator.nextInt(20) + 1;

    // Track number of guesses
    public static int newGuess;
    public static int numberOfGuesses = 0;

    // Global variable for name
    public static String userName;

    public static void main(String[] args){

        // Greet user and getName
        userName = greeting();

        System.out.println("Well, " + userName + ", I am thinking of a number between 1 and 20.");

        // Prompt user for guess
        newGuess = getGuess();

        // Take input and determine win or loss
        isCorrect(newGuess);

    }

    // A method to handle the initial greeting
    public static String greeting(){

        System.out.print("Hello! What is your name? ");
        Scanner greetingInput = new Scanner(System.in);
        boolean isName = false;
        String name = "";

        do {
            try {
                name = greetingInput.nextLine();
                if (!name.equals("")) {
                    isName = true;
                    greetingInput.reset();
                    return name;
                }
                else {
                    throw new InputMismatchException();
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Please enter your name: ");
            }
        } while (!isName);
        return name;
    }

    // A method to handle guess retrieval
    public static int getGuess(){

        numberOfGuesses++;
        int guess = 0;
        boolean isNumber = false;

        while (!isNumber) {
            try {
                Scanner getGuessInput = new Scanner(System.in);
                System.out.println("Take a guess.");
                guess = getGuessInput.nextInt();
                isNumber = true;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input. Please enter a number between 1 and 20.");
            }
        }
        return guess;
    }

    // Check if the answer is correct or incorrect
    public static void isCorrect(int guess){
        if (guess == correctNumber)
            success();
        else
            tryAgain(guess);
    }

    // Prompt for additional guess if too low or too high
    public static void tryAgain(int lowHigh) {
        if (lowHigh < correctNumber) {
            System.out.println("Your guess is too low.");
        }
        else {
            System.out.println("Your guess is too high.");
        }

        newGuess = getGuess();
        isCorrect(newGuess);
    }

    // Prompt for success
    public static void success() {
        if (numberOfGuesses == 1)
            System.out.println("Good job, " + userName + "! You guessed my number in " + numberOfGuesses + " guess!");
        else
            System.out.println("Good job, " + userName + "! You guessed my number in " + numberOfGuesses + " guesses!");

        playAgain();
    }

    // Allow user to play the game again
    public static void playAgain() {
        System.out.println("Would you like to play again? (y or n) ");
        Scanner getChoice = new Scanner(System.in);

        try {
            String choice = getChoice.nextLine();
            if (choice.equals("y")) {
                System.out.println("Alright, " + userName + "! Let's play again!");
                System.out.println("I am thinking of a number between 1 and 20.");
                correctNumber = generator.nextInt(20) + 1;
                numberOfGuesses = 0;
                newGuess = getGuess();
                isCorrect(newGuess);
            } else if (choice.equals("n")) {
                System.out.println("Thank you for playing!");
                System.exit(0);
            } else {
                throw new InputMismatchException();
            }
        }
        catch (InputMismatchException e){
            System.out.println("Invalid Response.");
            playAgain();
        }
    }
}