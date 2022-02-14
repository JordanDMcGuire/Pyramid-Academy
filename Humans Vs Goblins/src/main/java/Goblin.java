
public class Goblin extends MapObject {

    // See the MapObject class for definitions

    // Empty Goblin is a "Dead Goblin"
    public Goblin() {

        this.name = "Dead Goblin";
        this.xPosition = 0;
        this.yPosition = 0;
        this.health = 0;
        this.strength = 0;
        this.symbol = '|';

    }

    // Simple constructor for testing purposes
    public Goblin(String i, int iX, int iY) {

        this.name = i;
        this.xPosition = iX;
        this.yPosition = iY;
        this.symbol = 'X';

    }

    // Full constructor with health and strength
    public Goblin(String i, int iX, int iY, int iS, int iH) {

        this.name = i;
        this.xPosition = iX;
        this.yPosition = iY;
        this.strength = iS;
        this.health = iH;
        this.symbol = 'X';

    }

    // This method is exclusive the Goblin class. It allows the Goblin to chase the player.
    public void chase() {

        if (HumansVsGoblins.human.yPosition > this.yPosition) {
            this.move(this, "s");
        }
        else if (HumansVsGoblins.human.yPosition < this.yPosition) {
            this.move(this, "n");
        }
        else if (HumansVsGoblins.human.xPosition > this.xPosition) {
            this.move(this, "e");
        }
        else if (HumansVsGoblins.human.xPosition < this.xPosition) {
            this.move(this, "w");
        }

    }

}
