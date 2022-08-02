import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class World extends JPanel {
    public Json json;
    public boolean pause = false;
    public int mode = 0;

    public final int sprite_size = 32;

    public DataWorld world;

    public int screen_width = (1280 / sprite_size) - 3;
    public int screen_height = (720 / sprite_size);
    public DataPlayer player;
    public int screen_x = 0;
    public int screen_y = 0;
    public int tile_click = 0;

    public World() {
        JPanel panel = new JPanel();
        add(panel);

        json = new Json();
        this.player = json.load_player();
        this.world = json.load_world("Calibration");
    }

    public void world_constructor() {
        Random rn = new Random();
        for (int i = 0; i < this.world.height; i++) {
            for (int j = 0; j < this.world.width; j++) {
                int rand = rn.nextInt() % 101;
                if (rand < 50) {
                    this.world.tiles[i][j] = 1;
                } else if (rand < 60) {
                    this.world.tiles[i][j] = 2;
                } else if (rand < 70) {
                    this.world.tiles[i][j] = 3;
                } else if (rand < 80) {
                    this.world.tiles[i][j] = 4;
                } else if (rand < 90) {
                    this.world.tiles[i][j] = 5;
                } else {
                    this.world.tiles[i][j] = 6;
                }
            }
        }
    }

    public void new_world() {
//        System.out.println("New world");
        JPanel new_world_dialog_name_panel = new JPanel();
        String name = JOptionPane.showInputDialog(new_world_dialog_name_panel, "Name:");

        JPanel new_world_dialog_size_panel = new JPanel();
        String size = JOptionPane.showInputDialog(new_world_dialog_size_panel, "Size (x/y):");
        String[] size_split = size.split("/");

        // генерируем новый мир
        int world_width = Integer.parseInt(size_split[0]);
        int world_height = Integer.parseInt(size_split[1]);
        int[][] tiles = new int[world_height][world_width];

        for (int i = 0; i < world_height; i++) {
            for (int j = 0; j < world_width; j++) {
                tiles[i][j] = 1;
            }
        }

        // сохраняем новый мир
        DataWorld new_world = new DataWorld(name, world_width, world_height, tiles);
        this.json.save_world(new_world);

        // заменяем текущий мир на новый
        this.world = new_world;
        // сбрасываем координаты игрока
        this.player.x = 0;
        this.player.y = 0;
        // говорим, что нужно перерисовать мир
        this.revalidate();
    }

    public void change_world() {
        JPanel change_world_dialog_world_panel = new JPanel();
        String message = "Worlds: " + String.join(", ", this.json.list_worlds());
        String name = JOptionPane.showInputDialog(change_world_dialog_world_panel, message);

        // заменяем текущий мир на загруженный
        this.world = this.json.load_world(name);
        // сбрасываем координаты игрока
        this.player.x = 0;
        this.player.y = 0;
        // говорим, что нужно перерисовать мир
        this.revalidate();
    }

    public int get_player_screen_x() {
        return this.player.x - this.screen_x;
    }

    public int get_player_screen_y() {
        return this.player.y - this.screen_y;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 's' && this.player.y < this.world.height) {
            if (!this.pause) {
                this.player.y += 1;
            }
        } else if (e.getKeyChar() == 'w' && this.player.y > 0) {
            if (!this.pause) {
                this.player.y -= 1;
            }
        } else if (e.getKeyChar() == 'd' && this.player.x < this.world.width) {
            if (!this.pause) {
                this.player.x += 1;
            }
        } else if (e.getKeyChar() == 'a' && this.player.x > 0) {
            if (!this.pause) {
                this.player.x -= 1;
            }
        } else if (e.getKeyCode() == 27) {
            this.pause = !this.pause;
        }

        if (this.mode == 1) {
            if (e.getKeyChar() == 'x') {
                this.json.load_world("Villages");
            } else if (e.getKeyChar() == 'z') {
                this.json.load_world("Calibration");
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
            } else if (e.getKeyChar() == 'e' && this.player.x > 0) {
                System.out.println(this.world.tiles[this.player.y][this.player.x]);
                this.world.tiles[this.player.y][this.player.x] = tile_click;
                System.out.println(this.world.tiles[this.player.y][this.player.x]);
            }
        }

        this.screen_x = this.player.x - this.screen_width / 2;
        this.screen_y = this.player.y - this.screen_height / 2;

        if (this.screen_x < 0) {
            this.screen_x = 0;
        } else if (this.screen_x + this.screen_width > this.world.width) {
            this.screen_x = this.world.width - this.screen_width;
        }
        if (this.screen_y < 0) {
            this.screen_y = 0;
        } else if (this.screen_y + this.screen_height > this.world.height) {
            this.screen_y = this.world.height - this.screen_height;
        }
    }
}
