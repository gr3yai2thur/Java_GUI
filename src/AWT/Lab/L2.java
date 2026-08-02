package Lab;

import java.awt.*;

public class L2 extends Frame{
    L2(){
        setTitle("LAB 02");
        setSize(700, 600);
        setLayout(new GridLayout(10, 4));

        for(int i=1; i<=20; i++){
            add(new Button("Button " + i));
            add(new TextArea("TextArea " + i));
        }

        setVisible(true);
    }
    public static void main(String[] args) {
        new L2();
    }
}
