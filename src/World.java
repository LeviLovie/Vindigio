import javax.swing.*;
import java.awt.event.KeyEvent;
import java.util.Random;

public class World extends JPanel {
    public Json json;
    public int string_pr = 0;
    DataNPC npc;
    public boolean pause = false;
    public boolean pause_dialog = false;
    public int mode = 0;

    public final int sprite_size = 32;

    public DataWorld world;

    public int screen_width = (1280 / sprite_size) - 3;
    public int screen_height = Math.round(720 / sprite_size);
    public DataPlayer player;
    public int screen_x = 0;
    public int screen_y = 0;
    public Text text;
    public String tile_click_any = "";
    public int tile_click = 0;

    private final int[][][] house_1 = {
            {{4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}},
            {{4, 3, 0}, {4, 7, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}},
            {{4, 3, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 3, 0}},
            {{4, 3, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 3, 0}},
            {{4, 3, 0}, {4, 6, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 6, 0}, {4, 3, 0}},
            {{4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 0, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}},
            {{4, 3, 0}, {4, 5, 0}, {4, 6, 0}, {4, 0, 0}, {4, 5, 0}, {4, 6, 0}, {4, 0, 0}, {4, 0, 0}, {4, 6, 0}, {4, 3, 0}},
            {{4, 3, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 3, 0}},
            {{4, 3, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 3, 0}},
            {{4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}}
    };
    private final int[][][] house_2 = {
            {{4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}},
            {{4, 3, 0}, {4, 7, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 3, 0}},
            {{4, 3, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 3, 0}},
            {{4, 3, 0}, {4, 5, 0}, {4, 0, 0}, {4, 0, 0}, {4, 6, 0}, {4, 5, 0}, {4, 0, 0}, {4, 6, 0}, {4, 5, 0}, {4, 3, 0}},
            {{4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 0, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}},
            {{4, 3, 0}, {4, 6, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 6, 0}, {4, 3, 0}},
            {{4, 3, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 3, 0}},
            {{4, 3, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 3, 0}},
            {{4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0}, {4, 0, 0} ,{4, 0, 0}, {4, 0, 0}, {4, 3, 0}},
            {{4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}, {4, 3, 0}}
    };

    public World() {
        JPanel panel = new JPanel();
        add(panel);

        text = new Text();
        npc = new DataNPC();

        json = new Json();
        this.player = json.load_player();
        this.world = json.load_world("Calibration");
        json.load_npc("villager");
        npc.npc[0][0] = json.villager_y;
        npc.npc[0][1] = json.villager_x;
//        System.out.println(world.tiles);
    }

