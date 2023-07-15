import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    Game(String name, int width, int height){
        Game_panel panel = new Game_panel();
        this.add(panel);
        this.addKeyListener(panel);

        this.setTitle(name);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }



}
