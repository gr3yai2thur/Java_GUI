package PM2_5;

import java.awt.*;
import java.io.*;

public class read extends Frame {
    read(){
        setTitle("PM2.5 Work");
        setSize(1600, 900);
        setLayout(new BorderLayout());

        Panel table = new Panel(new GridLayout(20, 40));

        Panel data = new Panel();
        data.setPreferredSize(new Dimension(200, 900));

        try {
            BufferedReader bfr = new BufferedReader(new FileReader("C:\\Java_GUI\\src\\AWT\\PM2_5\\pm2.5_69.txt"));

            for(;;){
                String txt = bfr.readLine();
                if(txt == null) break;
                txt = txt.trim();

                String[] msg = txt.split("[\\s+]");

                for(int i=0; i<msg.length; i++){
                    int x = Integer.parseInt(msg[i]);
                    Button btn = new Button("" + msg[i]);

                    if(x <= 50)       btn.setBackground(Color.GREEN);
                    else if(x <= 100) btn.setBackground(Color.YELLOW);
                    else if(x <= 150) btn.setBackground(Color.ORANGE);
                    else              btn.setBackground(Color.RED);

                    table.add(btn);
                }
            }
            
            add(table, BorderLayout.CENTER);
            add(data, BorderLayout.EAST);

            bfr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
    }

    public static void main(String[] args) {
        new read();
    }
}