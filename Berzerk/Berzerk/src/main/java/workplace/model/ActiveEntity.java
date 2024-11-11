package workplace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.awt.*;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class ActiveEntity {
    protected Image image;
    protected int x;
    protected int y;
    private int health;
    private int damage;
    private Bullet bullet;

    public void takeDamage(int damage) {
        if(isAlive())this.health -= damage;
    }
    public boolean isAlive(){
        return health > 0;
    }
}
