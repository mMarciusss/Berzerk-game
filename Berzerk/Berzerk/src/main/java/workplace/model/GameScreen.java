package workplace.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class GameScreen extends JPanel implements ActionListener{
    Map map;
    ActiveEntity player;
    ArrayList<ActiveEntity> enemies;
    ArrayList<Wall> walls;
    Timer timer;
    int direction;
    int enemyDirection;
    Random random=new Random();
    Image bulletImage= new ImageIcon(getClass().getResource("/images/Bullet.png")).getImage();
    public GameScreen() {
        addKeyListener(new KeyboardInput(this));
        map=new Map();
        map.getMapLayout();
        setFocusable(true);
        requestFocusInWindow();
        player = map.getPlayer();
        enemies= (ArrayList<ActiveEntity>) map.getEnemies();
        walls= (ArrayList<Wall>) map.getWalls();
        setPreferredSize(new Dimension(map.getBoardWidth(), map.getBoardHeight()));
        setBackground(Color.black);
        timer = new Timer(200, this);
        timer.start();
    }
    public void paintMap(Graphics g) {
        g.drawImage(player.getImage(), player.getX(), player.getY(), map.getTileSize(),map.getTileSize(), this);
        if(!player.isAlive()) player=null;
        for(Wall wall : walls) {
            g.drawImage(wall.getImage(), wall.getX(), wall.getY(), map.getTileSize(), map.getTileSize(), null);
        }
        for(ActiveEntity enemy: enemies) {
            if(!enemy.isAlive()) enemy=null;
            if(enemy!=null)g.drawImage(enemy.getImage(), enemy.getX(), enemy.getY(), map.getTileSize(), map.getTileSize(), null);
        }
        enemies.remove(enemies.contains(null));
    }
    public void paintBullets(Graphics g){
        if(player.getBullet()!=null) {
            g.drawImage(player.getBullet().getImage(), player.getBullet().getX(), player.getBullet().getY(), map.getTileSize(), map.getTileSize(), null);
            if(player.getBullet().getDirection()==0)player.getBullet().setX(player.getBullet().getX()+map.getTileSize());//right
            if(player.getBullet().getDirection()==1)player.getBullet().setX(player.getBullet().getX()-map.getTileSize());//left
            if(player.getBullet().getDirection()==2)player.getBullet().setY(player.getBullet().getY()-map.getTileSize());//up
            if(player.getBullet().getDirection()==3)player.getBullet().setY(player.getBullet().getY()+map.getTileSize());//down
            checkBulletCollision();
        }
        for(ActiveEntity enemy: enemies){
            enemyShootDirection(enemy, g);
            if(enemy.getBullet()!=null){
                g.drawImage(enemy.getBullet().getImage(), enemy.getBullet().getX(), enemy.getBullet().getY(), map.getTileSize(), map.getTileSize(), null);
                if(enemy.getBullet().getDirection()==0)enemy.getBullet().setX(enemy.getBullet().getX()+map.getTileSize());//right
                if(enemy.getBullet().getDirection()==1)enemy.getBullet().setX(enemy.getBullet().getX()-map.getTileSize());//left
                if(enemy.getBullet().getDirection()==2)enemy.getBullet().setY(enemy.getBullet().getY()-map.getTileSize());//up
                if(enemy.getBullet().getDirection()==3)enemy.getBullet().setY(enemy.getBullet().getY()+map.getTileSize());//down
                checkBulletCollision();
            }
        }
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(player.isAlive()) {
            moveEnemy();
            paintMap(g);
            paintBullets(g);
        }
    }
    public void checkBulletCollision() {
        if(player.getBullet()!=null) {
            for (ActiveEntity enemy : enemies) {
                if (player.getBullet().getX() == enemy.getX() && player.getBullet().getY() == enemy.getY()) {
                    enemy.takeDamage(player.getDamage());
                    player.setBullet(null);
                    return;
                }
            }
        }
        for(ActiveEntity enemy: enemies){
            if(enemy.getBullet()!=null) {
                if (enemy.getBullet().getX() == player.getX() && enemy.getBullet().getY() == player.getY()) {
                    player.takeDamage(enemy.getDamage());
                    enemy.setBullet(null);
                    return;
                }
            }
        }
        for(Wall wall: walls) {
            if(player.getBullet()!=null) {
                if (player.getBullet().getX() == wall.getX() && player.getBullet().getY() == wall.getY()) {
                    player.setBullet(null);
                }
            }
            for(ActiveEntity enemy: enemies) {
                if(enemy.getBullet()!=null) {
                    if (enemy.getBullet().getX() == wall.getX() && enemy.getBullet().getY() == wall.getY()) {
                        enemy.setBullet(null);
                        return;
                    }
                }
            }
        }
    }
    public void enemyShootDirection(ActiveEntity enemy, Graphics g) {
        if(enemy.getBullet()==null) {
            if (player.getX() == enemy.getX()) {
                if (player.getY() > enemy.getY()) {
                    enemyDirection = 3;
                    enemy.setBullet(new Bullet(bulletImage, enemy.getX(), enemy.getY(), enemyDirection));
//                    g.drawImage(enemy.getBullet().getImage(), enemy.getBullet().getX(), enemy.getBullet().getY(), map.getTileSize(), map.getTileSize(), null);
//                    enemy.getBullet().setY(enemy.getBullet().getY()+map.getTileSize());
                } else if (player.getY() < enemy.getY()) {
                    enemyDirection = 2;
                    enemy.setBullet(new Bullet(bulletImage, enemy.getX(), enemy.getY(), enemyDirection));
//                    g.drawImage(enemy.getBullet().getImage(), enemy.getBullet().getX(), enemy.getBullet().getY(), map.getTileSize(), map.getTileSize(), null);
//                    enemy.getBullet().setY(enemy.getBullet().getY()-map.getTileSize());
                }
            } else if (player.getY() == enemy.getY()) {
                if (player.getX() > enemy.getX()) {
                    enemyDirection = 0;
                    enemy.setBullet(new Bullet(bulletImage, enemy.getX(), enemy.getY(), enemyDirection));
                } else if (player.getX() < enemy.getX()) {
                    enemyDirection = 1;
                    enemy.setBullet(new Bullet(bulletImage, enemy.getX(), enemy.getY(), enemyDirection));
                }
            }
        }
    }
    public void moveEnemy() {
        for(ActiveEntity enemy: enemies) {
            switch(random.nextInt(4)){
                case 0:
                    for(Wall wall: walls) {
                        if(enemy.getX()+map.getTileSize()==wall.getX() && enemy.getY()==wall.getY()) { // tikrina ar paejus i desine viena blokeli nebus sutitkta siena
                            return;
                        }
                    }
                    enemy.setX(enemy.getX()+map.getTileSize());
                    break;
                case 1:
                    for(Wall wall: walls) {
                        if(enemy.getX()-map.getTileSize()==wall.getX() && enemy.getY()==wall.getY()) {
                            return;
                        }
                    }
                    enemy.setX(enemy.getX()-map.getTileSize());
                    break;
                case 2:
                    for(Wall wall: walls) {
                        if(enemy.getX()==wall.getX() && enemy.getY()+map.getTileSize()==wall.getY()) {
                            return;
                        }
                    }
                    enemy.setY(enemy.getY()+map.getTileSize());
                    break;
                case 3:
                    for(Wall wall: walls) {
                        if(enemy.getX()==wall.getX() && enemy.getY()-map.getTileSize()==wall.getY()) {
                            return;
                        }
                    }
                    enemy.setY(enemy.getY()-map.getTileSize());
                    break;
            }
        }
    }
    public void keyPressed(KeyEvent e) {
        int key=e.getKeyCode();
        if(key==KeyEvent.VK_RIGHT){
            for(Wall wall: walls) {
                if(player.getX()+map.getTileSize()==wall.getX() && player.getY()==wall.getY()) { // tikrina ar paejus i desine viena blokeli nebus sutitkta siena
                    return;
                }
            }
            direction=0;
            player.setX(player.getX()+map.getTileSize());
            player.setImage(new ImageIcon(getClass().getResource("/images/PlayerRight2.png")).getImage());
        }
        if(key==KeyEvent.VK_LEFT){
            for(Wall wall: walls) {
                if(player.getX()-map.getTileSize()==wall.getX() && player.getY()==wall.getY()) {
                    return;
                }
            }
            direction=1;
            player.setX(player.getX()-map.getTileSize());
            player.setImage(new ImageIcon(getClass().getResource("/images/PlayerLeft2.png")).getImage());
        }
        if(key==KeyEvent.VK_UP){
            for(Wall wall: walls) {
                if(player.getX()==wall.getX() && player.getY()-map.getTileSize()==wall.getY()) {
                    return;
                }
            }
            direction=2;
            player.setY(player.getY()-map.getTileSize());
        }
        if(key==KeyEvent.VK_DOWN){
            for(Wall wall: walls) {
                if(player.getX()==wall.getX() && player.getY()+map.getTileSize()==wall.getY()) {
                    return;
                }
            }
            direction=3;
            player.setY(player.getY()+map.getTileSize());
        }
        if(key==KeyEvent.VK_E){
            player.setBullet(new Bullet(bulletImage, player.getX(), player.getY(), direction));
        }
    }
//    public void keyReleased(KeyEvent e) {
//
//    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
