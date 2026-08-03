package PM2_5;

import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.util.Random;

public class LabPM extends JFrame {

    final int row = 20;
    final int col = 40;

    File selectedFile;

    public int[][] pm25 = new int[row][col];
    public int[][] people = new int[row][col];
    public int[][] sickPP = new int[row][col];
    public int[][] sickPercent = new int[row][col];
    public int[][] goodPP = new int[row][col];

    JPanel table = new JPanel(new GridLayout(row, col));
    JPanel data = new JPanel();


    LabPM() {
        installComponent();
    }


    public void installComponent() {
        selectFile();
        setTitle("Pseudo Rain Simulator");
        setSize(1600,900);
        setLayout(new BorderLayout());

        data.setPreferredSize(new Dimension(200,900));

        add(table, BorderLayout.CENTER);
        add(data, BorderLayout.WEST);

        setDataPanel();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void setDataPanel(){
        JButton sPeople = new JButton("Set People");
        data.add(sPeople);

        sPeople.addActionListener(e -> {
            JFrame setup = new JFrame();
            setup.setTitle("Setup People");
            setup.setSize(200,130);
            setup.setLayout(new FlowLayout());
            setup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            JButton random = new JButton("Random");
            JButton fixed = new JButton("Fixed");

            random.addActionListener(ev -> {
                setup.dispose();
                setRandomPeople();
            });

            fixed.addActionListener(ev -> {
                setup.dispose();
                setPeople();
            });

            setup.add(random);
            setup.add(fixed);

            setup.setVisible(true);
        });
    }

    public void setRandomSickPercent(){
        Random rnd = new Random();

        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pm25[i][j] <= 50) sickPercent[i][j] = rnd.nextInt(10);
                else if(pm25[i][j] <=100) sickPercent[i][j] = rnd.nextInt(10)+10;
                else if(pm25[i][j] <=150) sickPercent[i][j] = rnd.nextInt(10)+20;
                else sickPercent[i][j] = rnd.nextInt(21)+30;
            }
        }
    }

    public void setSickPeople(){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                sickPP[i][j] = (int)(people[i][j] * (sickPercent[i][j] / 100.0));
            }
        }
    }

    public void setPeople(){
        JFrame frame = new JFrame();
        frame.setTitle("Set People");
        frame.setSize(200,130);
        frame.setLayout(new FlowLayout());

        JTextArea value = new JTextArea(1,5);
        JButton apply = new JButton("Apply");

        frame.add(new JLabel("Value"));
        frame.add(value);
        frame.add(apply);

        apply.addActionListener(e->{
            try{
                int amount = Integer.parseInt(value.getText());

                for(int i=0;i<row;i++){
                    for(int j=0;j<col;j++){
                        people[i][j]=amount;
                    }
                }
                setSickPeople();
                getGoodPeople(sickPP);

                frame.dispose();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(frame,"Input number only");
            }
        });
        frame.setVisible(true);
    }

    public void setButtonColor(Button btn, int percent){
        btn.setBackground(getColor(percent));
    }

    public Color getColor(int percent){
        if(percent >= 30)       return Color.RED;
        else if(percent >= 20)  return Color.ORANGE;
        else if(percent >= 10)  return Color.YELLOW;
        else                    return Color.GREEN;
    }

    public void setRandomPeople(){
        JFrame frame = new JFrame();
        frame.setTitle("Random People");
        frame.setSize(220,130);
        frame.setLayout(new FlowLayout());

        JTextArea min = new JTextArea(1,3);
        JTextArea max = new JTextArea(1,3);
        JButton apply = new JButton("Apply");

        frame.add(new JLabel("Min"));
        frame.add(min);
        frame.add(new JLabel("Max"));
        frame.add(max);
        frame.add(apply);

        apply.addActionListener(e->{
            try{
                int a=Integer.parseInt(min.getText());
                int b=Integer.parseInt(max.getText());

                Random rnd=new Random();
                for(int i=0;i<row;i++){
                    for(int j=0;j<col;j++){
                        people[i][j] = rnd.nextInt(b-a+1)+a;
                    }
                }
                setSickPeople();
                frame.dispose();
            }catch(Exception ex){
                JOptionPane.showMessageDialog(frame,"Invalid range");
            }
        });
        frame.setVisible(true);
    }

    public void getGoodPeople(int[][] sickPP){
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                goodPP[i][j] = people[i][j] - sickPP[i][j];
            }
        }
    }

    public void selectFile(){
        FileDialog dialog =
        new FileDialog((Frame)null,
        "Select file",
        FileDialog.LOAD);

        dialog.setVisible(true);

        String fileName = dialog.getFile();
        String directory = dialog.getDirectory();

        if(fileName != null){
            selectedFile = new File(directory,fileName);
            readFile(selectedFile);
        }
        else{
            System.exit(0);
        }

    }

    void readFile(File file){
        try(BufferedReader br =
        new BufferedReader(new FileReader(file))) {
            for(int i=0;i<row;i++){
                String line = br.readLine();
                if(line==null) break;

                String[] msg = line.trim().split("\\s+");
                for(int j=0;j<msg.length;j++){
                    pm25[i][j] = Integer.parseInt(msg[j]);
                }
            }
            setRandomSickPercent();
            for(int i=0;i<row;i++){
                for(int j=0;j<col;j++){

                    final int r=i;
                    final int c=j;

                    Button btn = new Button(String.valueOf(pm25[i][j]));
                    setButtonColor(btn, sickPercent[i][j]);

                    btn.addActionListener(e ->onClickCell(r,c));

                    table.add(btn);
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public void onClickCell(int i,int j){
        JFrame popup = new JFrame();
        popup.setTitle("Details");
        popup.setSize(560,380);
        popup.setDefaultCloseOperation(
        JFrame.DISPOSE_ON_CLOSE);

        TextArea ta = new TextArea(12,30);
        ta.setEditable(false);

        ta.setText("PM2.5 value : "+ pm25[i][j]+ "\n");
        ta.append("People : "+ people[i][j]+ "\n");
        ta.append("Good People: " + goodPP[i][j] + "\n");
        ta.append("Sick% : " + sickPercent[i][j] + "\n");
        ta.append("Sick People : " + sickPP[i][j] + "\n");

        popup.add(ta);

        popup.setVisible(true);
    }

    public static void main(String[] args){
        new LabPM();
    }
}