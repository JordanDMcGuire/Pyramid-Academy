public class mapObject {

    private int xPosition;
    private int yPosition;
    private String name;

    public mapObject () {

    }

    public mapObject (String i, int iX, int iY) {

        name = i;
        xPosition = iX;
        yPosition = iY;

    }

    public int getXPosition() {
        return this.xPosition;
    }
    public int getYPosition() {
        return this.yPosition;
    }

    public void setXPosition(int sX) {
        xPosition = sX;
    }
    public void setYPosition(int sY) {
        yPosition = sY;
    }

}
