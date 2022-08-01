import javax.swing.*;
import java.awt.*;

public class Window extends JPanel {
    World world;
    {world = new World();}

    public Window() {
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

        // вычисляем координаты левой верхней точки экрана
        this.world.screen_x = this.world.player_x - this.world.screen_width / 2;
        this.world.screen_y = this.world.player_y - this.world.screen_height / 2;

        // проверяем, что экран не выходит за пределы мира
        if (this.world.screen_x < 0) {
            this.world.screen_x = 0;
        } else if (this.world.screen_x + this.world.screen_width > this.world.json.world_width) {
            this.world.screen_x = this.world.json.world_width - this.world.screen_width;
        }
        if (this.world.screen_y < 0) {
            this.world.screen_y = 0;
        } else if (this.world.screen_y + this.world.screen_height > this.world.json.world_height) {
            this.world.screen_y = this.world.json.world_height - this.world.screen_height;
        }

        g.setColor(Color.black);
        for (int i = 0; i < this.world.screen_width; i++) {
            for (int j = 0; j < this.world.screen_height; j++) {
                if (this.world.json.world_tiles[j + this.world.screen_y][i + this.world.screen_x] == 1) {
                    g.setColor(Color.GREEN);
                } else if (this.world.json.world_tiles[j + this.world.screen_y][i + this.world.screen_x] == 2) {
                    g.setColor(Color.MAGENTA);
                } else if (this.world.json.world_tiles[j + this.world.screen_y][i + this.world.screen_x] == 3) {
                    g.setColor(Color.ORANGE);
                } else {
                    g.setColor(Color.CYAN);
                }

//                g.fillRect((i + this.world.screen_x) * sprite_size, (j + this.world.screen_y) * sprite_size, sprite_size, sprite_size);
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
