package workplace;

import workplace.model.GameScreen;
import workplace.model.Map;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int rowCount=30;
        int columnCount=30;
        int tileSize=16;
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