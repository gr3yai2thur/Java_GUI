import java.awt.*;

public class textF extends Frame {
    textF() {
        setTitle("My App");
        setSize(300, 200);
        setLayout(null);

        // TextField tf1 = new TextField();
        // TextField tf2 = new TextField("Default Text");
        // TextField tf3 = new TextField(20);

        // tf1.setBounds(50, 50, 150, 25);
        // tf2.setBounds(50, 75, 150, 25);
        // tf3.setBounds(50, 100, 150, 25);

        // TextArea tA = new TextArea("", 5, 20, TextArea.SCROLLBARS_NONE);
        // tA.setBounds(50, 50, 200, 120);

        Label lbl1 = new Label("ชื่อ:");                           // ชิดซ้าย (default)
        Label lbl2 = new Label("สวัสดี!", Label.CENTER);           // กึ่งกลาง
        Label lbl3 = new Label("ขวา", Label.RIGHT);              // ชิดขวา

        lbl1.setBounds(50, 50, 200, 100);
        lbl2.setBounds(50, 75, 200, 100);
        lbl3.setBounds(50, 100, 200, 100);

        
        add(lbl1);
        add(lbl2);
        add(lbl3);

        // add(tf1);
        // add(tf2);
        // add(tf3);
        // add(tA);

        setVisible(true);
    }

    public static void main(String[] args) {
        new textF();
    }
}
