package workplace.model;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyboardInput extends KeyAdapter {
    private GameScreen gameScreen;
    KeyboardInput(GameScreen gameScreen) {
        this.gameScreen = gameScreen;
    }
    public void keyPressed(KeyEvent e) {
        gameScreen.keyPressed(e);
    }
//    public void keyReleased(KeyEvent e) {
//        gameScreen.keyReleased(e);
//    }
}
