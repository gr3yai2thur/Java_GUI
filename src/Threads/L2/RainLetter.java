package L2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RainLetter extends JFrame{
    private JLabel[] lbl = new JLabel[26];
    private LetterThread[] threads = new LetterThread[26];
    private JButton status;

    private JPanel letterBox = new JPanel();
    private JPanel statusBox = new JPanel();

    RainLetter(){
        setSize(500, 300);
        setLayout(new BorderLayout());

        letterBox.setLayout(null);
        statusBox.setLayout(new FlowLayout());
        statusBox.setPreferredSize(new Dimension(500, 40));


        int x = 0;
        for (int i = 0; i < 26; i++) {
            lbl[i] = new JLabel(Character.toString('A' + i));
            lbl[i].setBounds(x, 0, 20, 20);
            threads[i] = new LetterThread(lbl[i], x, 260);
            letterBox.add(lbl[i]);
            x += 19;
        }

        status = new JButton("Stop");
        status.addActionListener(e -> {
            for (int i = 0; i < 26; i++) {
                if(threads[i].running){
                    threads[i].running = false;
                }
                else{
                    threads[i].running = true;
                }
            }
            if(status.getText().equalsIgnoreCase("Stop")){
                status.setText("Start");
            }
            else{
                status.setText("Stop");
            }
        });

        statusBox.add(status);
        add(letterBox, BorderLayout.CENTER);
        add(statusBox, BorderLayout.SOUTH);

        for (int i = 0; i < 26; i++) {
            threads[i].start();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);
    }

    public static void main(String[] args) {
        new RainLetter();
    }
}
