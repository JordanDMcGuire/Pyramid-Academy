
public class Human extends MapObject {

    // See the MapObject class for definitions

    // Empty Human is a "Dead Human"
    public Human() {

        this.name = "Dead Human";
        this.xPosition = 0;
        this.yPosition = 0;
        this.health = 0;
        this.strength = 0;
        this.symbol = '|';

    }

    // Simple constructor for testing purposes
    public Human(String i, int iX, int iY) {

            this.name = i;
            this.xPosition = iX;
            this.yPosition = iY;
            this.symbol = '♥';

    }

    // Full constructor with health and strength
    public Human(String i, int iX, int iY, int iS, int iH) {

            this.name = i;
            this.xPosition = iX;
            this.yPosition = iY;
            this.strength = iS;
            this.health = iH;
            this.symbol = '♥';

    }


}
