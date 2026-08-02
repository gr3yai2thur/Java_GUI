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
            int x = rnd.nextInt(1850);
            int y = rnd.nextInt(1000);

            Button btn = new Button("Button " + i);
            btn.setBounds(x, y, 100, 50);
            btn.setBackground(randomColor());
            add(btn);
        }

        setVisible(true);
    }

    public Color randomColor() {
        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int b = (int)(Math.random() * 256);
        return new Color(r, g, b);
    }
    public static void main(String[] args) {
        new L3();
    }
}
