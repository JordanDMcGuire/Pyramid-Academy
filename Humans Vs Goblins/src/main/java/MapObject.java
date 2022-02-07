public class MapObject {

    int yPosition;
    int xPosition;
    int strength;
    int health;
    String name;


    public MapObject() {

    }

    public MapObject(String i, int iX, int iY) {

        this.name = i;
        this.xPosition = iX;
        this.yPosition = iY;

    }

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

    public void collisionDetection (MapObject player, MapObject object) {
        if ((player.getXPosition() == object.getXPosition() ||
            player.getXPosition() == object.getXPosition() + 2 ||
            player.getXPosition() == object.getXPosition() - 2) &&
            (player.getYPosition() == object.getYPosition() ||
            player.getYPosition() == object.getYPosition() + 1 ||
            player.getYPosition() == object.getYPosition() - 1)) {
            System.out.println("contact");
        }
        else {
            System.out.println("no contact");
        }
    }

}
