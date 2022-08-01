import javax.swing.*;
import java.awt.*;

public class window extends JPanel {
    World world;
    {world = new World();}

    public window() {
        JPanel panel = new JPanel();
        world.world_constructor();
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.addKeyListener(world);
        add(world);
        add(panel);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int sprite_size = this.world.sprite_size;
        int player_screen_x = this.world.player_x - this.world.screen_x;
        int player_screen_y = this.world.player_y - this.world.screen_y;

        g.setColor(Color.black);
        for (int i = 0; i < this.world.screen_width; i++) {
            for (int j = 0; j < this.world.screen_height; j++) {
                if (this.world.screen_tiles[j][i] == 1) {
                    g.setColor(Color.GREEN);
                } else if (this.world.screen_tiles[j][i] == 2) {
                    g.setColor(Color.MAGENTA);
                } else if (this.world.screen_tiles[j][i] == 3) {
                    g.setColor(Color.ORANGE);
                } else {
                    g.setColor(Color.CYAN);
                }

                g.fillRect(i * sprite_size, j * sprite_size, sprite_size, sprite_size);
            }
        }

        g.setColor(Color.RED);
        g.fillRect(player_screen_x * sprite_size, player_screen_y * sprite_size, sprite_size, sprite_size);

//        System.out.println(this.world.player_x + "," + this.world.player_y);

        if (this.world.pause) {
            g.setColor(new Color(255, 255, 255, 155));
            g.fillRect(0, 0, this.world.screen_width, this.world.screen_height);
        }
    }
}
