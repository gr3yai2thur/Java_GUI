import java.awt.*;

public class LoginForm extends Frame {

    LoginForm() {
        setTitle("Login Form");
        setSize(300, 200);
        setLayout(new BorderLayout());

        // Labels
        Label lblUser = new Label("Username:");
        lblUser.setBounds(20, 50, 80, 25);

        Label lblPass = new Label("Password:");
        lblPass.setBounds(20, 90, 80, 25);

        // TextFields
        TextField tfUser = new TextField();
        tfUser.setBounds(110, 50, 150, 25);

        TextField tfPass = new TextField();
        tfPass.setEchoChar('*');     // ซ่อนข้อความ (สำหรับรหัสผ่าน)
        tfPass.setBounds(110, 90, 150, 25);

        // Button
        Button btnLogin = new Button("Login");
        btnLogin.setBounds(100, 130, 100, 30);

        // เพิ่มเข้า Frame
        add(lblUser); add(tfUser);
        add(lblPass); add(tfPass);
        add(btnLogin);

        setVisible(true);
    }

    public static void main(String[] args) {
         new LoginForm(); 
    }
}