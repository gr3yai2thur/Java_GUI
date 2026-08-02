import java.awt.*;

public class font extends Frame {
    font(){
        setTitle("Font");
        setSize(300, 200);
        setLayout(new FlowLayout());

        Label  lbl = new Label("Hello!");
        Button btn = new Button("Click");

        lbl.setFont(new Font("Tahoma", Font.BOLD, 20));
        btn.setFont(new Font("Arial",  Font.PLAIN, 14));

        add(lbl);
        add(btn);

        setVisible(true);
    }

    public static void main(String[] args) {
        new font();
    }
}
