import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {
    JFrame frame = new JFrame();
    public Game() {
        frame.setTitle("Vindigio");
        frame.setLocation(0, 0);
        frame.setSize(1280, 720 + 28);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.add(new Window());
        frame.setVisible(true);

        Timer timer;
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.repaint();
            }
        });
        timer.setRepeats(true);
        // Aprox. 60 FPS
        timer.setDelay(17);
        timer.start();
    }

    public static void main(String[] args) {
        new Game();
    }
}
