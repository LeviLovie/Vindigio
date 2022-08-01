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

        g.setColor(Color.black);
        for (int i = 0; i < this.world.world_width; i += 1) {
            for (int j = 0; j < this.world.world_height; j += 1) {
                if (this.world.public_world_tiles[j][i] == 1) {
                    g.setColor(Color.GREEN);
                } else if (this.world.public_world_tiles[j][i] == 2) {
                    g.setColor(Color.MAGENTA);
                } else if (this.world.public_world_tiles[j][i] == 3) {
                    g.setColor(Color.ORANGE);
                } else {
                    g.setColor(Color.CYAN);
                }

                g.fillRect(i * 20, j * 20, 20, 20);
            }
        }

        g.setColor(Color.RED);
        g.fillRect(Math.round(this.world.player_coordinate[0] * 20), Math.round(this.world.player_coordinate[1] * 20), 20, 20);

        System.out.println(this.world.player_coordinate[0] + "," + this.world.player_coordinate[1]);

        if (this.world.pause) {
            g.setColor(new Color(255, 255, 255, 155));
            g.fillRect(0, 0, 1280, 720);
        }
    }
}
