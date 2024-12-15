package workplace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import workplace.Enums.Direction;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class Bullet {
    private Image image;
    private int x;
    private int y;
    private Direction bulletDirection;
    private int damage;

    public Bullet(int damage, Direction bulletDirection, int x, int y) {
        this.damage = damage;
        this.bulletDirection = bulletDirection;
        this.x = x;
        this.y = y;
        this.image = Parameters.BULLET_IMAGE;
    }

    public void moveBullet(ActiveEntity activeEntity, Map map) {
        if (activeEntity.getBullet().getBulletDirection() == Direction.right)
            activeEntity.getBullet().setX(activeEntity.getBullet().getX() + map.getTileSize());//right
        if (activeEntity.getBullet().getBulletDirection() == Direction.left)
            activeEntity.getBullet().setX(activeEntity.getBullet().getX() - map.getTileSize());//left
        if (activeEntity.getBullet().getBulletDirection() == Direction.up)
            activeEntity.getBullet().setY(activeEntity.getBullet().getY() - map.getTileSize());//up
        if (activeEntity.getBullet().getBulletDirection() == Direction.down)
            activeEntity.getBullet().setY(activeEntity.getBullet().getY() + map.getTileSize());//down
    }
}
