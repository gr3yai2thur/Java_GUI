package Lab;

import java.awt.*;

public class L1 extends Frame {
    L1(){
        setTitle("LAB 01");
        setSize(500, 400);
        setLayout(new GridLayout(4, 5));

        for(int i=1; i<=20; i++){
            add(new Button("Button " + i));
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new L1();
    }
}
