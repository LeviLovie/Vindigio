import javax.swing.*;

public class Game extends JFrame {
    public Game() {
        JFrame frame = new JFrame();
        frame.setTitle("Vindigio");
        frame.setLocation(0, 0);
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(new window());
        frame.setVisible(true);

//        while (true) {frame.repaint();}
    }

    public static void main(String[] args) {
        new Game();
    }
}
