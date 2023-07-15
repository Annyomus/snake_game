import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;
import java.lang.Thread;

public class Game_panel extends JPanel implements KeyListener {
    Apple apple;
    Snake snake;
    ArrayList<Integer> Keys;

    Game_panel(){
        this.setBackground(Color.YELLOW);
        apple = new Apple();
        snake = new Snake();
        Keys = new ArrayList<>();
        Keys.add(87);
        this.addKeyListener(this);
        this.timer.setRepeats(true);
        this.timer.start();
    }

    Timer timer = new Timer(30, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            held_movement(e);
            try {
                intersection();
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            repaint();

        }
    });

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        for (int i = 0; i < getWidth(); i += 10) {
            g.drawLine(i, 0, i, getHeight());
            g.drawLine(0, i, getWidth(), i);
        }
        apple.draw(g);
        snake.draw(g);

    }



    @Override
    public void keyPressed(KeyEvent e) {
        Snake_movement(e);

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }



    public void Snake_movement(KeyEvent e){
        if(e.getKeyCode() == 'W' && Keys.get(0) != 'S'){
            Keys.remove(0);
            Keys.add(87);
        }
        if(e.getKeyCode() == 'S' && Keys.get(0) != 'W'){
            Keys.remove(0);
            Keys.add(83);
        }
        if(e.getKeyCode() == 'A' && Keys.get(0) != 'D'){
            Keys.remove(0);
            Keys.add(65);
        }
        if(e.getKeyCode() == 'D' && Keys.get(0) != 'A'){
            Keys.remove(0);
            Keys.add(68);
        }


        }
    public void held_movement(ActionEvent e){
        Rectangle current = this.snake.segments.get(0);
        int size = this.snake.segments.size();
        System.out.println(snake.segments);
        if (Keys.get(0) == 87){
            current.y -= 10;
        }
        if (Keys.get(0) == 83){
            current.y += 10;
        }
        if(Keys.get(0) == 65){
            current.x -= 10;
        }
        if(Keys.get(0) == 68){
            current.x += 10;
        }
        for (int i = size - 1; i > 0; i--) {
            Rectangle currentSegment = snake.segments.get(i);
            Rectangle previousSegment = snake.segments.get(i - 1);
            currentSegment.x = previousSegment.x;
            currentSegment.y = previousSegment.y;
        }

    }
    public void intersection() throws InterruptedException {
        Rectangle current = this.snake.segments.get(0);
        int size = this.snake.segments.size();

        if(current.intersects(this.apple)){
            setApple();
        }
        for (int i = size - 1; i > 0; i--) {
            Rectangle currentSegment = snake.segments.get(i);
            Rectangle previousSegment = snake.segments.get(i - 1);

            if(current.intersects(currentSegment)){
                if(currentSegment != snake.segments.get(0) && currentSegment != snake.segments.get(1) ){
                    System.out.println(size);
                    timer.stop();
                }

            }
        }
    }
    public void setApple()  {
        Random random = new Random();
        increase_size();
        this.apple.x = random.nextInt(0, 26) * 10;
        this.apple.y = random.nextInt(0, 26) * 10;

    }
    public void increase_size() {

        this.snake.segments.add(new Rectangle(apple.x, apple.y, 10, 10));
    }

}
