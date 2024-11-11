package workplace.model;

import lombok.Getter;
import lombok.Setter;

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
    private ActiveEntity player;
    private List <ActiveEntity> enemies;
    private List <Wall> walls;
    private String[] map={
            "##############################",
            "#              #             #",
            "#              #             #",
            "#              #             #",
            "#     e        #      e      #",
            "#              #             #",
            "#              #             #",
            "#              #             #",
            "#              #             #",
            "#              #             #",
            "#                            #",
            "#                            #",
            "########    ######   #       #",
            "#           #        #       #",
            "#           #        #       #",
            "#           #    e   ####    #",
            "#    p      #        #       #",
            "#       ##############       #",
            "#                    #       #",
            "#                    #       #",
            "#                    #    ####",
            "#           #        #       #",
            "#           #        #       #",
            "#############                #",
            "#           #                #",
            "#           #         e      #",
            "#      e                     #",
            "#                            #",
            "#                            #",
            "##############################"
    };

    public Map() {
        rowCount=30;
        columnCount=30;
        tileSize=16;
        boardWidth=tileSize*columnCount;
        boardHeight=tileSize*rowCount;
        player=new ActiveEntity();
        enemies= new ArrayList<ActiveEntity>();
        walls= new ArrayList<Wall>();
    }
    public void getMapLayout() {
        Image wallImage= new ImageIcon(getClass().getResource("/images/Wall.png")).getImage();
        Image enemyImage= new ImageIcon(getClass().getResource("/images/EnemyRight.png")).getImage();
        Image playerImage= new ImageIcon(getClass().getResource("/images/PlayerRight2.png")).getImage();
        for(int y=0;y<rowCount;y++){
            for(int x=0;x<columnCount;x++){
                String row= map[y];
                char ch=row.charAt(x);
                if(ch=='#'){
                    walls.add(new Wall(wallImage, x*tileSize, y*tileSize));
                }
                else if(ch=='e'){
                    enemies.add(new ActiveEntity(enemyImage, x*tileSize, y*tileSize, 50, 50, null));
                }
                else if(ch=='p'){
                    player= new ActiveEntity(playerImage, x*tileSize, y*tileSize, 150, 50, null);
                }
            }
        }
    }
}
