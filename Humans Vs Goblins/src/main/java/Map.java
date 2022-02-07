public class Map {

    public Map (){

    }


    public static void printMap(MapObject player, MapObject enemy) {

        int xRows = 10;
        int yColumns = 32;
        char[][] playMap = new char[xRows][yColumns];

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        for (int i = 0; i < xRows; i++) {
            for (int j = 0; j < yColumns; j++) {
                if (i == player.getXPosition() && j == player.getYPosition()) {
                    playMap[i][j] = '♥';
                }
                else if (i == enemy.getXPosition() && j == enemy.getYPosition()) {
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
        for (int i = 0; i < xRows; i++) {
            for (int j = 0; j < yColumns; j++) {
                System.out.print(playMap[i][j]);

            }
            System.out.println();
        }

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

}
