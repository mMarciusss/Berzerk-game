package workplace.model;

import javax.swing.*;
import java.awt.*;

public class Parameters {
    public static final int PLAYER_HEALTH=100;
    public static final int ENEMY_HEALTH=50;
    public static final int PLAYER_BULLET_DAMAGE=50;
    public static final int ENEMY_BULLET_DAMAGE=50;
    public static final int DEATH_THRESHOLD=0;

    public static final int TIMER_DELAY=250;

    public static final int ROW_COUNT=30;
    public static final int COLUMN_COUNT=30;
    public static final int TILE_SIZE=16;

    public static final Image ENEMY_IMAGE_RIGHT= new ImageIcon(Parameters.class.getResource("/images/EnemyRight.png")).getImage();
    public static final Image ENEMY_IMAGE_LEFT= new ImageIcon(Parameters.class.getResource("/images/EnemyLeft.png")).getImage();
    public static final Image PLAYER_IMAGE_RIGHT= new ImageIcon(Parameters.class.getResource("/images/PlayerRight2.png")).getImage();
    public static final Image PLAYER_IMAGE_LEFT= new ImageIcon(Parameters.class.getResource("/images/PlayerLeft2.png")).getImage();
    public static final Image BULLET_IMAGE= new ImageIcon(Parameters.class.getResource("/images/Bullet.png")).getImage();
    public static final Image WALL_IMAGE= new ImageIcon(Parameters.class.getResource("/images/Wall.png")).getImage();

    public static final String[] MAP={
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
}
