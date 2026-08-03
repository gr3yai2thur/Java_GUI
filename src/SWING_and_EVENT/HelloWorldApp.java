package SWING_and_EVENT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloWorldApp extends JFrame {
    TextField tf;
    Button btn;

    HelloWorldApp() {
        setTitle("");
        setSize(400, 300);
        setLayout(new FlowLayout());   // เพิ่ม layout

        tf = new TextField(20);
        btn = new Button("Click!");

        btn.addActionListener(e -> {
            setTitle("Hello World!!");
            tf.setText("Hello World!!");
        });

        add(tf);     // เพิ่มบรรทัดนี้
        add(btn);    // เพิ่มบรรทัดนี้

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }

    public static void main(String[] args) {
        new HelloWorldApp();
    }
}