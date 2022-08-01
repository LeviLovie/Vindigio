import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.io.IOException;
//import java.lang.reflect.Array;
import java.util.Iterator;
//import java.util.Random;

public class World extends JPanel implements KeyListener {
    public World() {
        JPanel panel = new JPanel();
        add(panel);
    }

    JSONParser parser = new JSONParser();

    public boolean pause = false;
    public final int sprite_size = 20;
    public final int screen_width = (1280 / sprite_size) - 3;
    public final int screen_height = (720 / sprite_size) - 1;
    public int[][] screen_tiles = new int[screen_height][screen_width];
    public int world_width;
    public int world_height;
    private int[][] world_tiles;

    public String load_world = "Villages";

    public int player_x = 0;
    public int player_y = 0;

    public int screen_x = 0;
    public int screen_y = 0;

    public void world_constructor() {
        try {
            JSONObject jsonO = (JSONObject)parser.parse(new FileReader("src/Worlds.json"));

            JSONObject worlds = (JSONObject) jsonO.get("worlds");
            JSONObject world = (JSONObject) worlds.get(load_world);

            JSONObject size = (JSONObject) world.get("size");

            this.world_width = ((Long) size.get("width")).intValue();
            this.world_height = ((Long) size.get("height")).intValue();

            this.world_tiles = new int[this.world_height][this.world_width];

            // Now we try to take the data from "presentationSlides" array
            JSONArray columnsContent = (JSONArray) world.get("tiles");
            Iterator columnI = columnsContent.iterator();

            int column = 0;
            while (columnI.hasNext()) {
                JSONArray rowsContent = (JSONArray) columnI.next();
                Iterator rowI = rowsContent.iterator();

                int row = 0;
                while (rowI.hasNext()) {
                    this.world_tiles[column][row] = ((Long) rowI.next()).intValue();
                    row++;
                }

                column++;
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < this.screen_height; i++) {
            //            System.arraycopy(this.private_world_tiles[i], 0, this.public_world_tiles[i], 0, height_tiles);
            System.arraycopy(world_tiles[i], 0, screen_tiles[i], 0, this.screen_width);
        }
    }

//    public

    public void keyPressed(KeyEvent e) {
//        this.key = e.getKeyChar();
        System.out.println(e.getKeyChar());
//        System.out.println(this.player_x + "/" + this.player_y);

        if (e.getKeyChar() == 's' && this.player_y < world_height) {
//            System.out.println("D");
            if (!this.pause) {
                this.player_y += 1;
            }
        } else if (e.getKeyChar() == 'w' && this.player_y > 0) {
            if (!this.pause) {
                this.player_y -= 1;
            }
        } else if (e.getKeyChar() == 'd' && this.player_x < world_width) {
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
        } else if (this.screen_x + this.screen_width > this.world_width) {
            this.screen_x = this.world_width - this.screen_width;
        }
        if (this.screen_y < 0) {
            this.screen_y = 0;
        } else if (this.screen_y + this.screen_height > this.world_height) {
            this.screen_y = this.world_height - this.screen_height;
        }

        System.out.println("player: " + this.player_x + ", " + this.player_y + "; screen: " + this.screen_x + ", " + this.screen_y);

        // копируем на экран элементы из мира с учетом найденного положения экрана
        for (int i = 0; i < this.screen_height; i++) {
            System.arraycopy(this.world_tiles[i + this.screen_y], this.screen_x, screen_tiles[i], 0, this.screen_width);
        }
    }
    public void keyReleased (KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
