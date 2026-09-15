package mid;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class clickedColorGrid extends JFrame{
    JPanel[][] panels = new JPanel[6][4];
    boolean[][] status = new boolean[6][4];

    clickedColorGrid(){
        setTitle("Clicked Color Grid");
        setSize(320,480);
        setLayout(new GridLayout(6, 4));

        for(int i=0; i<6; i++){
            for(int j=0; j<4; j++){
                panels[i][j] = new JPanel();
                panels[i][j].setBackground(Color.BLACK);

                final int r = i;
                final int c = j;
                panels[i][j].addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e){
                        JPanel panel = (JPanel)e.getSource();

                        if(panel.getBackground() == Color.BLACK){
                            if(!status[r][c]){
                                Color color = new Color(
                                    (r + 1) / 6.0f,
                                    (c + 1) / 4.0f,
                                    1 - (((r + 1) / 6.0f + (c + 1) / 4.0f) / 2)
                                );
                                panel.setBackground(color);
                            }
                            else{
                                if(e.getClickCount() == 2){
                                    Color color = new Color(
                                        (r + 1) / 6.0f,
                                        (c + 1) / 4.0f,
                                        1 - (((r + 1) / 6.0f + (c + 1) / 4.0f) / 2)
                                    );
                                    panel.setBackground(color);
                                }
                            }
                        }
                        else{
                            status[r][c] = true;
                            panel.setBackground(Color.BLACK);
                        }
                    }
                });
                add(panels[i][j]);
            }
        }

        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new clickedColorGrid();
    }
}
