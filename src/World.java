import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Random;

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
    public int tile_click = 0;

    public World() {
        JPanel panel = new JPanel();
        add(panel);

        json = new Json();

        json.json_parse();
        json.get_player();
        json.get_world("Calibration");
    }

    public void world_constructor() {
        Random rn = new Random();
        for (int i = 0; i < this.json.world_height; i++) {
            for (int j = 0; j < this.json.world_width; j++) {
                int rand = rn.nextInt() % 101;
                if (rand < 50) {
                    this.json.world_tiles[i][j] = 1;
                } else if (rand < 60) {
                    this.json.world_tiles[i][j] = 2;
                } else if (rand < 70) {
                    this.json.world_tiles[i][j] = 3;
                } else if (rand < 80) {
                    this.json.world_tiles[i][j] = 4;
                } else if (rand < 90) {
                    this.json.world_tiles[i][j] = 5;
                } else {
                    this.json.world_tiles[i][j] = 6;
                }
            }
        }
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

        if (this.json.mode == 1) {
            if (e.getKeyChar() == 'x') {
                this.json.get_world("Villages");
            } else if (e.getKeyChar() == 'z') {
                this.json.get_world("Calibration");
//            this.world_constructor();
            } else if (e.getKeyChar() == '1') {
                this.tile_click = 1;
            } else if (e.getKeyChar() == '2') {
                this.tile_click = 2;
            } else if (e.getKeyChar() == '3') {
                this.tile_click = 3;
            } else if (e.getKeyChar() == '4') {
                this.tile_click = 4;
            } else if (e.getKeyChar() == '5') {
                this.tile_click = 5;
            } else if (e.getKeyChar() == '6') {
                this.tile_click = 6;
            } else if (e.getKeyChar() == 'e' && this.player_x > 0) {
                System.out.println(this.json.world_tiles[this.player_y][this.player_x]);
                this.json.world_tiles[this.player_y][this.player_x] = tile_click;
                System.out.println(this.json.world_tiles[this.player_y][this.player_x]);
            }
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
