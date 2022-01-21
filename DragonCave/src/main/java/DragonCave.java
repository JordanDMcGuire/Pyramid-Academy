/**
 * Jordan McGuire *
 This is a game, called Dragon Cave. The user is faced with a choice between wealth
 and certain death. The user's input is handled by a simple if-else statement.
 **/

import java.util.*;

public class DragonCave {

    private static boolean inputSuccess = false;

    public static void main(String[] args){

        System.out.println(prompt());
        int userChoice = input();

        if(userChoice == 1)
            System.out.println(badDecision());
        else
            System.out.println(goodDecision());

    }

    // A method to print the original Dragon Cave prompt
    public static String prompt(){

        return ("""
                You are in a land full of dragons. In front of you,
                you see two caves. In one cave, the dragon is friendly
                and will share his treasure with you. The other dragon
                is greedy and hungry and will eat you on sight.
                Which cave will you go into? (1 or 2):\s""");
    }

    // A method to receive the user input
    public static int input(){

        int userChoice = 0;
        Scanner input = new Scanner(System.in);

        while (!inputSuccess) {
            try {

                userChoice = input.nextInt();

                // 1 and 2 produce a result. Any other integer results in a call to the input method.
                if (userChoice == 1) {
                    inputSuccess = true;
                    return userChoice;
                }
                else if (userChoice == 2){
                    inputSuccess = true;
                    return userChoice;
                }
                else {
                    throw new InputMismatchException("Only 1 and 2 are valid responses");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Response. Please enter 1 or 2: ");
            }
        }
        return userChoice;
    }

    // A method to print the negative result
    public static String badDecision(){
        return ("""
            You approach the cave...
            It is dark and spooky...
            A large dragon jumps out in front of you! He opens his jaws and...
            Gobbles you down in one bite!""");
    }

    // A method to print the positive result
    public static String goodDecision(){
        return ("""
            You approach the cave...
            You see bright dancing lanterns, and it smells wonderful...
            A large dragon jumps out in front of you! He makes you a business proposition...
            You develop his app and now you are both rich!""");
    }

}
