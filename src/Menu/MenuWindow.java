package Menu;

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
    public boolean is_menu = false;
    private final Font vindigio_font;

    public MenuWindow() {
        try {image = ImageIO.read(new File("src/Images_and_sound/Tiles_tiles/back2.png"));} catch (IOException ignored) {System.out.println("MenuWindow.java: tile not found: Tiles_tiles/back.png");}

        vindigio = new JLabel("Vindigio");
        button_start = new JButton("Game");

        vindigio_font = new Font("SansSerif", Font.BOLD, 30);

        button_start.addActionListener(e -> {
            is_menu = false;
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

    @Override
    public void paintComponent(Graphics g) {
         super.paintComponent(g);
         g.drawImage(this.image, 0, 0, 1280, 720, null);

//         this.button_start.setLocation((1280 / 2) - (100 / 2), 200);
//         this.button_start.setSize(100, 25);
    }
}
