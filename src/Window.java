import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Window extends JPanel implements KeyListener {
    World world;
    BufferedImage img0 = null;
    BufferedImage img1 = null;
    BufferedImage img2 = null;
    BufferedImage img3 = null;
    BufferedImage img4 = null;
    BufferedImage img5 = null;
    BufferedImage img6 = null;

    private JButton world_constructor_button = null;
    private JButton world_redactor_button;
    private final JButton exit_button;
    private final JButton save_button;

    public Window() {
        world = new World();

        try {img0 = ImageIO.read(new File("src/Tiles/0.png"));}  catch (IOException ignored) {}
        try {img1 = ImageIO.read(new File("src/Tiles/1.jpeg"));} catch (IOException ignored) {}
        try {img2 = ImageIO.read(new File("src/Tiles/2.jpeg"));} catch (IOException ignored) {}
        try {img3 = ImageIO.read(new File("src/Tiles/3.jpeg"));} catch (IOException ignored) {}
        try {img4 = ImageIO.read(new File("src/Tiles/4.jpeg"));} catch (IOException ignored) {}
        try {img5 = ImageIO.read(new File("src/Tiles/5.jpeg"));} catch (IOException ignored) {}
        try {img6 = ImageIO.read(new File("src/Tiles/6.jpeg"));} catch (IOException ignored) {}

        JPanel panel = new JPanel();
//        world.world_constructor();
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.addKeyListener(this);
        panel.setVisible(true);

        this.world_redactor_button = new JButton("World redactor mode");
        this.world_redactor_button.setVisible(false);

        this.world_constructor_button = new JButton("Auto world generate");
        this.world_constructor_button.setVisible(false);

        this.exit_button = new JButton("Exit");
        this.exit_button.setVisible(false);

        this.save_button = new JButton("Save");
        this.save_button.setVisible(false);

        add(world_redactor_button); // TODO comment this line for finis compilation
        add(this.world_constructor_button);
        add(this.exit_button);
        add(this.save_button);

        add(world);
        add(panel);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        int sprite_size = this.world.sprite_size;
        int x, y;

        g2d.setColor(Color.MAGENTA);
        for (int i = 0; i < this.world.screen_width; i++) {
            for (int j = 0; j < this.world.screen_height; j++) {
                x = i + this.world.screen_x;
                y = j + this.world.screen_y;
                if (this.world.json.world_tiles[y][x] == 1) {
                    g2d.drawImage(this.img1, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.json.world_tiles[y][x] == 2) {
                    g2d.drawImage(this.img2, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.json.world_tiles[y][x] == 3) {
                    g2d.drawImage(this.img3, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.json.world_tiles[y][x] == 4) {
                    g2d.drawImage(this.img4, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.json.world_tiles[y][x] == 5) {
                    g2d.drawImage(this.img5, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.json.world_tiles[y][x] == 6) {
                    g2d.drawImage(this.img6, (i * sprite_size), (j * sprite_size), null);
                }
            }
        }

        int player_screen_x = this.world.get_player_screen_x();
        int player_screen_y = this.world.get_player_screen_y();
        g2d.drawImage(this.img0, player_screen_x * sprite_size, player_screen_y * sprite_size,null);

        g2d.drawImage(this.img1, 1250, 0, null);
        g2d.drawImage(this.img2, 1250, 32, null);
        g2d.drawImage(this.img3, 1250, 64, null);
        g2d.drawImage(this.img4, 1250, 96, null);
        g2d.drawImage(this.img5, 1250, 128, null);
        g2d.drawImage(this.img6, 1250, 160, null);

        if (this.world.pause) {
            g2d.setColor(new Color(255, 255, 255, 155));
            g2d.fillRect(0, 0, 1280, 720);

            if (this.world.json.mode == 1) { // TODO
                this.world_constructor_button.setVisible(true);
            }
            if (this.world.json.mode == 0) {
                this.world_redactor_button.setVisible(true);
            }
            this.exit_button.setVisible(true);
            this.save_button.setVisible(true);

            if (this.world.json.mode == 1) { // TODO
                this.world_constructor_button.addActionListener(e -> world.world_constructor());
            }
            this.exit_button.addActionListener(e -> world.pause = false);
            this.save_button.addActionListener(e -> {
//                    world.json.set_world();
                System.out.println("Save in developing(");
            });
            this.world_redactor_button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    world.json.mode = 1;
                    System.out.println(world.json.mode);
                }
            });
        } else {
            this.world_redactor_button.setVisible(false);
            if (this.world_constructor_button != null) {
                this.world_constructor_button.setVisible(false);
            }
            this.exit_button.setVisible(false);
            this.save_button.setVisible(false);
        }
    }

    public void keyPressed(KeyEvent e) {
        this.world.keyPressed(e);
        this.revalidate();
    }
    public void keyReleased (KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
