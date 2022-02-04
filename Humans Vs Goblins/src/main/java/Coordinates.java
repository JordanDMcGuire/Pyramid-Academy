public class Coordinates {

    public static void printMap(int x, int y) {

        int xRows = 10;
        int yColumns = 32;
        char[][] playMap = new char[xRows][yColumns];

        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

        for (int i = 0; i < xRows; i++) {
            for (int j = 0; j < yColumns; j++) {
                if (i == x && j == y) {
                    playMap[i][j] = '♥';
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
