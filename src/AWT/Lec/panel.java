import java.awt.*;

public class panel extends Frame {
    panel(){
        setTitle("Panel");
        setSize(300, 200);
        setLayout(new BorderLayout());

        Panel bottomPanel = new Panel(new FlowLayout()); // Panel มี FlowLayout
        bottomPanel.add(new Button("Apply"));
        bottomPanel.add(new Button("Cancel"));

        add(new TextArea(), BorderLayout.CENTER);
        add(bottomPanel,     BorderLayout.SOUTH);

        setVisible(true);
    }
    public static void main(String[] args) {
        new panel();
    }
}
