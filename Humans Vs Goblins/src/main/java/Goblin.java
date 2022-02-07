public class Goblin extends MapObject {

    public Goblin(String i, int iX, int iY) {

        name = i;
        xPosition = iX;
        yPosition = iY;

    }
    public Goblin(String i, int iX, int iY, int iS, int iH) {

        name = i;
        xPosition = iX;
        yPosition = iY;
        strength = iS;
        health = iH;

    }

}
