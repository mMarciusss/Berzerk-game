package workplace.model;

import org.junit.Test;
import workplace.Enums.Direction;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ClassForTesting{
    @Test
    public void test1(){
        Map map= new Map();
        map.getMapLayout();
        Player player=new Player(0, 0, 100, null, null);
        Enemy enemy=new Enemy(0, map.getTileSize(), 50, null);
        Bullet playerBullet = new Bullet(50, Direction.down, player.getX(), player.getY());
        player.setBullet(playerBullet);

        playerBullet.setY((playerBullet.getY()+1)*map.getTileSize());
        Collisions.checkBulletCollision(player, new ArrayList<Enemy>(Arrays.asList(enemy)), map.getWalls());

        assertNull( player.getBullet());
        assertEquals(0, enemy.getHealth());
    }
    @Test
    public void test2(){
        Map map= new Map();
        map.getMapLayout();
        Player player=new Player(0, map.getTileSize(), 100, null, null);
        Enemy enemy=new Enemy(0, 0, 50, null);
        Bullet enemyBullet = new Bullet(50, Direction.down, enemy.getX(), enemy.getY());
        enemy.setBullet(enemyBullet);

        enemyBullet.setY((enemyBullet.getY()+1)*map.getTileSize());
        Collisions.checkBulletCollision(player, new ArrayList<Enemy>(Arrays.asList(enemy)), map.getWalls());

        assertNull( enemy.getBullet());
        assertEquals(50, enemy.getHealth());
    }
    @Test
    public void test3(){
        MoveParameters moveParameters = new MoveParameters();
        Map map= new Map();
        map.getMapLayout();
        Player player=new Player(map.getTileSize(), map.getTileSize(), 100, null, map);
        map.setPlayer(player);
        moveParameters.setMap(map);
        moveParameters.setE(new KeyEvent(new Component() {}, 0, 0, 0, KeyEvent.VK_RIGHT));
        //System.out.println(moveParameters.getE().getKeyCode());
        player.move(moveParameters);

        assertEquals(2*map.getTileSize(), player.getX());
    }
}
