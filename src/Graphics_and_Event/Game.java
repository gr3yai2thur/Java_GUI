import javax.swing.JFrame;

public class Game extends JFrame{
    Game(){
        Scene scene = new Scene();

        setTitle("Ghost Hunter");
        setSize(1600, 900);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        scene.setBounds(0, 0, 1600, 900);
        add(scene);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Game();
    }
}
