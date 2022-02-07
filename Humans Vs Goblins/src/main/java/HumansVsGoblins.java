
public class HumansVsGoblins {

    public static void main(String[] args) {

        Map map = new Map();

        Human human = new Human("test", 23, 7);
        Goblin goblin = new Goblin("test1", 19, 7);

        human.collisionDetection(human, goblin);

        map.printMap(human, goblin);
        human.collisionDetection(human, goblin);

    }

}
