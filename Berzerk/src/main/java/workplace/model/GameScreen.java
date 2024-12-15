package workplace.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameScreen extends JPanel implements ActionListener {
    private Map map;
    private Timer timer;
    private Random random;
    private MoveParameters moveParameters;
    private ShootParameters shootParameters;

    public GameScreen() {
        random=new Random();
        map = new Map();
        addKeyListener(new KeyboardInput(this, map));
        map.getMapLayout();
        shootParameters=new ShootParameters();
        moveParameters=new MoveParameters();
        shootParameters.setPlayer(map.getPlayer());
        moveParameters.setRandom(random);
        moveParameters.setMap(map);
        setFocusable(true);
        requestFocusInWindow();
        setPreferredSize(new Dimension(map.getBoardWidth(),map.getBoardHeight()));
        setBackground(Color.BLACK);
        timer = new Timer(Parameters.TIMER_DELAY,this);
        timer.start();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if(map.getPlayer().isAlive()){
            for(Enemy enemy: map.getEnemies()){
                enemy.move(moveParameters);
                enemy.shoot(shootParameters);
            }
            Rendering.render(g, map);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
