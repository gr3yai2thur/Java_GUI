import java.awt.*;

public class StyledApp extends Frame {

    StyledApp() {
        setTitle("Styled App");
        setSize(350, 250);
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        // Label — ใหญ่ หนา สีน้ำเงิน
        Label title = new Label("Member System", Label.CENTER);
        title.setFont(new Font("Tahoma", Font.BOLD, 22));
        title.setForeground(new Color(0, 102, 204));

        // TextField — มีขนาด
        TextField tfName = new TextField(20);
        tfName.setFont(new Font("Arial", Font.PLAIN, 14));
        tfName.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));

        // Button — สีเขียว ตัวอักษรขาว มือเมาส์
        Button btnSave = new Button("Submit");
        btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnSave.setBackground(new Color(40, 167, 69));
        btnSave.setForeground(Color.WHITE);
        btnSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        add(title);
        add(new Label("Name:"));
        add(tfName);
        add(btnSave);

        setVisible(true);
    }

    public static void main(String[] args) { new StyledApp(); }
}