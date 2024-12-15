package workplace.model;

public class ObjectFactory {
    public static Wall createWall(int x, int y) {
        return new Wall(x, y);
    }
    public static Player createPlayer(int x, int y, int health, Bullet bullet, Map map) {
        return new Player(x, y, health, bullet, map);
    }
    public static Enemy createEnemy (int x, int y, int health, Bullet bullet) {
        return new Enemy(x, y, health, bullet);
    }

}
