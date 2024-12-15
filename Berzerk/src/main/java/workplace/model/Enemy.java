package workplace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import workplace.Enums.Direction;

import java.util.Random;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class Enemy extends ActiveEntity {
    private Random random;

    public Enemy(int x, int y, int health, Bullet bullet) {
        super(x, y, health, bullet);
        image=Parameters.ENEMY_IMAGE_RIGHT;
    }

    public void move(MoveParameters moveParameters) {
        Map map=moveParameters.getMap();
        this.random=moveParameters.getRandom();
        switch (random.nextInt(4)) {
            case 0:
                facingDirection= Direction.right;
                for (Wall wall : map.getWalls()) if (x + map.getTileSize() == wall.getX() && y == wall.getY()) return; // tikrina ar paejus i desine viena blokeli nebus sutitkta siena
                x=x + map.getTileSize();
                image=Parameters.ENEMY_IMAGE_RIGHT;
                break;
            case 1:
                facingDirection= Direction.left;
                for (Wall wall : map.getWalls()) if (x - map.getTileSize() == wall.getX() && y == wall.getY()) return;
                x=x - map.getTileSize();
                image=Parameters.ENEMY_IMAGE_LEFT;
                break;
            case 2:
                facingDirection= Direction.down;
                for (Wall wall : map.getWalls()) if (x == wall.getX() && y + map.getTileSize() == wall.getY()) return;
                y=y + map.getTileSize();
                break;
            case 3:
                facingDirection= Direction.up;
                for (Wall wall : map.getWalls()) if (x == wall.getX() && y - map.getTileSize() == wall.getY()) return;
                y=y - map.getTileSize();
                break;
        }
    }
    public void shoot(ShootParameters shootParameters) {
        Player player=shootParameters.getPlayer();
        if (bullet != null) return;
        if (player.getX() == x) {
            if (player.getY() > y) {
                facingDirection = Direction.down;
                bullet = new Bullet(Parameters.ENEMY_BULLET_DAMAGE, facingDirection, x, y);
            }
            else if (player.getY() < y) {
                facingDirection = Direction.up;
                bullet = new Bullet(Parameters.ENEMY_BULLET_DAMAGE, facingDirection, x, y);
            }
        }
        else if (player.getY() == y) {
            if (player.getX() > x) {
                facingDirection = Direction.right;
                bullet = new Bullet(Parameters.ENEMY_BULLET_DAMAGE, facingDirection, x, y);
            }
            else if (player.getX() < x) {
                facingDirection = Direction.left;
                bullet = new Bullet(Parameters.ENEMY_BULLET_DAMAGE, facingDirection, x, y);
            }
        }
    }
}
