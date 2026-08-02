import java.awt.*;

public class color extends Frame {
    color(){
        setTitle("Color");
        setSize(300, 200);
        setLayout(new GridLayout(2, 3));

        Button b1 = new Button("1");
        Button b2 = new Button("2");
        Button b3 = new Button("3");
        Button b4 = new Button("4");
        Button b5 = new Button("5");
        Button b6 = new Button("6");


        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int b = (int)(Math.random() * 256);

        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);
        b3.setForeground(Color.WHITE);
        b4.setForeground(Color.WHITE);
        b5.setForeground(Color.WHITE);
        b6.setForeground(Color.WHITE);

        b1.setBackground(randomColor());
        b2.setBackground(randomColor());
        b3.setBackground(randomColor());
        b4.setBackground(randomColor());
        b5.setBackground(randomColor());
        b6.setBackground(randomColor());

        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);

        setVisible(true);
    }

    public Color randomColor() {
        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int b = (int)(Math.random() * 256);
        return new Color(r, g, b);
    }

    public static void main(String[] args) {
        new color();
    }
}
