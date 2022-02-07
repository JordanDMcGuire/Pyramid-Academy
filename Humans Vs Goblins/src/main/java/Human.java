public class Human extends MapObject {

        public Human(String i, int iX, int iY) {

                name = i;
                xPosition = iX;
                yPosition = iY;

        }
        public Human(String i, int iX, int iY, int iS, int iH) {

                name = i;
                xPosition = iX;
                yPosition = iY;
                strength = iS;
                health = iH;

        }


}
