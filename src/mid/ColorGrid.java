package mid;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ColorGrid extends JFrame implements MouseMotionListener, MouseListener{
    JPanel[][] panels = new JPanel[5][5];
    ColorGrid(){
        setTitle("Color Grid");
        setSize(500, 500);
        setLayout(new GridLayout(5, 5));
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                panels[i][j] = new JPanel();
                panels[i][j].setBackground(Color.WHITE);
                panels[i][j].addMouseListener(this);
                panels[i][j].addMouseMotionListener(this);
                add(panels[i][j]);
            }

        }

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void UpdateColor(MouseEvent e){
        JPanel panel = (JPanel)e.getSource();
        int x = e.getX();
        int y = e.getY();
        Color color = new Color(x/100.0f, y/100.0f, (x/100.0f + y/100.0f)/2);
        panel.setBackground(color);
    }
    @Override
    public void mouseMoved(MouseEvent e) { 
        JPanel panel = (JPanel)e.getSource();
        if(panel.getBackground() != Color.WHITE) UpdateColor(e);
        else panel.setBackground(Color.WHITE);
    }
    @Override
    public void mouseEntered(MouseEvent e) {
        JPanel panel = (JPanel)e.getSource();
        if(panel.getBackground() == Color.WHITE){
            UpdateColor(e);
        }
        else{
            panel.setBackground(Color.WHITE);
        }
    }

    @Override
    public void mouseDragged(MouseEvent e) {}
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseReleased(MouseEvent e) {}


    public static void main(String[] args) {
        new ColorGrid();
    }
}
