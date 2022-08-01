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

    public int player_x = 0;
    public int player_y = 0;

    public int screen_x = 0;
    public int screen_y = 0;

    public void world_constructor() {
        json = new Json();
        
        this.json.json_parse();
        this.json.get_world("Villages");
    }

//    public

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
    }
    public void keyReleased (KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
