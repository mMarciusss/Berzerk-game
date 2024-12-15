package workplace.model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardInput extends KeyAdapter {
    private GameScreen gameScreen;
    private Map map;
    private MoveParameters moveParameters;
    private ShootParameters shootParameters;
    KeyboardInput(GameScreen gameScreen, Map map) {
        this.gameScreen = gameScreen;
        this.map = map;
        moveParameters = new MoveParameters();
        moveParameters.setMap(map);
        shootParameters = new ShootParameters();
    }
    @Override
    public void keyPressed(KeyEvent e) {
        moveParameters.setE(e);
        shootParameters.setE(e);
        map.getPlayer().move(moveParameters);
        map.getPlayer().shoot(shootParameters);
    }
}
