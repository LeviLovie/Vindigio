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

    public Window() {
        world = new World();

        try {img0 = ImageIO.read(new File("src/Tiles/0.png"));}  catch (IOException e) {}
        try {img1 = ImageIO.read(new File("src/Tiles/1.jpeg"));} catch (IOException e) {}
        try {img2 = ImageIO.read(new File("src/Tiles/2.jpeg"));} catch (IOException e) {}
        try {img3 = ImageIO.read(new File("src/Tiles/3.jpeg"));} catch (IOException e) {}
        try {img4 = ImageIO.read(new File("src/Tiles/4.jpeg"));} catch (IOException e) {}
        try {img5 = ImageIO.read(new File("src/Tiles/5.jpeg"));} catch (IOException e) {}
        try {img6 = ImageIO.read(new File("src/Tiles/6.jpeg"));} catch (IOException e) {}

        JPanel panel = new JPanel();
//        world.world_constructor();
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.addKeyListener(this);
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
                    g2d.drawImage(this.img1, i * sprite_size, j * sprite_size, null);
                } else if (this.world.json.world_tiles[y][x] == 2) {
                    g2d.drawImage(this.img2, i * sprite_size, j * sprite_size, null);
                } else if (this.world.json.world_tiles[y][x] == 3) {
                    g2d.drawImage(this.img3, i * sprite_size, j * sprite_size, null);
                } else {
                    g2d.drawImage(this.img4, i * sprite_size, j * sprite_size, null);
                }
            }
        }

        int player_screen_x = this.world.get_player_screen_x();
        int player_screen_y = this.world.get_player_screen_y();
        g2d.drawImage(this.img0, player_screen_x * sprite_size, player_screen_y * sprite_size,null);

        if (this.world.pause) {
            g2d.setColor(new Color(255, 255, 255, 155));
            g2d.fillRect(0, 0, this.world.screen_width, this.world.screen_height);
        }
    }

    public void keyPressed(KeyEvent e) {
        this.world.keyPressed(e);
        this.revalidate();
    }
    public void keyReleased (KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
