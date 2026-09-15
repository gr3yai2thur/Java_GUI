package L2;

import java.util.Random;
import javax.swing.JLabel;

public class LetterThread extends Thread{
    private JLabel label;
    private int x;
    private int maxY;
    public boolean running = true;

    LetterThread(JLabel label, int x, int maxY){
        this.label = label;
        this.x = x;
        this.maxY = maxY;
    }

    LetterThread(){}

    @Override
    public void run(){
        Random rnd = new Random();
        int y = 0;
        int speed = rnd.nextInt(5) + 1;

        while(true){
            while (running) {
                y += speed;
                label.setLocation(x, y);
    
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) { }
    
                if (y > maxY) {
                    y = 0;
                    speed = rnd.nextInt(5) + 1;
                }
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) { }
        }
    }

}
