import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuWindow extends JPanel {
    JLabel vindigio;
    JButton button_start;
    private BufferedImage image = null;
    public boolean menu = true;
    private final Font vindigio_font;

    public MenuWindow() {
        try {image = ImageIO.read(new File("src/Tiles_tiles/back.png"));} catch (IOException ignored) {System.out.println("tile not found");}

        vindigio = new JLabel("Vindigio");
        button_start = new JButton("Game");

        vindigio_font = new Font("SansSerif", Font.BOLD, 30);

        button_start.addActionListener(e -> {
            menu = false;
        });

        vindigio.setFont(vindigio_font);
        vindigio.setLocation(100, 100);

        JPanel panel = new JPanel();
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.setVisible(true);
        panel.setLayout(null);

        add(vindigio);
        add(button_start);
    }

//    @Override
//    public void paintComponent(Graphics g) {
//         super.paintComponent(g);
//         g.drawImage(this.image, 0, 0, null);
//    }
}
