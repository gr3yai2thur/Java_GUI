package SWING_and_EVENT;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class cal extends JFrame implements ActionListener{

    TextField tfA, tfB, tfResult;
    Button btnAdd, btnSub, btnMul, btnDiv;
    JPanel operator, calcu;
    cal(){
        setTitle("Calculator by Husky");
        setSize(400,150);
        setLayout(new BorderLayout());
        
        operator = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        calcu = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));

        tfA      = new TextField(8);
        tfB      = new TextField(8);
        tfResult = new TextField(10);
        tfResult.setEditable(false);

        calcu.add(tfA);
        calcu.add(tfB);

        btnAdd = new Button("+");
        btnSub = new Button("-");
        btnMul = new Button("x");
        btnDiv = new Button("÷");

        operator.add(btnAdd);
        operator.add(btnSub);
        operator.add(btnMul);
        operator.add(btnDiv);

        add(calcu, BorderLayout.CENTER);
        add(operator, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // btnAdd.addActionListener(e -> calculate('+'));
        // btnSub.addActionListener(e -> calculate('-'));
        // btnMul.addActionListener(e -> calculate('x'));
        // btnDiv.addActionListener(e -> calculate('÷'));

        btnAdd.addActionListener(this);
        btnSub.addActionListener(this);
        btnMul.addActionListener(this);
        btnDiv.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double a = Double.parseDouble(tfA.getText());
        double b = Double.parseDouble(tfB.getText());
        double result = 0;

        if (e.getSource() == btnAdd) result = a + b;
        else if (e.getSource() == btnSub) result = a - b;
        else if (e.getSource() == btnMul) result = a * b;
        else if (e.getSource() == btnDiv) result = a / b;

        JFrame popup = new JFrame();
        popup.setTitle("Result");
        popup.setSize(400, 300);
        popup.setLayout(new FlowLayout());
        popup.add(new Label("resule: "));
        tfResult.setText(String.valueOf(result));
        popup.add(tfResult);

        popup.setVisible(true);
    }

    // public void calculate(char op) {
    //     double a = Double.parseDouble(tfA.getText());
    //     double b = Double.parseDouble(tfB.getText());
    //     double result = 0;

    //     switch (op) {
    //         case '+': result = a + b; break;
    //         case '-': result = a - b; break;
    //         case 'x': result = a * b; break;
    //         case '÷': result = a / b; break;
    //     }

    //     tfResult.setText(String.valueOf(result));
    // }

    public static void main(String[] args) {
        new cal();
    }
}