    public void world_constructor() {
        Random rn = new Random();
        for (int i = 0; i < this.world.height; i++) {
            for (int j = 0; j < this.world.width; j++) {
                int rand = rn.nextInt() % 101;
                if (rand < 85) {
                    this.world.tiles[i][j][0] = 1;
                    this.world.tiles[i][j][1] = 0;
                } else if (rand < 90) {
                    this.world.tiles[i][j][0] = 2;
                    this.world.tiles[i][j][1] = 0;
                } else {
                    this.world.tiles[i][j][0] = 1;
                    this.world.tiles[i][j][1] = 7;
                }
            }
        }

        int house = rn.nextInt((1 + 1) + 2);
        int house_x = rn.nextInt(((this.world.width - 10) - 2) + 1) + 2;
        int house_y = rn.nextInt(((this.world.height - 10) - 2) + 1) + 2;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (house == 1) {
                    this.world.tiles[house_y + i][house_x + j][0] = this.house_1[i][j][0];
                    this.world.tiles[house_y + i][house_x + j][1] = this.house_1[i][j][1];
                    this.world.tiles[house_y + i][house_x + j][2] = this.house_1[i][j][2];
                } else if (house == 2) {
                    this.world.tiles[house_y + i][house_x + j][0] = this.house_2[i][j][0];
                    this.world.tiles[house_y + i][house_x + j][1] = this.house_2[i][j][1];
                    this.world.tiles[house_y + i][house_x + j][2] = this.house_2[i][j][2];
                }
            }
        }

        this.npc.npc[0][0] = house_x + 1;
        this.npc.npc[0][1] = house_y + 1;
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
        int[][][] tiles = new int[world_height][world_width][3];

        for (int i = 0; i < world_height; i++) {
            for (int j = 0; j < world_width; j++) {
                tiles[i][j][1] = 1;
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

    public void dialog_change() {
        JPanel new_world_dialog_name_panel = new JPanel();
        String intext = JOptionPane.showInputDialog(new_world_dialog_name_panel, "Text (/n for nex line):");
        String npc_name = JOptionPane.showInputDialog(new_world_dialog_name_panel, "Npc name:");
        String npc_text = JOptionPane.showInputDialog(new_world_dialog_name_panel, "Npc text:");

        String[] text = intext.split("/n ");

        this.json.dialog_save(npc_name, npc_text, text);
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
//        System.out.println(this.player.y + ", " + this.player.x + ", " + this.world.height + ", " + this.world.width);
         if (e.getKeyChar() == 's') {
            if (!this.pause && this.player.y + 1 < this.world.height) {
                if (world.can_go_to(this.player.y + 1, this.player.x)) {
//                    System.out.println("+");
                    this.player.y += 1;
                }
            }
        } else if (e.getKeyChar() == 'w') {
            if (!this.pause && this.player.y - 1 > -1) {
                if (world.can_go_to(this.player.y - 1, this.player.x)) {
                    this.player.y -= 1;
                }
            }
        } else if (e.getKeyChar() == 'd') {
             if (!this.pause && this.player.x + 1 < this.world.width) {
                 if (world.can_go_to(this.player.y, this.player.x + 1)) {
                     this.player.x += 1;
                 }
             }
         } else if (e.getKeyChar() == 'a') {
             if (!this.pause && this.player.x - 1 > -1) {
                 if (world.can_go_to(this.player.y, this.player.x - 1)) {
                     this.player.x -= 1;
                 }
             }
         } else if (e.getKeyChar() == 'e') {
             if (this.world.tiles[this.player.y][this.player.x][1] == 7) {
                 this.json.inventory[this.json.inventory_in] = 7;
                 this.world.tiles[this.player.y][this.player.x][1] = 0;
             } else {
                 if (this.json.inventory[this.json.inventory_in] == 7) {
                     this.json.inventory[this.json.inventory_in] = 0;
                     this.world.tiles[this.player.y][this.player.x][1] = 7;
                 } else {
                     this.json.inventory[this.json.inventory_in] = 0;
                 }
             }
         } else if (e.getKeyChar() == 'f') {
//             System.out.println(this.player.y + " = " + this.json.villager_x + ", " + this.player.x + " = " + this.json.villager_y);
             if (this.player.y == this.json.villager_x && this.player.x == this.json.villager_y) {
                 this.pause = true;
                 this.pause_dialog = true;
                 this.json.dialog_load("villager", "start");
             }
         } else if (e.getKeyCode() == 27) {
            this.pause = !this.pause;
             this.pause_dialog = false;
        }

        if (this.mode == 1) {
            if (e.getKeyChar() == 'x') {
                this.json.load_world("Villages");
            } else if (e.getKeyChar() == 'z') {
                this.json.load_world("Calibration");
//            this.world_constructor();
            } else if (e.getKeyChar() == '-') {
                this.tile_click_any = "";
                this.tile_click = 0;
            } else if (e.getKeyChar() == '0') {
                this.tile_click_any += "0";
                this.tile_click = Integer.parseInt(tile_click_any);
            } else if (e.getKeyChar() == '1') {
                this.tile_click_any += "1";
                this.tile_click = Integer.parseInt(tile_click_any);
            } else if (e.getKeyChar() == '2') {
                this.tile_click_any += "2";
                this.tile_click = Integer.parseInt(tile_click_any);
            } else if (e.getKeyChar() == '3') {
                this.tile_click_any += "3";
                this.tile_click = Integer.parseInt(tile_click_any);
            } else if (e.getKeyChar() == '4') {
                this.tile_click_any += "4";
                this.tile_click = Integer.parseInt(tile_click_any);
            } else if (e.getKeyChar() == '5') {
                this.tile_click_any += "5";
                this.tile_click = Integer.parseInt(tile_click_any);
            } else if (e.getKeyChar() == '6') {
                this.tile_click_any += "6";
                this.tile_click = Integer.parseInt(tile_click_any);
            } else if (e.getKeyChar() == '7') {
                this.tile_click_any += "7";
                this.tile_click = Integer.parseInt(tile_click_any);
            } else if (e.getKeyChar() == '8') {
                this.tile_click_any += "8";
                this.tile_click = Integer.parseInt(tile_click_any);
            } else if (e.getKeyChar() == '9') {
                this.tile_click_any += "9";
                this.tile_click = Integer.parseInt(tile_click_any);
            } else if (e.getKeyChar() == 'q') {
                this.world.tiles[this.player.y][this.player.x][1] = tile_click;
            } else if (e.getKeyCode() == 38) {
                if (this.string_pr > 0) {
                    this.string_pr--;
                }
            } else if (e.getKeyCode() == 40) {
                this.string_pr++;
            }
        } else {
            if (e.getKeyChar() == '1') {
                this.json.inventory_in = 0;
            } else if (e.getKeyChar() == '2') {
                this.json.inventory_in = 1;
            } else if (e.getKeyChar() == '3') {
                this.json.inventory_in = 2;
            } else if (e.getKeyChar() == '4') {
                this.json.inventory_in = 3;
            } else if (e.getKeyChar() == '5') {
                this.json.inventory_in = 4;
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
