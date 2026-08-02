import java.awt.*;

public class layerFlow extends Frame {
    layerFlow(){
        setTitle("Flow Layer");
        setSize(150, 150);
        // setLayout(new FlowLayout()); //default center
        // setLayout(new FlowLayout(FlowLayout.LEFT)); //ชิดซ้าย
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 10)); //ชิดขวา + hgap ช่องว่าง col + vgap ช่องว่าง row
        
        add(new Button("1"));
        add(new Button("2"));
        add(new Button("3"));
        add(new Button("4"));
        add(new Button("5"));
        add(new Button("6"));
        add(new Button("7"));

        setVisible(true);
    }
    public static void main(String[] args) {
        new layerFlow();
    }
}
