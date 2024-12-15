package workplace.model;

import java.awt.*;
import java.util.ArrayList;

public class Rendering {
    private static Player player;
    private static ArrayList<Enemy> enemies;
    private static ArrayList<Wall> walls;

    public static void render (Graphics g, Map map){
        player=map.getPlayer();
        enemies=map.getEnemies();
        walls=map.getWalls();
        paintPlayer(g, map);
        paintEnemies(g, map);
        paintWalls(g, map);
        paintBullets(g, map);
    }

    public static void paintPlayer(Graphics g, Map map) {
        if(player.isAlive())
            g.drawImage(player.getImage(), player.getX(), player.getY(), map.getTileSize(),map.getTileSize(), null);
    }

    public static void paintEnemies(Graphics g, Map map){
        for(ActiveEntity enemy: enemies){
            if(enemy.isAlive()) g.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), map.getTileSize(), map.getTileSize(), null);
        }
    }

    public static void paintWalls(Graphics g, Map map) {
        for(Wall wall : walls) {
            g.drawImage(wall.getImage(), wall.getX(), wall.getY(), map.getTileSize(), map.getTileSize(), null);
        }
    }

    public static void paintBullets(Graphics g, Map map){
        if(player.getBullet()!=null) {
            g.drawImage(player.getBullet().getImage(), player.getBullet().getX(), player.getBullet().getY(), map.getTileSize(), map.getTileSize(), null);
            player.getBullet().moveBullet(player, map);
            Collisions.checkBulletCollision(player, enemies, walls);
        }
        for(Enemy enemy: enemies){
            if(!enemy.isAlive()) {
                //enemies.remove(enemy);
                enemy=null;
                continue;
            }
            if(enemy.getBullet()!=null){
                g.drawImage(enemy.getBullet().getImage(), enemy.getBullet().getX(), enemy.getBullet().getY(), map.getTileSize(), map.getTileSize(), null);
                enemy.getBullet().moveBullet(enemy, map);
                Collisions.checkBulletCollision(player, enemies, walls);
            }
        }
    }
}
