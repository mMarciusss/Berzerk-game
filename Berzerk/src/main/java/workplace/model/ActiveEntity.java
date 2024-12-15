package workplace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import workplace.Enums.Direction;

import java.awt.*;
import java.awt.event.KeyEvent;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public abstract class ActiveEntity {
    protected Image image;
    protected int x;
    protected int y;
    protected int health;
    protected Bullet bullet;
    protected Direction facingDirection;

    public ActiveEntity(int x, int y, int health, Bullet bullet) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.bullet = bullet;
        this.facingDirection = Direction.right;
    }

    public abstract void move(MoveParameters moveParameters);
    public abstract void shoot(ShootParameters shotParameters);

    public void takeDamage(Bullet bullet) {
        if(isAlive())this.health -= bullet.getDamage();
    }
    public boolean isAlive(){
        return health > Parameters.DEATH_THRESHOLD;
    }
}
