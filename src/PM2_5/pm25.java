package PM2_5;

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class pm25 extends JFrame {
    pm25() {
        installComponents();
    }

    public void installComponents() {
        setTitle("PM2.5 Work");
        setSize(1600, 900);
        setLayout(new BorderLayout());

        JPanel table = new JPanel(new GridLayout(20, 40));
        JPanel data = new JPanel(new FlowLayout(FlowLayout.CENTER, 100, 30));
        data.setPreferredSize(new Dimension(200, 900));
        readFile(table);
        userInterface(data);
        add(table, BorderLayout.CENTER);
        add(data, BorderLayout.WEST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void readFile(JPanel table) {
        try (BufferedReader bfr = new BufferedReader(
                new FileReader("C:\\Java_GUI\\src\\AWT\\PM2_5\\pm2.5_69.txt"))) {

            String line;
            while ((line = bfr.readLine()) != null) {
                String[] tokens = parseLine(line);
                setColor(tokens, table);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String[] parseLine(String line) {
        return line.trim().split("\\s+");
    }

    public void setColor(String[] msg, JPanel table) {
        for (String value : msg) {
            JButton btn = createTableButton(value);
            table.add(btn);
        }
    }

    public JButton createTableButton(String value) {
        int x = Integer.parseInt(value);
        JButton btn = new JButton(value);
        btn.setBackground(getColorByValue(x));
        btn.setMargin(new Insets(0, 0, 0, 0));

        return btn;
    }

    public Color getColorByValue(int x) {
        if (x <= 50)       return Color.GREEN;
        else if (x <= 100) return Color.YELLOW;
        else if (x <= 150) return Color.ORANGE;
        else               return Color.RED;
    }

    public void userInterface(JPanel data){
        JButton people = new JButton("Sum People");
        JButton pseudoRain = new JButton("Pseudo Rain");

        people.setSize(200, 100);
        data.add(people);
        pseudoRain.setSize(200, 100);
        data.add(pseudoRain);
    }

    public static void main(String[] args) {
        new pm25();
    }
}