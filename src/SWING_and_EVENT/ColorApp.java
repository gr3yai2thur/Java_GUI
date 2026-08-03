package SWING_and_EVENT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorApp extends JFrame implements MouseMotionListener{
    JPanel panel;
    TextField tfInfo;

    ColorApp() {
        setTitle("Interactive Color");
        setSize(512, 512);
        setLayout(new BorderLayout());

        tfInfo = new TextField();
        tfInfo.setEditable(false);

        panel = new JPanel();
        panel.setBackground(Color.GRAY);

        add(tfInfo, BorderLayout.NORTH);
        add(panel,  BorderLayout.CENTER);

        panel.addMouseMotionListener(this);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        int r = x / 2;
        int g = y / 2;
        int b = (x = y) / 4;

        panel.setBackground(new Color(r, g, b));
        tfInfo.setText("x=" + x + ", y=" + y + "   r=" + r + " g=" + g + " b=" + b);
    }

    @Override
    public void mouseDragged(MouseEvent e) {}

    public static void main(String[] args) {
        new ColorApp();
    }
}
