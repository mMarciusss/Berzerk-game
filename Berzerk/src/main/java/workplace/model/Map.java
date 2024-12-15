package workplace.model;

import lombok.Getter;
import lombok.Setter;
import workplace.Enums.Direction;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@Getter
@Setter

public class Map extends JPanel {
    private int rowCount;
    private int columnCount;
    private int tileSize;
    private int boardWidth;
    private int boardHeight;
    private Player player;
    private ArrayList <Enemy> enemies;
    private ArrayList <Wall> walls;
    private Bullet playerBullet;
    private Bullet enemyBullet;
    private Image enemyImage;
    private Image playerImage;
    private String[] map=Parameters.MAP;

    public Map() {
        rowCount=Parameters.ROW_COUNT;
        columnCount=Parameters.COLUMN_COUNT;
        tileSize=Parameters.TILE_SIZE;
        boardWidth=tileSize*columnCount;
        boardHeight=tileSize*rowCount;
        player=new Player();
        enemies= new ArrayList<Enemy>();
        walls= new ArrayList<Wall>();
        playerBullet=new Bullet();
    }
    public void getMapLayout() {
        for(int y=0;y<rowCount;y++){
            for(int x=0;x<columnCount;x++){
                String row= map[y];
                char ch=row.charAt(x);
                if(ch=='#'){
                    walls.add(ObjectFactory.createWall(x*tileSize, y*tileSize));
                }
                else if(ch=='e'){
                    enemies.add(ObjectFactory.createEnemy(x*tileSize, y*tileSize, Parameters.ENEMY_HEALTH, null));
                }
                else if(ch=='p'){
                    player= ObjectFactory.createPlayer(x*tileSize, y*tileSize, Parameters.PLAYER_HEALTH, null, this);
                }
            }
        }
    }
}
