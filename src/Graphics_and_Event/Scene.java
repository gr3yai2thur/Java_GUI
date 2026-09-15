import java.io.File;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.Timer;
import java.util.TimerTask;
import javax.sound.sampled.Clip;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import java.awt.event.MouseMotionAdapter;
import javax.sound.sampled.AudioInputStream;

public class Scene extends JPanel{
    Image bg;
    Image ghost;
    Image crosshair;
    int x = 0, y = 0;
    int[] posX = new int[25];
    int[] posY = new int[25];
    boolean[] status = new boolean[25];

    Scene(){
        Random rnd = new Random();

        bg = Toolkit.getDefaultToolkit().getImage(
            System.getProperty("user.dir") + File.separator + "img"
                + File.separator + "castle.png"
        );

        ghost = Toolkit.getDefaultToolkit().getImage(
            System.getProperty("user.dir") + File.separator + "img"
                + File.separator + "ghost.png"
        );

        crosshair = Toolkit.getDefaultToolkit().getImage(
            System.getProperty("user.dir") + File.separator + "img"
                + File.separator + "crosshair.png"
        );

        for(int i=0; i<25; i++){
            posX[i] = rnd.nextInt(1550);
            posY[i] = rnd.nextInt(850);
            if(posX[i] >= 1315 && posY[i] < 50) posY[i] = rnd.nextInt(850);
            status[i] = !status[i];
        }

        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e){
                x = e.getX();
                y = e.getY();
                repaint();
            }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override 
            public void mousePressed(MouseEvent e){
                try {
                    File f = new File(System.getProperty("user.dir") + File.separator + "effect"
                        + File.separator + "/gun.wav");
                    AudioInputStream stream = AudioSystem.getAudioInputStream(f);
                    AudioFormat format = stream.getFormat();
                    Clip clip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, format));
                    clip.open(stream);
                    clip.start();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }

                int x = e.getX();
                int y = e.getY();

                for(int i=0; i<25; i++){
                    if (status[i]) {
                        if (x >= posX[i]
                                && x <= posX[i] + 50
                                && y >= posY[i]
                                && y <= posY[i] + 50) {

                            status[i] = false;
                        }
                    }
                }
            }
        });

        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override 
            public void run(){
                for(int i=0; i<25; i++){
                    posX[i] += rnd.nextInt(21) - 10;
                    posY[i] += rnd.nextInt(21) - 10;
                    repaint();
                }
            }
        }, 0, 100);
    }

    @Override
    protected void paintComponent(Graphics g){
        g.drawImage(bg, 0, 0, this);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Tahoma", Font.BOLD, 24));
        g.drawString("Ghost Hunter", 1350, 50);
        g.drawRoundRect(1325, 15, 210, 50, 10, 10);

        for(int i=0; i<25; i++){
            if(status[i]){
                g.drawImage(ghost, posX[i], posY[i], this);
            }
        }

        g.drawImage(crosshair, x - 25, y - 25, 50, 50, this);
    }


}
