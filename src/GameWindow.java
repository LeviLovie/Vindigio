import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameWindow extends JPanel implements KeyListener {
    private final World world;
    public boolean game_b = true;
    private BufferedImage img0 = null;
    private BufferedImage img00 = null;
    private BufferedImage img1 = null;
    private BufferedImage img2 = null;
    private BufferedImage img3 = null;
    private BufferedImage img4 = null;
    private BufferedImage img5 = null;
    private BufferedImage img6 = null;
    private BufferedImage img7 = null;
    private final JButton world_constructor_button;
    private final JButton new_world_button;
    private final JButton change_world_button;
    private final JButton world_redactor_button;
    private final JButton menu_button;
    private final JButton game_button;
    private final JButton exit_button;
    private final JButton hext_button;
    private final JButton save_button;
    private final JButton dialog_change_butoon;
    private final JLabel gid_name;
    private final JLabel coins;
    private final Font coins_font;
    private int strings = 1;

    public GameWindow() {
        world = new World();

        try {img0 = ImageIO.read(new File("src/Tiles_tiles/0.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img00 = ImageIO.read(new File("src/Tiles_tiles/00.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img1 = ImageIO.read(new File("src/Tiles_tiles/1.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img2 = ImageIO.read(new File("src/Tiles_tiles/2.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img3 = ImageIO.read(new File("src/Tiles_tiles/3.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img4 = ImageIO.read(new File("src/Tiles_tiles/4.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img5 = ImageIO.read(new File("src/Tiles_tiles/5.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img6 = ImageIO.read(new File("src/Tiles_tiles/6.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img7 = ImageIO.read(new File("src/Tiles_tiles/7.png"));} catch (IOException ignored) {System.out.println("tile not found");}

        JPanel panel = new JPanel();
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.addKeyListener(this);
        panel.setVisible(true);
        panel.setLayout(null);

        world_redactor_button = new JButton("World redactor mode");
        world_redactor_button.setVisible(false);

        menu_button = new JButton("Menu");
        menu_button.setVisible(false);

        game_button = new JButton("Back to game");
        game_button.setVisible(false);

        world_constructor_button = new JButton("Auto world generate");
        world_constructor_button.setVisible(false);

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

        gid_name = new JLabel(world.npc.nps_names[0]);
        coins = new JLabel("C: " + world.json.coins);
        coins_font = new Font("SansSerif", Font.BOLD, 15);

        add(world_redactor_button); // TODO comment this and next line for finis compilation
//        add(menu_button);
        add(game_button);
        add(world_constructor_button);
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
        });
        hext_button.addActionListener(e -> strings++);

        save_button.addActionListener(e -> {
            world.json.save_player(world.player);
            world.json.save_world(world.world);
        });
        world_constructor_button.addActionListener(e -> world.world_constructor());
        dialog_change_butoon.addActionListener(e -> world.dialog_change());
        new_world_button.addActionListener(e -> world.new_world());
        change_world_button.addActionListener(e -> world.change_world());
        world_redactor_button.addActionListener(e -> world.mode = 1);
        world_redactor_button.addActionListener(e -> game_b = false);
        game_button.addActionListener(e -> world.mode = 0);
//        try {
//            File soundFile = new File("src/sound/music.wav");
//            //Вот тут могут полететь IOException и UnsupportedAudioFileException
//            AudioInputStream ais = AudioSystem.getAudioInputStream(soundFile);
//            //Может выкинуть LineUnavailableException
//            Clip clip = AudioSystem.getClip();
//            //Может выкинуть IOException и LineUnavailableException
//            clip.open(ais);
//            clip.setFramePosition(0);
////            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
////            gainControl.setValue(-10.0f); // Reduce volume by 10 decibels.
//            double inf = Double.POSITIVE_INFINITY;
//            clip.loop((int) inf);
////            clip.start();
//        } catch (IOException | UnsupportedAudioFileException | LineUnavailableException exc) {
//            exc.printStackTrace();
//        }
    }

    public void paintComponent(Graphics g) {
//        System.out.println("paint");
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;

        int sprite_size = this.world.sprite_size;
        int x, y;

        g2d.setColor(Color.MAGENTA);
        for (int i = 0; i < this.world.screen_width; i++) {
            for (int j = 0; j < this.world.screen_height; j++) {
                x = i + this.world.screen_x;
                y = j + this.world.screen_y;
                if (this.world.world.tiles[y][x][0] == 1) {
                    g2d.drawImage(this.img1, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][0] == 2) {
                    g2d.drawImage(this.img2, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][0] == 3) {
                    g2d.drawImage(this.img3, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][0] == 4) {
                    g2d.drawImage(this.img4, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][0] == 5) {
                    g2d.drawImage(this.img5, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][0] == 6) {
                    g2d.drawImage(this.img6, (i * sprite_size), (j * sprite_size), null);
                }
                if (this.world.world.tiles[y][x][1] == 1) {
                    g2d.drawImage(this.img1, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][1] == 2) {
                    g2d.drawImage(this.img2, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][1] == 3) {
                    g2d.drawImage(this.img3, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][1] == 4) {
                    g2d.drawImage(this.img4, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][1] == 5) {
                    g2d.drawImage(this.img5, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][1] == 6) {
                    g2d.drawImage(this.img6, (i * sprite_size), (j * sprite_size), null);
                } else if (this.world.world.tiles[y][x][1] == 7) {
                    g2d.drawImage(this.img7, (i * sprite_size), (j * sprite_size), null);
                }
                if (this.world.world.tiles[y][x][2] == 8) {
                    g2d.setColor(Color.ORANGE);
                    g2d.fillRect((i * sprite_size), (j * sprite_size), 32, 32);
                    g2d.setColor(Color.MAGENTA);
                }
                else if (this.world.world.tiles[y][x][1] > 7) {
                    g2d.fillRect((i * sprite_size), (j * sprite_size), 32, 32);
                } else if (this.world.world.tiles[y][x][2] > 7) {
                    g2d.fillRect((i * sprite_size), (j * sprite_size), 32, 32);
                }
            }
        }

        for (int i = 0; i < this.world.json.inventory.length; i++) {
            if (i != this.world.json.inventory_in) {
                g2d.setColor(new Color(228, 245, 143, 200));
            } else {
                g2d.setColor(new Color(141, 180, 25, 200));
            }
            g2d.fillRect(this.world.world.width * 2 + (i * 35) + 10, 0, 32, 32);
            if (this.world.json.inventory[i] == 7) {
                g2d.drawImage(img7, this.world.world.width * 2 + (i * 35) + 10, 0, null);
            }
        }

        for (int i = 0; i < this.world.world.height; i++) {
            for (int j = 0; j < this.world.world.width; j++) {
                if (this.world.world.tiles[i][j][1] == 1) {
                    g2d.setColor(new Color(24, 231, 85, 200));
                    g2d.fillRect(j * 2, i * 2, 2, 2);
                } else if (this.world.world.tiles[i][j][1] == 2) {
                    g2d.setColor(new Color(19, 139, 54, 200));
                    g2d.fillRect(j * 2, i * 2, 2, 2);
                } else if (this.world.world.tiles[i][j][1] == 3) {
                    g2d.setColor(new Color(149, 95, 65, 200));
                    g2d.fillRect(j * 2, i * 2, 2, 2);
                } else if (this.world.world.tiles[i][j][1] == 4) {
                    g2d.setColor(new Color(186, 123, 86, 200));
                    g2d.fillRect(j * 2, i * 2, 2, 2);
                } else if (this.world.world.tiles[i][j][1] == 5) {
                    g2d.setColor(new Color(224, 223, 224, 200));
                    g2d.fillRect(j * 2, i * 2, 2, 2);
                } else if (this.world.world.tiles[i][j][1] == 6) {
                    g2d.setColor(new Color(146, 74, 6, 200));
                    g2d.fillRect(j * 2, i * 2, 2, 2);
                } else if (this.world.world.tiles[i][j][2] == 8) {
                    g2d.setColor(Color.ORANGE);
                    g2d.fillRect(j * 2 - 1, i * 2 - 1, 4, 4);
                }
            }
        }
        g2d.setColor(new Color(255, 0, 0, 200));
        g2d.fillRect(this.world.player.x * 2 - 1, this.world.player.y  * 2 - 1, 4, 4);

        g2d.setColor(Color.GRAY);
        g2d.fillRect(this.world.world.width  * 2, 0, 2, this.world.world.height  * 2);
        g2d.fillRect(0, this.world.world.height * 2, this.world.world.width * 2 + 2, 2);

        for (int i = 0; i < this.world.flags.length; i++) {
            this.world.world.tiles[this.world.flags[i][0]][this.world.flags[i][1]][2] = 8;
        }

        for (int i = 0; i < this.world.npc.npc.length; i++) {
            g2d.drawImage(img00, (this.world.npc.npc[i][0] * 32) - (this.world.screen_x * 32),
                    (this.world.npc.npc[i][1] * 32) - (this.world.screen_y * 32), null);
        }
        this.gid_name.setText(this.world.npc.nps_names[0]);
        this.gid_name.setLocation((this.world.npc.npc[0][0] - this.world.screen_x) * 32 - 5,
                (this.world.npc.npc[0][1] - this.world.screen_y) * 32 + 40);

        int player_screen_x = this.world.get_player_screen_x();
        int player_screen_y = this.world.get_player_screen_y();
        g2d.drawImage(this.img0, player_screen_x * sprite_size, player_screen_y * sprite_size,null);

        if (this.world.mode == 0) {
            this.coins.setLocation(1219, -1);
        } else if (this.world.mode == 1) {
            this.coins.setLocation(1187, -1);
        }
        this.coins.setFont(this.coins_font);

        if (this.world.mode == 1) {
            g2d.drawImage(this.img1, 1250, 0, null);
            g2d.drawImage(this.img2, 1250, 32, null);
            g2d.drawImage(this.img3, 1250, 64, null);
            g2d.drawImage(this.img4, 1250, 96, null);
            g2d.drawImage(this.img5, 1250, 128, null);
            g2d.drawImage(this.img6, 1250, 160, null);
        }

        if (this.world.mode == 1) {
            // world redactor mode
            this.world.screen_width =  (1280 / this.world.sprite_size) - 3;
        } else if (this.world.mode == 0) {
            // game mode
            this.world.screen_width = (1280 / this.world.sprite_size) - 2;
        }

        this.hext_button.setVisible(false);

        this.pause(g2d);
    }

    public void pause(Graphics2D g2d) {
        if (this.world.pause) {
            if (this.world.mode == 1) {
                this.exit_button.setVisible(true);
            }
            if (!this.world.pause_dialog) {
                g2d.setColor(new Color(255, 255, 255, 155));
                g2d.fillRect(0, 0, 1280, 720);

                if (this.world.mode == 1) {
                    // world redactor mode
                    this.world_constructor_button.setVisible(true);
                    this.new_world_button.setVisible(true);
                    this.change_world_button.setVisible(true);
                    this.world_redactor_button.setVisible(false);
                    this.game_button.setVisible(true);
                } else if (this.world.mode == 0) {
                    // game mode
                    this.world_redactor_button.setVisible(true);
                    this.game_button.setVisible(false);
                    this.world_constructor_button.setVisible(false);
                    this.new_world_button.setVisible(false);
                    this.change_world_button.setVisible(false);
                }

                this.menu_button.setVisible(true);
                this.hext_button.setVisible(false);
                this.exit_button.setVisible(true);
                this.save_button.setVisible(true);
//            this.save_button.setBounds(200,100, 100, 100);

                for (int i = 0; i < this.world.text.result_images.length; i++) {
                    if (this.world.text.result_images[i] != null) {
                        g2d.drawImage(this.world.text.result_images[i], 11 * i, 15, null);
                    }
                }
            } else {
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
            }
        } else {
            this.menu_button.setVisible(false);
            this.world_redactor_button.setVisible(false);
            this.game_button.setVisible(false);
            this.world_constructor_button.setVisible(false);
            this.new_world_button.setVisible(false);
            this.change_world_button.setVisible(false);
            this.exit_button.setVisible(false);
            this.save_button.setVisible(false);
        }
    }

    public void keyPressed(KeyEvent e) {
        this.world.keyPressed(e);
//        System.out.println("+");
        this.revalidate();
        if (e.getKeyCode() == 27) {
            this.strings = 1;
        }
    }
    public void keyReleased (KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}