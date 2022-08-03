import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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

    private final JButton world_constructor_button;
    private final JButton new_world_button;
    private final JButton change_world_button;
    private final JButton world_redactor_button;
    private final JButton game_button;
    private final JButton exit_button;
    private final JButton save_button;

    public Window() {
        world = new World();

        try {img0 = ImageIO.read(new File("src/Tiles_tiles/0.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img1 = ImageIO.read(new File("src/Tiles_tiles/1.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img2 = ImageIO.read(new File("src/Tiles_tiles/2.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img3 = ImageIO.read(new File("src/Tiles_tiles/3.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img4 = ImageIO.read(new File("src/Tiles_tiles/4.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img5 = ImageIO.read(new File("src/Tiles_tiles/5.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img6 = ImageIO.read(new File("src/Tiles_tiles/6.png"));} catch (IOException ignored) {System.out.println("tile not found");}

        JPanel panel = new JPanel();
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.addKeyListener(this);
        panel.setVisible(true);

        this.world_redactor_button = new JButton("World redactor mode");
        this.world_redactor_button.setVisible(false);

        this.game_button = new JButton("Back to game");
        this.game_button.setVisible(false);

        this.world_constructor_button = new JButton("Auto world generate");
        this.world_constructor_button.setVisible(false);

        this.new_world_button = new JButton("Create new world");
        this.new_world_button.setVisible(false);

        this.change_world_button = new JButton("Change world");
        this.change_world_button.setVisible(false);

        this.exit_button = new JButton("Exit");
        this.exit_button.setVisible(false);

        this.save_button = new JButton("Save");
        this.save_button.setVisible(false);

        add(this.world_redactor_button); // TODO comment this and next line for finis compilation
        add(this.game_button);
        add(this.world_constructor_button);
        add(this.new_world_button);
        add(this.change_world_button);
        add(this.exit_button);
        add(this.save_button);

        add(world);
        add(panel);

        this.exit_button.addActionListener(e -> world.pause = false);
        this.save_button.addActionListener(e -> {
            if (this.world.mode == 1) {
                // world redactor mode
                this.world.json.save_player(this.world.player);
                this.world.json.save_world(this.world.world);
            } else if (this.world.mode == 0) {
                // game mode
                this.world.json.save_player(this.world.player);
            }
        });
        this.world_constructor_button.addActionListener(e -> world.world_constructor());
        this.new_world_button.addActionListener(e -> world.new_world());
        this.change_world_button.addActionListener(e -> world.change_world());
        this.world_redactor_button.addActionListener(e -> world.mode = 1);
        this.game_button.addActionListener(e -> world.mode = 0);
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
                if (this.world.world.tiles[y][x][1] == 1) {
                    g2d.drawImage(this.img1, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][1] == 2) {
                    g2d.drawImage(this.img2, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][1] == 3) {
                    g2d.drawImage(this.img3, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][1] == 4) {
                    g2d.drawImage(this.img4, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][1] == 5) {
                    g2d.drawImage(this.img5, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][1] == 6) {
                    g2d.drawImage(this.img6, (i * sprite_size), (j * sprite_size), null);
                }
                else if (this.world.world.tiles[y][x][2] == 1) {
                    g2d.drawImage(this.img1, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][2] == 2) {
                    g2d.drawImage(this.img2, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][2] == 3) {
                    g2d.drawImage(this.img3, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][2] == 4) {
                    g2d.drawImage(this.img4, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][2] == 5) {
                    g2d.drawImage(this.img5, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][2] == 6) {
                    g2d.drawImage(this.img6, (i * sprite_size), (j * sprite_size), null);
                }
                else if (this.world.world.tiles[y][x][1] > 6) {
                    g2d.drawRect((i * sprite_size), (j * sprite_size), 32, 32);
                } else if (this.world.world.tiles[y][x][2] > 6) {
                    g2d.drawRect((i * sprite_size), (j * sprite_size), 32, 32);
                }
            }
        }

        int player_screen_x = this.world.get_player_screen_x();
        int player_screen_y = this.world.get_player_screen_y();
        g2d.drawImage(this.img0, player_screen_x * sprite_size, player_screen_y * sprite_size,null);

        if (this.world.mode == 1) {
            g2d.drawImage(this.img1, 1250, 0, null);
            g2d.drawImage(this.img2, 1250, 32, null);
            g2d.drawImage(this.img3, 1250, 64, null);
            g2d.drawImage(this.img4, 1250, 96, null);
            g2d.drawImage(this.img5, 1250, 128, null);
            g2d.drawImage(this.img6, 1250, 160, null);
        }

        if (this.world.mode == 1) {
            // world redactor mode
            this.world.screen_width =  (1280 / this.world.sprite_size) - 3;
        } else if (this.world.mode == 0) {
            // game mode
            this.world.screen_width = (1280 / this.world.sprite_size) - 2;
        }

        if (this.world.pause) {
            g2d.setColor(new Color(255, 255, 255, 155));
            g2d.fillRect(0, 0, 1280, 720);

            if (this.world.mode == 1) {
                // world redactor mode
                this.world_constructor_button.setVisible(true);
                this.new_world_button.setVisible(true);
                this.change_world_button.setVisible(true);
                this.world_redactor_button.setVisible(false);
                this.game_button.setVisible(true);
            } else if (this.world.mode == 0) {
                // game mode
                this.world_redactor_button.setVisible(true);
                this.game_button.setVisible(false);
                this.world_constructor_button.setVisible(false);
                this.new_world_button.setVisible(false);
                this.change_world_button.setVisible(false);
            }

            this.exit_button.setVisible(true);
            this.save_button.setVisible(true);
        } else {
            this.world_redactor_button.setVisible(false);
            this.game_button.setVisible(false);
            this.world_constructor_button.setVisible(false);
            this.new_world_button.setVisible(false);
            this.change_world_button.setVisible(false);
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
