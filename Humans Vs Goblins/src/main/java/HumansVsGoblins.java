
public class HumansVsGoblins {

    public static void main(String[] args) {

        Map map = new Map();

        MapObject testIt = new MapObject("Test", 2, 25);
        Human human = new Human("test", 7, 25);
        Goblin goblin = new Goblin("test1", 3, 23);

        map.printMap(human, goblin);

    }

}
