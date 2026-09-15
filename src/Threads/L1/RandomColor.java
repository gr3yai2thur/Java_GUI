package L1;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RandomColor extends JFrame{
    JLabel lbl1;
    JLabel lbl2;
    JLabel lbl3;
    JLabel lbl4;

    RandomColor(){
        setSize(400,400);
        setLayout(new GridLayout(2,2,10,10));

        JLabel lbl1 = new JLabel();
        JLabel lbl2 = new JLabel();
        JLabel lbl3 = new JLabel();
        JLabel lbl4 = new JLabel();

        ColorThread thread1 = new ColorThread(lbl1, 5000, 5000);
        ColorThread thread2 = new ColorThread(lbl2, 10000, 10000);
        ColorThread thread3 = new ColorThread(lbl3, 1000, 5000);
        ColorThread thread4 = new ColorThread(lbl4, 5000, 10000);

        add(lbl1);
        add(lbl2);
        add(lbl3);
        add(lbl4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);
    }
    public static void main(String[] args) {
        new RandomColor();
    }
}
