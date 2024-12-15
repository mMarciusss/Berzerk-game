package workplace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import workplace.Enums.Direction;

import javax.swing.*;
import java.awt.event.KeyEvent;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class Player extends ActiveEntity {
    private int key;
    private Map map;
    public Player(int x, int y, int health, Bullet bullet, Map map) {
        super(x, y, health, bullet);
        image=Parameters.PLAYER_IMAGE_RIGHT;
    }

    public void move(MoveParameters moveParameters) {
        map=moveParameters.getMap();
        key=moveParameters.getE().getKeyCode();
        if(key==KeyEvent.VK_RIGHT){
            for(Wall wall: map.getWalls()) if(x+map.getTileSize()==wall.getX() && y==wall.getY()) return; // tikrina ar paejus i desine viena blokeli nebus sutitkta siena
            facingDirection=Direction.right;
            x=x+map.getTileSize();
            image=Parameters.PLAYER_IMAGE_RIGHT;
        }
        if(key==KeyEvent.VK_LEFT){
            for(Wall wall: map.getWalls()) if(x-map.getTileSize()==wall.getX() && y==wall.getY()) return;
            facingDirection=Direction.left;
            x=x-map.getTileSize();
            image=Parameters.PLAYER_IMAGE_LEFT;
        }
        if(key==KeyEvent.VK_UP){
            for(Wall wall: map.getWalls()) if(x==wall.getX() && y-map.getTileSize()==wall.getY()) return;
            facingDirection=Direction.up;
            y=y-map.getTileSize();
        }
        if(key==KeyEvent.VK_DOWN){
            for(Wall wall: map.getWalls()) if(x==wall.getX() && y+map.getTileSize()==wall.getY()) return;
            facingDirection=Direction.down;
            y=y+map.getTileSize();
        }
    }
    public void shoot(ShootParameters shootParameters) {
        if(key==KeyEvent.VK_E){
            bullet = new Bullet(Parameters.PLAYER_BULLET_DAMAGE, facingDirection, x, y);
        }
    }
}
