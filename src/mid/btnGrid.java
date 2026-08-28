package mid;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.*;
public class btnGrid extends JFrame{
    private boolean[] status = new boolean[25];
    private int count;
    JButton[] btn = new JButton[25];
    JPanel btnPanel;
    JPanel statusPanel;
    JLabel countLabel;
    
    btnGrid(){
        setTitle("Button Grid");
        setSize(500, 550);
        setLayout(new BorderLayout());

        btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(5, 5));
        statusPanel = new JPanel(new FlowLayout());

        for(int i=0; i<25; i++){
            btn[i] = new JButton(String.valueOf(i+1));
            btn[i].setBackground(Color.GRAY);
            final int index = i;
            btn[i].addActionListener(e -> {onClick(index);});
            btnPanel.add(btn[i]);
        }
        
        statusPanel.add(new JLabel("On : "));
        countLabel = new JLabel(String.valueOf(count));
        statusPanel.add(countLabel);
        statusPanel.add(new JLabel(" Button"));

        add(btnPanel, BorderLayout.CENTER);
        add(statusPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void onClick(int i){
        if(!status[i]){
            status[i] = true;
            btn[i].setBackground(Color.GREEN);
            count++;
            countLabel.setText(String.valueOf(count));
        }
        else{
            status[i] = false;
            btn[i].setBackground(Color.GRAY);
            count--;
            countLabel.setText(String.valueOf(count));
        }
    }
    public static void main(String[] args) {
        new btnGrid();
    }
}
