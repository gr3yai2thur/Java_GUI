import java.awt.*;

public class layerGrid extends Frame {
    layerGrid(){
        setTitle("Grid Layer");
        setSize(300, 200);
        setLayout(new GridLayout(2, 3));

        add(new Button("1"));
        add(new Button("2"));
        add(new Button("3"));
        add(new Button("4"));
        add(new Button("5"));
        add(new Button("6"));

        setVisible(true);
    }
    public static void main(String[] args) {
        new layerGrid();
    }
}
