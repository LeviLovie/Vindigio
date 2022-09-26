// cp ~/Documents/GitHub/Vindigio/src/Json_data/Data.json ~/Library/Vindigio/src/Json_data/

package Game;

import Java_data_classes.MyQuests;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GameWindow extends JPanel implements KeyListener {
    public int num = 0;
    public final World world;
    private JLabel task;
    private boolean press_i_meee = true;
    private boolean press_j_meee = true;
    MyQuests Quests;
    private String quest = "press_i";
    public boolean is_game = true;
    public boolean repaint = true;
    private BufferedImage img0_0 = null;
    private BufferedImage img0_1 = null;
    private BufferedImage img0_2 = null;
    private BufferedImage img0 = null;
    private BufferedImage img1 = null;
    private BufferedImage img2 = null;
    private BufferedImage img3 = null;
    private BufferedImage img4 = null;
    private BufferedImage img5 = null;
    private BufferedImage img6 = null;
    private BufferedImage img7 = null;
    private BufferedImage img8_1 = null;
    private BufferedImage img8_2 = null;
    private BufferedImage img9 = null;
    private BufferedImage img10 = null;
    private final JButton world_constructor_button_0;
    private final JButton world_constructor_button_1;
    private final JButton new_world_button;
    private final JButton change_world_button;
    private final JButton world_redactor_button;
    private final JButton menu_button;
    private final JButton game_button;
    private final JButton exit_button;
    private final JButton hext_button;
    private final JButton save_button;
    private final JButton dialog_change_butoon;
    private final JLabel coins;
    private final Font coins_font;
    private int strings = 1;
    Paint_2 my_paint;
    Logger log = Logger.getLogger(GameWindow.class.getName());
    private static final String path_in_resuorces = "Vindigio/src/Json_data/Data.json";
    private final String path_to_resurces = System.getProperty("user.home") + "/Library/Vindigio/";

    public GameWindow(String arg) {
        this.Quests = new MyQuests();
        my_paint = new Paint_2();
        world = new World(arg);

        if (Objects.equals(arg, "1")) {
            try {img0_0 = ImageIO.read(new File(path_to_resurces + "src/Images_and_sound/Tiles_tiles/0.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Animation_tiles/0.png - can not load");}
            try {img0_1 = ImageIO.read(new File(path_to_resurces + "src/Images_and_sound/Tiles_tiles/0.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Animation_tiles/1.png - can not load");}
            try {img0_2 = ImageIO.read(new File(path_to_resurces + "src/Images_and_sound/Tiles_tiles/0.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Animation_tiles/2.png - can not load");}
            try {img0 = ImageIO.read(new File(path_to_resurces + "src/Images_and_sound/Tiles_tiles/00.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Animation_tiles/00.png - can not load"); System.exit(1);}
            try {img1 = ImageIO.read(new File(path_to_resurces + "src/Images_and_sound/Tiles_tiles/1.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/1.png - can not load"); System.exit(1);}
            try {img2 = ImageIO.read(new File(path_to_resurces + "src/Images_and_sound/Tiles_tiles/2.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/2.png - can not load"); System.exit(1);}
            try {img3 = ImageIO.read(new File(path_to_resurces + "src/Images_and_sound/Tiles_tiles/3.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/3.png - can not load"); System.exit(1);}
            try {img4 = ImageIO.read(new File(path_to_resurces + "src/Images_and_sound/Tiles_tiles/4.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/4.png - can not load"); System.exit(1);}
            try {img5 = ImageIO.read(new File(path_to_resurces + "src/Images_and_sound/Tiles_tiles/5.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/5.png - can not load"); System.exit(1);}
            try {img6 = ImageIO.read(new File(path_to_resurces + "src/Images_and_sound/Tiles_tiles/6.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/6.png - can not load"); System.exit(1);}
            try {img7 = ImageIO.read(new File(path_to_resurces + "src/Images_and_sound/Tiles_tiles/7.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/7.png - can not load"); System.exit(1);}
            try {img8_1 = ImageIO.read(new File(path_to_resurces + "src/Images_and_sound/Tiles_tiles/8_1.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/8_1.png - can not load"); System.exit(1);}
            try {img8_2 = ImageIO.read(new File(path_to_resurces + "src/Images_and_sound/Tiles_tiles/8_2.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/8_2.png - can not load"); System.exit(1);}
            try {img9 = ImageIO.read(new File(path_to_resurces + "src/Images_and_sound/Tiles_tiles/9.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/9.png - can not load"); System.exit(1);}
            try {img10 = ImageIO.read(new File(path_to_resurces + "src/Images_and_sound/Tiles_tiles/10.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/10.png - can not load"); System.exit(1);}
        } else if (Objects.equals(arg, "0")) {
            try {img0_0 = ImageIO.read(new File("src/Images_and_sound/Tiles_tiles/0.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Animation_tiles/0.png - can not load");}
            try {img0_1 = ImageIO.read(new File("src/Images_and_sound/Tiles_tiles/0.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Animation_tiles/1.png - can not load");}
            try {img0_2 = ImageIO.read(new File("src/Images_and_sound/Tiles_tiles/0.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Animation_tiles/2.png - can not load");}
            try {img0 = ImageIO.read(new File("src/Images_and_sound/Tiles_tiles/00.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Animation_tiles/00.png - can not load"); System.exit(1);}
            try {img1 = ImageIO.read(new File("src/Images_and_sound/Tiles_tiles/1.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/1.png - can not load"); System.exit(1);}
            try {img2 = ImageIO.read(new File("src/Images_and_sound/Tiles_tiles/2.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/2.png - can not load"); System.exit(1);}
            try {img3 = ImageIO.read(new File("src/Images_and_sound/Tiles_tiles/3.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/3.png - can not load"); System.exit(1);}
            try {img4 = ImageIO.read(new File("src/Images_and_sound/Tiles_tiles/4.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/4.png - can not load"); System.exit(1);}
            try {img5 = ImageIO.read(new File("src/Images_and_sound/Tiles_tiles/5.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/5.png - can not load"); System.exit(1);}
            try {img6 = ImageIO.read(new File("src/Images_and_sound/Tiles_tiles/6.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/6.png - can not load"); System.exit(1);}
            try {img7 = ImageIO.read(new File("src/Images_and_sound/Tiles_tiles/7.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/7.png - can not load"); System.exit(1);}
            try {img8_1 = ImageIO.read(new File("src/Images_and_sound/Tiles_tiles/8_1.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/8_1.png - can not load"); System.exit(1);}
            try {img8_2 = ImageIO.read(new File("src/Images_and_sound/Tiles_tiles/8_2.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/8_2.png - can not load"); System.exit(1);}
            try {img9 = ImageIO.read(new File("src/Images_and_sound/Tiles_tiles/9.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/9.png - can not load"); System.exit(1);}
            try {img10 = ImageIO.read(new File("src/Images_and_sound/Tiles_tiles/10.png"));} catch (IOException ignored) {log.logp(Level.WARNING, "GameWindow", "Constructor", "src/Tiles_tiles/10.png - can not load"); System.exit(1);}
        }

        JPanel panel = new JPanel();
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.addKeyListener(this);
        panel.setVisible(true);
        panel.setLayout(null);

        world_redactor_button = new JButton("Game.World redactor mode");
        world_redactor_button.setVisible(false);

        menu_button = new JButton("Menu");
        menu_button.setVisible(false);

        game_button = new JButton("Back to game");
        game_button.setVisible(false);

        world_constructor_button_0 = new JButton("Auto world generate");
        world_constructor_button_0.setVisible(false);

        world_constructor_button_1 = new JButton("Auto world generate (grout)");
        world_constructor_button_1.setVisible(false);

        new_world_button = new JButton("Create new world");
        new_world_button.setVisible(false);

        change_world_button = new JButton("Change world");
        change_world_button.setVisible(false);

        exit_button = new JButton("Exit");
        exit_button.setVisible(false);

        hext_button = new JButton("Next");
        hext_button.setVisible(false);

        save_button = new JButton("Save");
        save_button.setVisible(false);

        dialog_change_butoon = new JButton("Dialog change");
        dialog_change_butoon.setVisible(false);

        coins = new JLabel("C: " + world.json.coins);
        coins_font = new Font("SansSerif", Font.BOLD, 15);

        add(world_redactor_button); // TODO comment this and next line for finis compilation
        add(menu_button);
        add(game_button);
        add(world_constructor_button_0);
        add(world_constructor_button_1);
        add(new_world_button);
        add(change_world_button);
        add(exit_button);
        add(hext_button);
        add(save_button);
        add(dialog_change_butoon);
        add(coins);

        add(world);
        add(panel);

        exit_button.addActionListener(e -> {
            world.pause = false;
            world.pause_dialog = false;
            world.pause_qwest = false;
        });
        hext_button.addActionListener(e -> strings++);

        save_button.addActionListener(e -> {
            world.json.save_player(world.player, this.quest, this.world.player.quest_num);
            world.json.save_world(world.world);
        });
        world_constructor_button_0.addActionListener(e -> world.world_constructor(""));
        world_constructor_button_1.addActionListener(e -> world.world_constructor("grout"));
        dialog_change_butoon.addActionListener(e -> world.dialog_change());
        new_world_button.addActionListener(e -> world.new_world());
        change_world_button.addActionListener(e -> world.change_world());
        world_redactor_button.addActionListener(e -> world.mode = 1);
        menu_button.addActionListener(e -> is_game = false);
        game_button.addActionListener(e -> world.mode = 0);

        task = new JLabel("");
        add(task);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        int player_screen_x = this.world.get_player_screen_x();
        int player_screen_y = this.world.get_player_screen_y();

        this.coins.setText(String.valueOf(this.world.json.coins));

        try {
            this.my_paint.world_paint(
                    g2d, this.world.screen_height, this.world.screen_width, this.world.screen_x, this.world.screen_y,
                    this.world.sprite_size, this.world.player.x, this.world.player.y, this.world.world.tiles,
                    this.img1, this.img2, this.img3, this.img4, this.img5, this.img6, this.img7, this.img8_1,
                    this.img8_2, this.img9, this.img10);
        } catch (Exception e) {
            log.logp(Level.WARNING, "GameWindow", "PaintComponent", "World paint:", e);
            System.exit(1);
        }
        try {
            this.my_paint.inventory_paint(
                    g2d, this.world.json.inventory, this.world.json.inventory_in, this.world.world.width,
                    this.img7);
        } catch (Exception e) {
            log.logp(Level.WARNING, "GameWindow", "PaintComponent", "Inventory paint:");
            System.exit(1);
        }
        try {
            this.my_paint.map_paint(
                    g2d, this.world.world.height, this.world.world.width, this.world.world.tiles,
                    this.world.player.y, this.world.player.x);
        } catch (Exception e) {
            log.logp(Level.WARNING, "GameWindow", "PaintComponent", "Map paint:", e);
            System.exit(1);
        }
        try {
            this.my_paint.flags_paint(
                    this.world.flags, this.world.world.tiles);
        } catch (Exception e) {
            log.logp(Level.WARNING, "GameWindow", "PaintComponent", "Flags paint:", e);
            System.exit(1);
        }
        try {
            this.my_paint.npc_paint(
                    g2d, this.world.npc.npc, this.world.screen_y, this.world.screen_x,
                    this.img0);
        } catch (Exception e) {
            log.logp(Level.WARNING, "GameWindow", "PaintComponent", "NPC paint:", e);
            System.exit(1);
        }
        try {
            this.my_paint.player_paint(
                    g2d, player_screen_y, player_screen_x, this.world.sprite_size,
                    this.img0_0, this.img0_1, this.img0_2);
        } catch (Exception e) {
            log.logp(Level.WARNING, "GameWindow", "PaintComponent", "Player paint:", e);
            System.exit(1);
        }
        try {
            this.my_paint.coins_paint(
                    this.world.mode, this.coins, this.coins_font);
        } catch (Exception e) {
            log.logp(Level.WARNING, "GameWindow", "PaintComponent", "Coins paint:", e);
            System.exit(1);
        }
        try {
            this.my_paint.redactor_mode_tiles_paint(g2d, this.world.mode,
                    this.img1, this.img2, this.img3, this.img4, this.img5, this.img6);
        } catch (Exception e) {
            log.logp(Level.WARNING, "GameWindow", "PaintComponent", "Redactor mode tiles paint:");
            System.exit(1);
        }

        this.hext_button.setVisible(false);
        this.pause(g2d);
    }
    public void pause(Graphics2D g2d) {
        if (Objects.equals(this.quest, "press_i")) {
            if (this.Quests.press_i.Get_quest_num() == 1 && this.press_i_meee) {
//            if (meee) {
                this.world.pause = false;
                this.world.pause_qwest = false;
                this.world.pause_dialog = false;
//                this.task.setText("You done " + this.quest + "!");
                this.world.json.coins += 25;
                this.quest = "press_j";
                repaint();
                this.press_i_meee = false;
//                add(this.task);
//                this.repaint = false;
//            } else {
//                this.repaint = true;
//            }
            }
        } else if (Objects.equals(this.quest, "press_j")) {
            if (this.Quests.press_j.Get_quest_num() == 2 && this.press_j_meee) {
//            if (meee) {
                this.world.pause = false;
                this.world.pause_qwest = false;
                this.world.pause_dialog = false;
//                this.task.setText("You done " + this.quest + "!");
                this.world.json.coins += 50;
                this.quest = "final";
                repaint();
                this.press_j_meee = false;
//                add(this.task);
//                this.repaint = false;
//            } else {
//                this.repaint = true;
//            }
            }
        }
        if (this.world.pause) {
            if (this.world.mode == 1) {
                this.exit_button.setVisible(true);
            }
            if (this.world.pause_qwest) {
//                this.task.setVisible(true);
                if (this.num != 4) {
                    this.num++;
                }
//                System.out.println(this.quest);
                if (Objects.equals(this.quest, "press_i")) {
                    this.task.setText(this.Quests.press_i.Get_task());
                } else if (Objects.equals(this.quest, "press_j")) {
                    this.task.setText(this.Quests.press_j.Get_task());
                } else if (Objects.equals(this.quest, "final")) {
                    this.task.setText("Final");
                } else {
                    this.task.setText("Game can't find: " + this.quest + " quest");
//                    System.out.println("Game can't find: " + this.quest + " quest");
                }
                g2d.setColor(new Color(215, 215, 142, 155));
                g2d.fillRect(0, 0, 1280, 720);
                if (num == 2) {
                    this.task.setVisible(true);
                } else if (num == 5) {
                    this.repaint = false;
                }
            } else if (this.world.pause_dialog) {
                g2d.setColor(new Color(215, 215, 142, 155));
                g2d.fillRect(390, 350, 500, 300);

                this.hext_button.setVisible(true);
                this.hext_button.setLocation(815, 620);

                for (int i = 0; i < this.world.json.texts.length; i++) {
                    if (this.world.json.texts[i] != null) {
                        this.world.text.text_parser(this.world.json.texts[i]);
                        if (i < this.strings) {
                            for (int j = 0; j < this.world.text.result_images.length; j++) {
                                if (this.world.text.result_images[j] != null) {
                                    g2d.drawImage(
                                            this.world.text.result_images[j],
                                            ((10 + 2) * j + 390),
                                            ((15 + 5) * i + 350), null
                                    );
                                }
                            }
                        }
                    }
                }
                this.dialog_change_butoon.setVisible(this.world.mode == 1);
            } else {
                g2d.setColor(new Color(255, 255, 255, 155));
                g2d.fillRect(0, 0, 1280, 720);

                if (this.world.mode == 1) {
                    // world redactor mode
                    this.world_constructor_button_0.setVisible(true);
                    this.world_constructor_button_1.setVisible(true);
                    this.new_world_button.setVisible(true);
                    this.change_world_button.setVisible(true);
                    this.world_redactor_button.setVisible(false);
                    this.game_button.setVisible(true);
                } else if (this.world.mode == 0) {
                    // game mode
                    this.world_redactor_button.setVisible(true);
                    this.game_button.setVisible(false);
                    this.world_constructor_button_0.setVisible(false);
                    this.world_constructor_button_1.setVisible(false);
                    this.new_world_button.setVisible(false);
                    this.change_world_button.setVisible(false);
                }

                this.menu_button.setVisible(true);
                this.hext_button.setVisible(false);
                this.exit_button.setVisible(true);
                this.save_button.setVisible(true);

                for (int i = 0; i < this.world.text.result_images.length; i++) {
                    if (this.world.text.result_images[i] != null) {
                        g2d.drawImage(this.world.text.result_images[i], 11 * i, 15, null);
                    }

                }
            }
        }
        if (!this.world.pause) {
            this.menu_button.setVisible(false);
            this.world_redactor_button.setVisible(false);
            this.game_button.setVisible(false);
            this.world_constructor_button_0.setVisible(false);
            this.world_constructor_button_1.setVisible(false);
            this.new_world_button.setVisible(false);
            this.change_world_button.setVisible(false);
            this.exit_button.setVisible(false);
            this.save_button.setVisible(false);
        }
        if (!this.world.pause_qwest) {
            this.task.setVisible(false);
            this.num = 0;
        }
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 27) {
//            if (!meee) {
                this.num = 0;
                this.strings = 1;
                this.repaint = true;
                this.world.keyPressed(e);
                this.task.setVisible(false);
                repaint();
//            } else {
//                this.meee = false;
//            }
        } else if (e.getKeyChar() == 'f') {
            this.world.keyPressed(e);
        } else if (e.getKeyChar() == 'j') {
            if (Objects.equals(this.quest, "press_j")) {
                this.Quests.press_j.Set_quest_num(this.Quests.press_j.Get_quest_num() + 1);
            }
        } else if (e.getKeyChar() == 'i') {
            if (Objects.equals(this.quest, "press_i")) {
                System.out.println("i");
                this.Quests.press_i.Set_quest_num(1);
            }
        } else {
            this.world.keyPressed(e);
        }
    }
    public void keyReleased (KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}

class Paint_2 {
    public void world_paint(
            Graphics2D g2d, int screen_height, int screen_width, int screen_x, int screen_y, int sprite_size,
            int player_y, int player_x, int[][][] tiles,
            BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4, BufferedImage img5,
            BufferedImage img6, BufferedImage img7, BufferedImage img8_1, BufferedImage img8_2, BufferedImage img9,
            BufferedImage img10) {

        int x, y;
        g2d.setColor(Color.MAGENTA);
        for (int i = 0; i < screen_width; i++) {
            for (int j = 0; j < screen_height; j++) {
                x = i + screen_x;
                y = j + screen_y;
                if (tiles[y][x][0] == 1) {
                    g2d.drawImage(img1, (i * sprite_size), (j * sprite_size), null);
                } else if (tiles[y][x][0] == 2) {
                    g2d.drawImage(img2, (i * sprite_size), (j * sprite_size), null);
                } else if (tiles[y][x][0] == 3) {
                    g2d.drawImage(img3, (i * sprite_size), (j * sprite_size), null);
                } else if (tiles[y][x][0] == 4) {
                    g2d.drawImage(img4, (i * sprite_size), (j * sprite_size), null);
                } else if (tiles[y][x][0] == 5) {
                    g2d.drawImage(img5, (i * sprite_size), (j * sprite_size), null);
                } else if (tiles[y][x][0] == 6) {
                    g2d.drawImage(img6, (i * sprite_size), (j * sprite_size), null);
                } else if (tiles[y][x][0] == 10) {
                    g2d.drawImage(img10, (i * sprite_size), (j * sprite_size), null);
                }
                if (tiles[y][x][1] == 1) {
                    g2d.drawImage(img1, (i * sprite_size), (j * sprite_size), null);
                } else if (tiles[y][x][1] == 2) {
                    g2d.drawImage(img2, (i * sprite_size), (j * sprite_size), null);
                } else if (tiles[y][x][1] == 3) {
                    g2d.drawImage(img3, (i * sprite_size), (j * sprite_size), null);
                } else if (tiles[y][x][1] == 4) {
                    g2d.drawImage(img4, (i * sprite_size), (j * sprite_size), null);
                } else if (tiles[y][x][1] == 5) {
                    g2d.drawImage(img5, (i * sprite_size), (j * sprite_size), null);
                } else if (tiles[y][x][1] == 6) {
                    g2d.drawImage(img6, (i * sprite_size), (j * sprite_size), null);
                } else if (tiles[y][x][1] == 7) {
                    g2d.drawImage(img7, (i * sprite_size), (j * sprite_size), null);
                } else if (tiles[y][x][1] == 8) {
                    if (y == player_y && x == player_x) {
                        g2d.drawImage(img8_2, (i * sprite_size), (j * sprite_size), null);
                    } else {
                        g2d.drawImage(img8_1, (i * sprite_size), (j * sprite_size), null);
                    }
                } else if (tiles[y][x][1] == 9) {
                    g2d.drawImage(img9, (i * sprite_size), (j * sprite_size), null);
                }
                if (tiles[y][x][2] == 9) {
                    g2d.setColor(Color.ORANGE);
                    g2d.fillRect((i * sprite_size), (j * sprite_size), 32, 32);
                    g2d.setColor(Color.MAGENTA);
                }
                else if (tiles[y][x][1] > 9) {
                    g2d.fillRect((i * sprite_size), (j * sprite_size), 32, 32);
                } else if (tiles[y][x][2] > 9) {
                    g2d.fillRect((i * sprite_size), (j * sprite_size), 32, 32);
                }
            }
        }
    }

    public void inventory_paint(
            Graphics2D g2d, int[] inventory, int inventory_in, int width,
            BufferedImage img7) {
        for (int i = 0; i < inventory.length; i++) {
            if (i != inventory_in) {
                g2d.setColor(new Color(228, 245, 143, 200));
            } else {
                g2d.setColor(new Color(141, 180, 25, 200));
            }
            g2d.fillRect(width * 2 + (i * 35) + 10, 0, 32, 32);
            if (inventory[i] == 7) {
                g2d.drawImage(img7, width * 2 + (i * 35) + 10, 0, null);
            }
        }
    }

    public void map_paint(
        Graphics2D g2d, int world_height, int world_width, int[][][] world_tiles, int player_y, int pleyer_x) {

        for (int i = 0; i < world_height; i++) {
            for (int j = 0; j < world_width; j++) {
                if (world_tiles[i][j][1] == 1) {
                    g2d.setColor(new Color(24, 231, 85, 200));
                    g2d.fillRect(j * 2, i * 2, 2, 2);
                } else if (world_tiles[i][j][1] == 2) {
                    g2d.setColor(new Color(19, 139, 54, 200));
                    g2d.fillRect(j * 2, i * 2, 2, 2);
                } else if (world_tiles[i][j][1] == 3) {
                    g2d.setColor(new Color(149, 95, 65, 200));
                    g2d.fillRect(j * 2, i * 2, 2, 2);
                } else if (world_tiles[i][j][1] == 4) {
                    g2d.setColor(new Color(186, 123, 86, 200));
                    g2d.fillRect(j * 2, i * 2, 2, 2);
                } else if (world_tiles[i][j][1] == 5) {
                    g2d.setColor(new Color(224, 223, 224, 200));
                    g2d.fillRect(j * 2, i * 2, 2, 2);
                } else if (world_tiles[i][j][1] == 6) {
                    g2d.setColor(new Color(146, 74, 6, 200));
                    g2d.fillRect(j * 2, i * 2, 2, 2);
                } else if (world_tiles[i][j][2] == 8) {
                    g2d.setColor(Color.ORANGE);
                    g2d.fillRect(j * 2 - 1, i * 2 - 1, 4, 4);
                }
            }
        }

        g2d.setColor(new Color(255, 0, 0, 200));
        g2d.fillRect(pleyer_x * 2 - 1, player_y  * 2 - 1, 4, 4);

        g2d.setColor(Color.GRAY);
        g2d.fillRect(world_width  * 2, 0, 2, world_height  * 2);
        g2d.fillRect(0, world_height * 2, world_width * 2 + 2, 2);
    }

    public void flags_paint(
            int[][] flags, int[][][] world_tiles) {
        for (int[] flag : flags) {
            world_tiles[flag[0]][flag[1]][2] = 9;
        }
    }

    public void npc_paint(
            Graphics2D g2d, int[][] npc, int screen_y, int screen_x,
            BufferedImage img0) {
        for (int[] ints : npc) {
            g2d.drawImage(img0, (ints[0] * 32) - (screen_x * 32),
                    (ints[1] * 32) - (screen_y * 32), null);
        }
    }

    public void player_paint(
            Graphics2D g2d, int player_screen_y, int player_screen_x, int sprite_size,
            BufferedImage img0_0, BufferedImage img0_1, BufferedImage img0_2) {
        long i = System.currentTimeMillis() / 200 % 3;
        if (i == 0) {
            g2d.drawImage(img0_0, player_screen_x * sprite_size, player_screen_y * sprite_size, null);
        } else if (i == 1) {
            g2d.drawImage(img0_1, player_screen_x * sprite_size, player_screen_y * sprite_size, null);
        } else if (i == 2) {
            g2d.drawImage(img0_2, player_screen_x * sprite_size, player_screen_y * sprite_size, null);
        }
    }

    public void coins_paint(int mode, JLabel coins, Font coins_font) {
        if (mode == 0) {
            coins.setLocation(1219, -1);
        } else if (mode == 1) {
            coins.setLocation(1187, -1);
        }
        coins.setFont(coins_font);
    }

    public void redactor_mode_tiles_paint (
            Graphics2D g2d, int mode,
            BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4, BufferedImage img5,
            BufferedImage img6) {
        if (mode == 1) {
            g2d.drawImage(img1, 1250, 0, null);
            g2d.drawImage(img2, 1250, 32, null);
            g2d.drawImage(img3, 1250, 64, null);
            g2d.drawImage(img4, 1250, 96, null);
            g2d.drawImage(img5, 1250, 128, null);
            g2d.drawImage(img6, 1250, 160, null);
        }
    }
}