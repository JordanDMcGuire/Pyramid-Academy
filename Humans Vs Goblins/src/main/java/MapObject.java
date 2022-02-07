public class MapObject {

    public int xPosition;
    public int yPosition;
    public String name;

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

    public void setXPosition(int sX) {
        this.xPosition = sX;
    }
    public void setYPosition(int sY) {
        this.yPosition = sY;
    }

}
