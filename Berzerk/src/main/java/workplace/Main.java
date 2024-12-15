package workplace;

import workplace.model.GameScreen;
import workplace.model.Parameters;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int rowCount= Parameters.ROW_COUNT;
        int columnCount=Parameters.COLUMN_COUNT;
        int tileSize=Parameters.TILE_SIZE;
        int boardWidth=tileSize*columnCount;
        int boardHeight=tileSize*rowCount;

        JFrame frame=new JFrame("Berzerk");
        frame.setSize(boardWidth,boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GameScreen gameScreen=new GameScreen();
        frame.add(gameScreen);
        frame.pack();
        frame.setVisible(true);
    }
}