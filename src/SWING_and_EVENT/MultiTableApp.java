package SWING_and_EVENT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MultiTableApp extends JFrame{
    TextField tf;
    TextArea ta;
    Button btn;

    MultiTableApp(){
        setTitle("Multi Table");
        setSize(300, 800);
        setLayout(new FlowLayout());

        tf  = new TextField(5);
        ta  = new TextArea(12, 30);
        btn = new Button("Show");
        ta.setEditable(false);

        add(new Label("Multiply:"));
        add(tf);
        add(btn);
        add(ta);

        btn.addActionListener(e -> {
            try {
                int num = Integer.parseInt(tf.getText());
                StringBuilder sb = new StringBuilder();
                for(int i=1; i<=12; i++){
                    sb.append(num + " x " + i + " = " + (num * i) + "\n");
                }
                ta.setText(sb.toString());
            } catch (Exception err) {
                ta.setText("Input Only Num!!");
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MultiTableApp();
    }
}
