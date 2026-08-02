import java.awt.*;

public class cursor extends Frame {
    cursor(){
        setTitle("Cursor");
        setSize(300, 200);
        setLayout(new FlowLayout());

        Button btn = new Button("Click me");
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        // เมื่อเมาส์เลื่อนเหนือปุ่ม → เคอร์เซอร์เปลี่ยนเป็นมือชี้

        TextField tf = new TextField();
        tf.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

        add(btn);
        add(tf);

        setVisible(true);
    }

    public static void main(String[] args) {
        new cursor();
    }
}
