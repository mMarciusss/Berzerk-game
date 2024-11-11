package workplace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class Bullet {
    private Image image;
    private int x;
    private int y;
    private int direction;
//    private int targetX;
//    private int targetY;
}
