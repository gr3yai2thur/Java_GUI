import java.awt.*;

public class layerNull extends Frame {
    layerNull(){
        setTitle("Null layer");
        setSize(300, 200);
        setLayout(null);

        Button btn = new Button("Button");
        btn.setBounds(50, 80, 100, 30);   // x=50, y=80, กว้าง=100, สูง=30
        add(btn);

        Label lbl = new Label("Sign");
        lbl.setBounds(20, 20, 60, 20);
        add(lbl);
        
        setVisible(true);
    }
    public static void main(String[] args) {
        new layerNull();
    }
}
