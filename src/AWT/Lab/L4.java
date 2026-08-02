package Lab;

import java.awt.*;

public class L4 extends Frame{
    L4(){
        int fW = 400;  int fH = 300;
        int tfW = 200; int tfH = 30;
        int btnW = 100; int btnH = 30;

        setTitle("LAB 03");
        setSize(fW, fH);
        setLayout(null);

        int tfX = (fW - tfW) / 2;
        TextField tf = new TextField();
        tf.setBounds(tfX, 50, tfW, tfH);

        int btnX = (fW - btnW) / 2;
        Button btn = new Button("Submit");
        btn.setBounds(btnX, 100, btnW, btnH);

        add(tf);
        add(btn);

        setVisible(true);
    }

    public static void main(String[] args) {
        new L4();
    }
}
