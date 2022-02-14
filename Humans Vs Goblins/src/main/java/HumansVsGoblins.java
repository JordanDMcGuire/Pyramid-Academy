
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;

public class HumansVsGoblins {

    // Create player, enemy, map, and global check values
    public static Human human = new Human("Henry VonHuman", 23, 7, 15, 100);
    public static Goblin goblin = new Goblin("Godrick Goblindor", 7, 2, 15, 100);
    public static Map playMap = new Map();
    public static boolean battling = false;

    public static void main(String[] args) {

        // Reader and variable for tracking directional input from user
        BufferedReader keyListen = new BufferedReader(new InputStreamReader(System.in));
        int inputSuccess = 0;

        // Show initial map setup
        System.out.println(playMap.toString());
        System.out.println(human.toString());
        System.out.println(goblin.toString() + "\n");

        // Initiate turn-based movement between player and enemy
        while (!human.collisionDetection(human, goblin)) {
            turnExecute(playMap, keyListen, inputSuccess);
            inputSuccess = 0;
        }

        // Once the player and the enemy are next to each other, start combat
        battling = true;
        while (battling) {
            human.battle(human, goblin, playMap);
        }

        // Display the final results
        System.out.println("The war is over!\n");
        System.out.println(playMap.toString());
        System.out.println(human.toString());
        System.out.println(goblin.toString());

    }

    // This method handles turn-based movement
    private static void turnExecute(Map map, BufferedReader keyListen, int inputSuccess) {

        // A string to send to the move(MapObject, String) class
        String direction;

        // Prompt the user for internet
        System.out.print("Choose a direction to move (n/s/e/w): ");

        // Get user input
        do {
            try {

                direction = keyListen.readLine();

                if (direction.equals("n")
                    || direction.equals("s")
                    || direction.equals("e")
                    || direction.equals("w")) {
                    human.move(human, direction);
                    inputSuccess = 1;
                }
                else {
                    throw new InputMismatchException();
                }

            } catch (IOException | InputMismatchException e) {
                System.out.println("Incorrect Input");
            }
        } while (inputSuccess == 0);

        // Goblin moves towards the player by one square
        goblin.chase();

        // Pause so user can read movement results before printing new map
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print new map results, player info, and enemy info
        System.out.println(map);
        human.collisionDetection(human, goblin);
        System.out.println(human.toString());
        System.out.println(goblin.toString());
    }

}
