package workplace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

@Getter
@Setter

@AllArgsConstructor

public class Wall {
    private Image image;
    private int x;
    private int y;
}
