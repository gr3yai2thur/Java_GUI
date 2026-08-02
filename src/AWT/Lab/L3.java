package Lab;

import java.awt.*;
import java.util.Random;

public class L3 extends Frame {
    L3(){
        setTitle("LAB 03");
        setSize(1920, 1080);
        setLayout(null);

        for(int i=1; i<=50; i++){
            Random rnd = new Random();
            int x = rnd.nextInt(1820);
            int y = rnd.nextInt(980);

            Button btn = new Button("Button " + i);
            btn.setBounds(x, y, 100, 50);
            btn.setBackground(randomColor(rnd));
            add(btn);
        }

        setVisible(true);
    }

    public Color randomColor(Random rnd) {
        int r = rnd.nextInt(256);
        int g = rnd.nextInt(256);
        int b = rnd.nextInt(256);
        return new Color(r, g, b);
    }
    public static void main(String[] args) {
        new L3();
    }
}
