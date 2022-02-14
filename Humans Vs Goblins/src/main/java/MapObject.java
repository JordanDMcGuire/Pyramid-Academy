
public class MapObject {

    // Variables for attributes
    int yPosition;
    int xPosition;
    int strength;
    int health;
    String name;
    char symbol;

    // Constructor
    public MapObject() {

    }

    // Simple constructor for testing purposes
    public MapObject(String i, int iX, int iY) {

        this.name = i;
        this.xPosition = iX;
        this.yPosition = iY;

    }

    // Full constructor
    public MapObject(String i, int iX, int iY, int iS, int iH) {

        this.name = i;
        this.xPosition = iX;
        this.yPosition = iY;
        this.strength = iS;
        this.health = iH;

    }

    // Accessor methods are declared here
    public int getXPosition() {
        return this.xPosition;
    }
    public int getYPosition() {
        return this.yPosition;
    }
    public int getStrength() {
        return this.strength;
    }
    public int getHealth() {
        return this.health;
    }

    // Mutator methods are declared here
    public void setXPosition(int sX) {
        this.xPosition = sX;
    }
    public void setYPosition(int sY) {
        this.yPosition = sY;
    }
    public void setStrength(int sS) {
        this.strength = sS;
    }
    public void setHealth(int sH) {
        this.health = sH;
    }

    /*
        The collision detection method simply checks whether the player is next to the enemy.
        This is done by checking the coordinates of both objects to see if they are
        above, below, or adjacent to each other.
     */
    public boolean collisionDetection(MapObject player, MapObject object) {
            if ((player.getXPosition() == object.getXPosition() ||
            player.getXPosition() == object.getXPosition() + 2 ||
            player.getXPosition() == object.getXPosition() - 2) &&
            (player.getYPosition() == object.getYPosition() ||
            player.getYPosition() == object.getYPosition() + 1 ||
            player.getYPosition() == object.getYPosition() - 1)) {

            System.out.println("Contact");

            return true;

        }
        else {
            return false;
        }
    }

    // This method overrides the toString method to easily print each object to the console
    @Override
    public String toString() {

        return this.symbol + " |Name: " + this.name + " | Position: (" + this.getXPosition() + "," +
                this.getYPosition() + ") | Health: " + this.getHealth() + " | Strength: " + this.getStrength() + "|";
    }

    // Battle occurs when objects are next to each other. Each object is given a random d10 roll to attack.
    public void battle(MapObject player, MapObject enemy, Map map) {

        System.out.println(player.name + " and " + enemy.name + " are battling!\n");

        int playerHit = player.strength + (int)(Math.random() * 10);
        int enemyHit = enemy.strength + (int)(Math.random() * 10);

        enemy.setHealth(enemy.getHealth() - playerHit);
        player.setHealth(player.getHealth() - enemyHit);

        System.out.println(player.name + " has hit " + enemy.name + " for " + playerHit + "damage.");
        System.out.println(enemy.name + " has hit " + player.name + " for " + enemyHit + "damage.\n");

        if (enemy.health < 0) {
            HumansVsGoblins.goblin = new Goblin();
            System.out.println("You have won the battle!");
            HumansVsGoblins.battling = false;
        }
        if (player.health < 0) {
            HumansVsGoblins.human = new Human();
            System.out.println("You were defeated by " + enemy.name + "!");
            HumansVsGoblins.battling = false;
        }

        System.out.println();

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // This method handles movement for all objects.
    public void move(MapObject mover, String direction) {
        if (direction.equals("n")){
            mover.yPosition = mover.getYPosition() - 1;
            System.out.println(mover.name + " has moved North one square.");
        }
        if (direction.equals("s")){
            mover.yPosition = mover.getYPosition() + 1;
            System.out.println(mover.name + " has moved South one square.");
        }
        if (direction.equals("e")){
            mover.xPosition = mover.getXPosition() + 2;
            System.out.println(mover.name + " has moved East one square.");
        }
        if (direction.equals("w")){
            mover.xPosition = mover.getXPosition() - 2;
            System.out.println(mover.name + " has moved West one square.");
        }
    }

}
