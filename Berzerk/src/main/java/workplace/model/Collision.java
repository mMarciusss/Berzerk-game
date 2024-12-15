package workplace.model;

public class Collision {
    public static boolean collidesWithEntity(Bullet bullet, ActiveEntity activeEntity) {
        return  bullet.getX() == activeEntity.getX() && bullet.getY() == activeEntity.getY();
    }

    public static boolean collidesWithWall(Bullet bullet, Wall wall) {
        return  bullet.getX() == wall.getX() && bullet.getY() == wall.getY();
    }
}
