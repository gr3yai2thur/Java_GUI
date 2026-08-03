package PM2_5;

import java.awt.*;
import javax.swing.*;
import java.io.*;

public class LabPM extends JFrame {
    final int row = 20;
    final int col = 40;
    File selectedFile;

    int[][] pm25 = new int[row][col];
    int[][] people = new int[row][col];

    JPanel table = new JPanel(new GridLayout(20, 40));
    JPanel data = new JPanel();

    LabPM() {
        installComponent();
    }

    public void installComponent() {
        selectFile();
        setTitle("Pseudo Rain Simulator");
        setSize(1600, 900);
        setLayout(new BorderLayout());

        data.setPreferredSize(new Dimension(200, 900));

        table.setBackground(Color.decode("#89CFEF"));
        data.setBackground(Color.decode("#89CFEF"));

        add(table, BorderLayout.CENTER);
        add(data, BorderLayout.WEST);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void selectFile() {
        FileDialog fileDialog = new FileDialog((Frame) null, "Select file: ", FileDialog.LOAD);
        fileDialog.setVisible(true);

        String fileName = fileDialog.getFile();
        String directory = fileDialog.getDirectory();

        if (fileName != null) {
            selectedFile = new File(directory, fileName);
            readFile(selectedFile);
        } else {
            System.out.println("None select file");
            System.exit(0);
        }
    }

    void readFile(File file) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (int i = 0; ; i++) {
                String line = br.readLine();
                if (line == null) break;
                String[] msg = line.trim().split("\\s+");

                final int r = i;
                for (int j = 0; j < msg.length; j++) {
                    final int c = j;
                    pm25[i][j] = Integer.parseInt(msg[j]);

                    Button btn = new Button(msg[j]);
                    btn.addActionListener(e -> onClick(r, c));
                    table.add(btn);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void onClick(int i, int j) {
        JFrame popup = new JFrame();
        popup.setTitle("Details");
        popup.setSize(560, 380);
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        TextArea ta = new TextArea(12, 30);
        ta.setEditable(false);
        ta.setText(String.valueOf(pm25[i][j]) + "\n");

        popup.add(ta);
        popup.setVisible(true);
    }

    public static void main(String[] args) {
        new LabPM();
    }
}