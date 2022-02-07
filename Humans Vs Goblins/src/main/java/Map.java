public class Map {

    public Map () {
    }

    public static void printMap(MapObject player, MapObject enemy) {

        int yRows = 10;
        int xColumns = 32;
        char[][] playMap = new char[yRows][xColumns];

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        for (int i = 0; i < yRows; i++) {
            for (int j = 0; j < xColumns; j++) {
                if (i == player.getYPosition() && j == player.getXPosition()) {
                    playMap[i][j] = '♥';
                }
                else if (i == enemy.getYPosition() && j == enemy.getXPosition()) {
                    playMap[i][j] = 'X';
                }
                else if (j % 2 == 0){
                    playMap[i][j] = '|';
                }
                else {
                    playMap[i][j] = ' ';
                }
            }
        }
        for (int i = 0; i < yRows; i++) {
            for (int j = 0; j < xColumns; j++) {
                System.out.print(playMap[i][j]);

            }
            System.out.println();
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

}
