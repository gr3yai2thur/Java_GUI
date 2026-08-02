import java.awt.*;

public class layerBorder extends Frame {
    layerBorder(){
        setTitle("layerBorder");
        setSize(1600, 900);
        setLayout(new BorderLayout());

        add(new Button("North"),    BorderLayout.NORTH);
        add(new Button("South"),    BorderLayout.SOUTH);
        add(new Button("East"),     BorderLayout.EAST);
        add(new Button("West"),     BorderLayout.WEST);
        add(new Button("Center"),   BorderLayout.CENTER);

        setVisible(true);
    }
    public static void main(String[] args) {
        new layerBorder();
    }
}
