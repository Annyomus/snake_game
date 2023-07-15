import java.awt.*;
import java.util.ArrayList;

public class Snake extends Rectangle {
    ArrayList<Rectangle> segments;

    Snake(){
        int x = 150;
        int y = 150;
        int width = 10;
        int height = 10;
        segments = new ArrayList<Rectangle>();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        Rectangle segment = new Rectangle(x, y, width, height);

        segments.add(segment);


    }
    public void draw(Graphics g){
        for (Rectangle segment : segments) {
            g.setColor(Color.GREEN);
            g.fillRect(segment.x, segment.y, segment.width, segment.height);
        }


    }
}
