
public class Map {

    // Constructor
    public Map () {
    }

    /*
        A method to create a string representation of the map.
        This method uses a two-dimensional array of strings and
        nested for loops to assess the positions of each
        MapObject, insert them into the map while drawing it,
        and then converts the whole thing into a single string.
    */
    public static String buildMap(MapObject player, MapObject enemy) {

        StringBuilder mapString = new StringBuilder();
        int yRows = 10;
        int xColumns = 32;
        String[][] playMap = new String[yRows][xColumns];

        mapString.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        for (int i = 0; i < yRows; i++) {
            for (int j = 0; j < xColumns; j++) {
                if (i == player.getYPosition() && j == player.getXPosition()) {
                    playMap[i][j] = String.valueOf(HumansVsGoblins.human.symbol);
                }
                else if (i == enemy.getYPosition() && j == enemy.getXPosition()) {
                    playMap[i][j] = String.valueOf(HumansVsGoblins.goblin.symbol);
                }
                else if (j % 2 == 0){
                    playMap[i][j] = "|";
                }
                else {
                    playMap[i][j] = " ";
                }
            }
        }
        for (int i = 0; i < yRows; i++) {
            for (int j = 0; j < xColumns; j++) {

                mapString.append(playMap[i][j]);
                // System.out.print(playMap[i][j]);  <- for void

            }
            mapString.append("\n");

        }

        mapString.append("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        return mapString.toString();

    }

    // This method overrides the toString method to easily display the map to the console, complete with a legend
    @Override
    public String toString() {

        StringBuilder mapInfo = new StringBuilder();
        mapInfo.append(buildMap(HumansVsGoblins.human, HumansVsGoblins.goblin) + "\n");
        mapInfo.append("♥ = Human | X = Goblin");

        return mapInfo.toString();
    }

}
