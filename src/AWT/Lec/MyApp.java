import java.awt.*;

public class MyApp extends Frame {
    MyApp() {
        setTitle("My App");
        setSize(300, 200);
        setLayout(null);

        Button button = new Button("Click Me");
        button.setBounds(50, 50, 100, 40);
        add(button);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MyApp();
    }
}
