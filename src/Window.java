import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Window extends JPanel implements KeyListener {
    World world;
    private boolean map = true;
    BufferedImage img0 = null;
    BufferedImage img00 = null;
    BufferedImage img1 = null;
    BufferedImage img2 = null;
    BufferedImage img3 = null;
    BufferedImage img4 = null;
    BufferedImage img5 = null;
    BufferedImage img6 = null;

    private final JButton world_constructor_button;
    private final JButton new_world_button;
    private final JButton change_world_button;
    private final JButton world_redactor_button;
    private final JButton game_button;
    private final JButton exit_button;
    private final JButton hext_button;
    private final JButton save_button;
    private final JButton dialog_change_butoon;
    private final JLabel gid_name;
    private JLabel coins;
    Font coins_font;
    private int strings = 1;

    public Window() {
        world = new World();

        try {img0 = ImageIO.read(new File("src/Tiles_tiles/0.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img00 = ImageIO.read(new File("src/Tiles_tiles/00.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img1 = ImageIO.read(new File("src/Tiles_tiles/1.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img2 = ImageIO.read(new File("src/Tiles_tiles/2.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img3 = ImageIO.read(new File("src/Tiles_tiles/3.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img4 = ImageIO.read(new File("src/Tiles_tiles/4.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img5 = ImageIO.read(new File("src/Tiles_tiles/5.png"));} catch (IOException ignored) {System.out.println("tile not found");}
        try {img6 = ImageIO.read(new File("src/Tiles_tiles/6.png"));} catch (IOException ignored) {System.out.println("tile not found");}

        JPanel panel = new JPanel();
        panel.setFocusable(true);
        panel.requestFocusInWindow();
        panel.addKeyListener(this);
        panel.setVisible(true);
        panel.setLayout(null);

        this.world_redactor_button = new JButton("World redactor mode");
        this.world_redactor_button.setVisible(false);

        this.game_button = new JButton("Back to game");
        this.game_button.setVisible(false);

        this.world_constructor_button = new JButton("Auto world generate");
        this.world_constructor_button.setVisible(false);

        this.new_world_button = new JButton("Create new world");
        this.new_world_button.setVisible(false);

        this.change_world_button = new JButton("Change world");
        this.change_world_button.setVisible(false);

        this.exit_button = new JButton("Exit");
        this.exit_button.setVisible(false);

        this.hext_button = new JButton("Next");
        this.hext_button.setVisible(false);

        this.save_button = new JButton("Save");
        this.save_button.setVisible(false);

        this.dialog_change_butoon = new JButton("Dialog change");
        this.dialog_change_butoon.setVisible(false);

        this.gid_name = new JLabel(this.world.npc.nps_names[0]);
        this.coins = new JLabel("C: " + this.world.json.coins);
        this.coins_font = new Font("SansSerif", Font.BOLD, 15);

        add(this.world_redactor_button); // TODO comment this and next line for finis compilation
        add(this.game_button);
        add(this.world_constructor_button);
        add(this.new_world_button);
        add(this.change_world_button);
        add(this.exit_button);
        add(this.hext_button);
        add(this.save_button);
        add(this.dialog_change_butoon);
        add(this.coins);

        add(world);
        add(panel);

        this.exit_button.addActionListener(e -> {
            world.pause = false;
            world.pause_dialog = false;
        });
        this.hext_button.addActionListener(e -> this.strings++);

        this.save_button.addActionListener(e -> {
            if (this.world.mode == 1) {
                // world redactor mode
                this.world.json.save_player(this.world.player);
                this.world.json.save_world(this.world.world);
//                System.out.println(this.world.json.villager_y + ", " + this.world.json.villager_x + " = " +
//                        this.world.npc.npc[0][0] + ", " + this.world.npc.npc[0][1]);
                this.world.json.villager_y = this.world.npc.npc[0][0];
                this.world.json.villager_x = this.world.npc.npc[0][1];
//                System.out.println(this.world.json.villager_y + ", " + this.world.json.villager_x + " = " +
//                        this.world.npc.npc[0][0] + ", " + this.world.npc.npc[0][1]);
                this.world.json.save_npc("villager");
            } else if (this.world.mode == 0) {
                // game mode
                this.world.json.save_player(this.world.player);
            }
        });
        this.world_constructor_button.addActionListener(e -> world.world_constructor());
        this.dialog_change_butoon.addActionListener(e -> this.world.dialog_change());
        this.new_world_button.addActionListener(e -> world.new_world());
        this.change_world_button.addActionListener(e -> world.change_world());
        this.world_redactor_button.addActionListener(e -> world.mode = 1);
        this.game_button.addActionListener(e -> world.mode = 0);
    }

    public void paintComponent(Graphics g) {
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
                }
                else if (this.world.world.tiles[y][x][1] > 6) {
                    g2d.fillRect((i * sprite_size), (j * sprite_size), 32, 32);
                } else if (this.world.world.tiles[y][x][2] > 6) {
                    g2d.fillRect((i * sprite_size), (j * sprite_size), 32, 32);
                }
            }
        }

        for (int i = 0; i < this.world.world.height; i++) {
            for (int j = 0; j < this.world.world.width; j++) {
                if (this.world.world.tiles[i][j][1] == 1) {
                    if (this.map) {
                        g2d.setColor(new Color(24, 231, 85, 200));
                        g2d.fillRect(j * 4, i * 4, 4, 4);
                    }
                } else if (this.world.world.tiles[i][j][1] == 2) {
                    if (this.map) {
                        g2d.setColor(new Color(19, 139, 54, 200));
                        g2d.fillRect(j * 4, i * 4, 4, 4);
                    }
                } else if (this.world.world.tiles[i][j][1] == 3) {
                    if (this.map) {
                        g2d.setColor(new Color(149, 95, 65, 200));
                        g2d.fillRect(j * 4, i * 4, 4, 4);
                    }
                } else if (this.world.world.tiles[i][j][1] == 4) {
                    if (this.map) {
                        g2d.setColor(new Color(186, 123, 86, 200));
                        g2d.fillRect(j * 4, i * 4, 4, 4);
                    }
                } else if (this.world.world.tiles[i][j][1] == 5) {
                    if (this.map) {
                        g2d.setColor(new Color(224, 223, 224, 200));
                        g2d.fillRect(j * 4, i * 4, 4, 4);
                    }
                } else if (this.world.world.tiles[i][j][1] == 6) {
                    if (this.map) {
                        g2d.setColor(new Color(146, 74, 6, 200));
                        g2d.fillRect(i * 4, j * 4, 4, 4);
                    }
                }
                if (this.map) {
                    g2d.setColor(new Color(255, 0, 0, 200));
                    g2d.fillRect(this.world.player.x * 4, this.world.player.y * 4, 4, 4);
                }
            }
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
                hext_button.setLocation(815, 620);

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
                if (this.world.mode == 1) {
                    this.dialog_change_butoon.setVisible(true);
//                    g2d.setColor(Color.RED);

//                    g2d.fillRect(375, 350 + (this.world.string_pr * 15), 10, 15);

                } else {
                    this.dialog_change_butoon.setVisible(false);
                }
            }
        } else {
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
        System.out.println("+");
        this.revalidate();
        if (e.getKeyCode() == 27) {
            this.strings = 1;
        }
    }
    public void keyReleased (KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}