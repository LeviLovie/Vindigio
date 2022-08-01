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

        player_coordinate[0] = 0;
        player_coordinate[1] = 0;
    }

    JSONParser parser = new JSONParser();

    public boolean pause = false;
    public final int sprite_size = 20;
    public final int world_width = 1280 / sprite_size;
    public final int world_height = 720 / sprite_size;
    public int width_tiles;
    public int height_tiles;
    private int[][] private_world_tiles;
    public int[][] public_world_tiles = new int[world_height][world_width];

    public int[] player_coordinate = new int[2];

    public void world_constructor() {
        try {
            JSONObject jsonO = (JSONObject)parser.parse(new FileReader("src/Worlds.json"));

            JSONObject size = (JSONObject) jsonO.get("size");
            this.width_tiles = ((Long) size.get("width")).intValue();
            this.height_tiles = ((Long) size.get("height")).intValue();

            this.private_world_tiles= new int[this.world_height * 2][this.world_width * 2];

            // Now we try to take the data from "presentationSlides" array
            JSONArray columnsContent = (JSONArray) jsonO.get("tiles");
            Iterator columnI = columnsContent.iterator();

            int column = 0;
            while (columnI.hasNext()) {
                JSONArray rowsContent = (JSONArray) columnI.next();
                Iterator rowI = rowsContent.iterator();

                int row = 0;
                while (rowI.hasNext()) {
                    this.private_world_tiles[column][row] = ((Long) rowI.next()).intValue();
                    row++;
                }

                column++;
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < this.world_height; i++) {
            //            System.arraycopy(this.private_world_tiles[i], 0, this.public_world_tiles[i], 0, height_tiles);
            System.arraycopy(private_world_tiles[i], 0, public_world_tiles[i], 0, this.world_width);
        }
    }

//    public

    public void keyPressed(KeyEvent e) {
//        this.key = e.getKeyChar();
        System.out.println(e.getKeyChar());
//        System.out.println(this.player_coordinate[0] + "/" + this.player_coordinate[1]);

        if (e.getKeyChar() == 's' & this.player_coordinate[1] < height_tiles) {
//            System.out.println("D");
            if (!this.pause) {
                this.player_coordinate[1] += 1;
            }
        } else if (e.getKeyChar() == 'w' & this.player_coordinate[1] > 0) {
            if (!this.pause) {
                this.player_coordinate[1] -= 1;
            }
        } else if (e.getKeyChar() == 'd' & this.player_coordinate[0] < width_tiles) {
            if (!this.pause) {
                this.player_coordinate[0] += 1;
            }
        } else if (e.getKeyChar() == 'a' & this.player_coordinate[0] > 0) {
            if (!this.pause) {
                this.player_coordinate[0] -= 1;
            }
        } else if (e.getKeyCode() == 27) {
            this.pause = !this.pause;
        }

        for (int i = 0; i < this.world_height; i++) {
            for (int j = 0; j < this.world_width; j++) {
                if (player_coordinate[0] > 32) {
                    public_world_tiles[i][j] = private_world_tiles[i][j + player_coordinate[0] - 32];
                } else {
                    public_world_tiles[i][j] = private_world_tiles[i][j];
                }
            }
        }

//        if (player_coordinate[1] > 16) {
//            for (int i = 0; i < this.world_height; i++) {
//                for (int j = 0; j < this.world_width; j++) {
//                    public_world_tiles[i][j] = private_world_tiles[i + player_coordinate[1] - 16][j + player_coordinate[0] - 16];
//                }
//            }
//        } else if (player_coordinate[1] > 16 player_coordinate[0] > 16) {
//            for (int i = 0; i < this.world_height; i++) {
//                for (int j = 0; j < this.world_width; j++) {
//                    public_world_tiles[i][j] = private_world_tiles[i + player_coordinate[1] - 16][j + player_coordinate[0] - 16];
//                }
//            }
//        } else {
//            for (int i = 0; i < this.world_height; i++) {
//                for (int j = 0; j < this.world_width; j++) {
//                    public_world_tiles[i][j] = private_world_tiles[i][j];
//                }
//            }
//        }

//        System.out.println(this.player_coordinate[0] + "," + this.player_coordinate[1]);
    }
    public void keyReleased (KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
