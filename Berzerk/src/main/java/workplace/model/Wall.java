package workplace.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter

@AllArgsConstructor

public class Wall {
    private Image image;
    private int x;
    private int y;

    public Wall(int x, int y) {
        image = Parameters.WALL_IMAGE;
        this.x = x;
        this.y = y;
    }
}
