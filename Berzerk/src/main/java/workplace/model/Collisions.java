package workplace.model;

import java.util.ArrayList;

public class Collisions {
    public static void checkBulletCollision(Player player, ArrayList<Enemy> enemies, ArrayList <Wall> walls) {
        if (player.getBullet() != null) {
            for (ActiveEntity enemy : enemies) {
                if (!Collision.collidesWithEntity(player.getBullet(), enemy)) continue;
                enemy.takeDamage(player.getBullet());
                player.setBullet(null);
                break;
            }
        }
        for (ActiveEntity enemy : enemies) {
            if (enemy.getBullet() == null) continue;
            if (!Collision.collidesWithEntity(enemy.getBullet(), player)) continue;
            player.takeDamage(enemy.getBullet());
            enemy.setBullet(null);
            break;
        }
        for (Wall wall : walls) {
            if (player.getBullet() != null) {
                if (!Collision.collidesWithWall(player.getBullet(), wall)) continue;
                player.setBullet(null);
                break;
            }
        }
        for (Wall wall : walls) {
            for (ActiveEntity enemy : enemies) {
                if (enemy.getBullet() == null) continue;
                if (!Collision.collidesWithWall(enemy.getBullet(), wall)) continue;
                enemy.setBullet(null);
                break;
            }
        }
    }
}
