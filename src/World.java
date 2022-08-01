import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class World extends JPanel implements KeyListener {
    public World() {
        JPanel panel = new JPanel();
        add(panel);
    }

    public Json json;
    public boolean pause = false;
    public final int sprite_size = 20;
    public final int screen_width = (1280 / sprite_size) - 3;
    public final int screen_height = (720 / sprite_size) - 1;
    public int[][] screen_tiles = new int[screen_height][screen_width];
//    public String load_world = "Villages";

    public int player_x = 0;
    public int player_y = 0;

    public int screen_x = 0;
    public int screen_y = 0;

    public void world_constructor() {
        json = new Json();
        
        this.json.json_parse();
        this.json.get_world("Villages");

        for (int i = 0; i < this.screen_height; i++) {
            //            System.arraycopy(this.private_world_tiles[i], 0, this.public_world_tiles[i], 0, height_tiles);
            System.arraycopy(this.json.world_tiles[i], 0, screen_tiles[i], 0, this.screen_width);
        }
    }

//    public

    public void keyPressed(KeyEvent e) {
//        this.key = e.getKeyChar();
        System.out.println(e.getKeyChar());
//        System.out.println(this.player_x + "/" + this.player_y);

        if (e.getKeyChar() == 's' && this.player_y < this.json.world_height) {
//            System.out.println("D");
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

        // вычисляем координаты левой верхней точки экрана
        this.screen_x = this.player_x - this.screen_width / 2;
        this.screen_y = this.player_y - this.screen_height / 2;

        // проверяем, что экран не выходит за пределы мира
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

        System.out.println("player: " + this.player_x + ", " + this.player_y + "; screen: " + this.screen_x + ", " + this.screen_y);

        // копируем на экран элементы из мира с учетом найденного положения экрана
        for (int i = 0; i < this.screen_height; i++) {
            System.arraycopy(this.json.world_tiles[i + this.screen_y], this.screen_x, screen_tiles[i], 0, this.screen_width);
        }
    }
    public void keyReleased (KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
