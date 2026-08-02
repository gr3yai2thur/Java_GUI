package PM2_5;

import java.awt.*;
import java.io.*;
import java.util.Random;

public class pm25 extends Frame {
    pm25(){
        setTitle("PM2.5 Work");
        setSize(1600, 900);
        setLayout(new GridLayout(40, 20));

        Random rnd = new Random();
        for(int i=1; i<=20; i++){
            for(int j=1; j<=40; j++){
                int x = rnd.nextInt(250);
                Button btn = new Button();
        
                if(x <= 50)       btn.setBackground(Color.GREEN);
                else if(x <= 100) btn.setBackground(Color.YELLOW);
                else if(x <= 150) btn.setBackground(Color.ORANGE);
                else              btn.setBackground(Color.RED);
        
                add(btn);
            }
        }
        setVisible(true);
    }

    public static void main(String[] args) {
        new pm25();
    }
}
