/**
 * Jordan McGuire *
 This is a game, called Dragon Cave. The user is faced with a choice between wealth
 and certain death. The user's input is handled by a simple if-else statement.
 **/

import java.util.Scanner;

public class Main {

    public static void main(String[] args){

        prompt();

        input();

    }

    // A method to print the original Dragon Cave prompt
    public static void prompt(){
        System.out.println("You are in a land full of dragons. In front of you,");
        System.out.println("you see two caves. In one cave, the dragon is friendly");
        System.out.println("and will share his treasure with you. The other dragon");
        System.out.println("is greedy and hungry and will eat you on sight.");
        System.out.print("Which cave will you go into? (1 or 2): ");
    }

    // A method to receive the user input
    public static void input(){

        // Setup Scanner object and take user input
        Scanner input = new Scanner(System.in);
        int userChoice = input.nextInt();

        // Call the response method with userChoice as a parameter
        response(userChoice);
    }

    // A method to handle user input and generate a response
    public static void response(int userChoice){

        // 1 and 2 produce a result. Any other integer results in a call to the input method.
        if (userChoice == 1) {
            badDecision();
        }
        else if (userChoice == 2){
            goodDecision();
        }
        else {
            System.out.print("Invalid Response. Try again: ");
            input();
        }
    }

    // A method to print the negative result
    public static void badDecision(){
        System.out.println("You approach the cave...");
        System.out.println("It is dark and spooky...");
        System.out.println("A large dragon jumps out in front of you! He opens his jaws and...");
        System.out.println("Gobbles you down in one bite!");
    }

    // A method to print the positive result
    public static void goodDecision(){
        System.out.println("You approach the cave...");
        System.out.println("You see bright dancing lanterns, and it smells wonderful...");
        System.out.println("A large dragon jumps out in front of you! He makes you a business proposition...");
        System.out.println("You develop his app and now you are both rich!");
    }

}
