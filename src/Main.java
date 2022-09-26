import Game.GameWindow;
import Menu.MenuWindow;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

//import java.io.InputStream;
//import java.security.Provider;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;


public class Main extends JFrame {
    JFrame GameFrame = new JFrame();
    JFrame TerminalFrame = new JFrame();
    GameWindow game_window;
    MenuWindow menu_window;

//    public void accept(MainVisitor visitor);

    public Main(String arg) {
//        System.out.println("Hello, world!");
//        menu_window = new MenuWindow();
        game_window = new GameWindow(arg);

        GameFrame.setTitle("Vindigio");
        GameFrame.setLocation(0, 0);
        GameFrame.setSize(1280, 720 + 28);
        GameFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        GameFrame.setResizable(false);
//        frame.add(menu_window);
//        TODO no comment back line and comment next line  for finish compilation
        GameFrame.add(game_window);
//        log.info("Game window added");
        GameFrame.setVisible(true);

//        System.out.println(this.game_window.world.json.where_load);
//        this.game_window.world.json.where_load = arg;
//        System.out.println(this.game_window.world.json.where_load);

        Timer timer;
        timer = new Timer(0, e -> {
            if (this.game_window.repaint) {
//                System.out.println("Repaint");
                GameFrame.repaint();
                GameFrame.revalidate();
                TerminalFrame.repaint();
            }
//            if (this.menu_window.is_menu == false) {
//                frame.remove(menu_window);
//                frame.add(game_window);
//                this.game_window.is_game = true;
//            }
//            if (this.game_window.is_game == false) {
//                frame.remove(game_window);
//                frame.add(menu_window);
//                this.menu_window.is_menu = true;
//            }
        });
        timer.setRepeats(true);
        // Aprox. 60 FPS
        timer.setDelay(17);
        timer.start();

        Timer sond_timer;
        sond_timer = new Timer(0, e -> {
            System.out.println("Play " + this.game_window.world.world.name);
            Random random = new Random();
            if (this.game_window.world.world.name == "test") {
                System.out.println("test");
                int random_num = random.nextInt(1, 3);
                if (random_num == 1) {
                    play("src/Images_and_sound/sound/Cave_sound/1.m4a");
                } else if (random_num == 2) {
                    play("src/Images_and_sound/sound/Cave_sound/2.m4a");
                }
            } else if (this.game_window.world.world.name == "grot") {
                System.out.println("grot");
                int random_num = random.nextInt(1, 4);
                if (random_num == 1) {
                    play("src/Images_and_sound/sound/Vilage_sound/1.m4a");
                } else if (random_num == 2) {
                    play("src/Images_and_sound/sound/Vilage_sound/2.m4a");
                } else if (random_num == 3) {
                    play("src/Images_and_sound/sound/Vilage_sound/3.m4a");
                }
            }
        });
        sond_timer.setRepeats(true);
        sond_timer.setDelay(30000);
//        sond_timer.start();

        music();
    }

    public static void main(String[] args) throws IOException {
//        Logger log = Logger.getLogger(Main.class.getName());
//        try {
//            FileHandler fileHandler = new FileHandler("src/Logs/Log_Main.log", true);
//            SimpleFormatter simple = new SimpleFormatter();
//            fileHandler.setFormatter(simple);
//            log.addHandler(fileHandler);
//        } catch (IOException e) {
//            System.out.println();
//        }
//        log.info("Program start");

        new Main("1");
//        Files.createDirectory(Path.of("~/documents/a"), null);
    }

//    private void music(String name) {
//        File audioFile = new File("src/Images_and_sound/sound/" + name + ".wav");
////        System.out.println("src/Images_and_sound/sound/" + name + ".wav");
//        AudioInputStream audioStream = null;
//        try {
//            audioStream = AudioSystem.getAudioInputStream(audioFile);
//        } catch (UnsupportedAudioFileException ex) {
//            throw new RuntimeException(ex);
//        } catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }
//
//        AudioFormat format = audioStream.getFormat();
//        DataLine.Info info = new DataLine.Info(Clip.class, format);
//
//        Clip audioClip = null;
//        try {
//            audioClip = (Clip) AudioSystem.getLine(info);
//        } catch (LineUnavailableException ex) {
//            throw new RuntimeException(ex);
//        }
//
//        try {
//            audioClip.open(audioStream);
//        } catch (LineUnavailableException ex) {
//            throw new RuntimeException(ex);
//        } catch (IOException ex) {
//            throw new RuntimeException(ex);
//        }
//        audioClip.start();
//    }
    public void music() {
//        Timer timer = new Timer(250, e -> {
//            play("src/Images_and_sound/sound/f.wav");
//        }); timer.start();
//        Timer timer2 = new Timer(200, e -> {
//            play("src/Images_and_sound/sound/g.wav");
//        }); timer2.start();
    }

    public void play(String path) {
        File audioFile = new File(path);
        AudioInputStream audioStream = null;
        try {
            audioStream = AudioSystem.getAudioInputStream(audioFile);
        } catch (UnsupportedAudioFileException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);

        Clip audioClip = null;
        try {
            audioClip = (Clip) AudioSystem.getLine(info);
        } catch (LineUnavailableException ex) {
            throw new RuntimeException(ex);
        }

        try {
            audioClip.open(audioStream);
        } catch (LineUnavailableException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        audioClip.start();
    }
}
