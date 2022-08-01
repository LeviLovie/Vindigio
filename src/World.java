import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class World extends JPanel {
    public Json json;
    public boolean pause = false;
    public final int sprite_size = 32;
    public final int screen_width = (1280 / sprite_size) - 3;
    public final int screen_height = (720 / sprite_size) - 1;
    public int player_x = 0;
    public int player_y = 0;
    public int screen_x = 0;
    public int screen_y = 0;

    public World() {
        JPanel panel = new JPanel();
        add(panel);

        json = new Json();
        json.json_parse();
        json.get_world("Villages");
    }

    public int get_player_screen_x() {
        return this.player_x - this.screen_x;
    }

    public int get_player_screen_y() {
        return this.player_y - this.screen_y;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 's' && this.player_y < this.json.world_height) {
            if (!this.pause) {
                this.player_y += 1;
            }
        } else if (e.getKeyChar() == 'w' && this.player_y > 0) {
            if (!this.pause) {
                this.player_y -= 1;
            }
        } else if (e.getKeyChar() == 'd' && this.player_x < this.json.world_width) {
            if (!this.pause) {
                this.player_x += 1;
            }
        } else if (e.getKeyChar() == 'a' && this.player_x > 0) {
            if (!this.pause) {
                this.player_x -= 1;
            }
        } else if (e.getKeyCode() == 27) {
            this.pause = !this.pause;
        }

        this.screen_x = this.player_x - this.screen_width / 2;
        this.screen_y = this.player_y - this.screen_height / 2;

        if (this.screen_x < 0) {
            this.screen_x = 0;
        } else if (this.screen_x + this.screen_width > this.json.world_width) {
            this.screen_x = this.json.world_width - this.screen_width;
        }
        if (this.screen_y < 0) {
            this.screen_y = 0;
        } else if (this.screen_y + this.screen_height > this.json.world_height) {
            this.screen_y = this.json.world_height - this.screen_height;
        }
    }
}
