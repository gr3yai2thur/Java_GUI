package L1;

import java.util.Random;
import java.awt.Color;
import javax.swing.JLabel;

public class ColorThread extends Thread{;
    private JLabel label;
    private int sleepMin;
    private int sleepMax;

    ColorThread(JLabel label, int sleepMin, int sleepMax){
        this.label = label;
        this.sleepMin = sleepMin;
        this.sleepMax = sleepMax;
    }

    @Override
        public void run(){
            while(true){
                Random rnd = new Random();
                Color c = new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
                label.setBackground(c);
                label.setOpaque(true);
                int delay = (sleepMin + rnd.nextInt(sleepMax - sleepMin + 1));
                try {
                    Thread.sleep(delay);
                } catch (Exception e) { }
            }
        }
}
