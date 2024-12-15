package workplace.model;

import lombok.Getter;
import lombok.Setter;

import java.awt.event.KeyEvent;
import java.util.Random;

@Getter
@Setter

public class MoveParameters {
    private Map map;
    private Random random;
    private KeyEvent e;
}
