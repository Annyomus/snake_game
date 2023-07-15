import java.awt.*;
import java.util.Random;
public class Apple extends Rectangle {
    Apple(){
        Random random = new Random();
        int x = random.nextInt(0, 28) * 10;
        int y = random.nextInt(0, 27) * 10;
        int width = 10;
        int height = 10;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;

    }
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }
}
