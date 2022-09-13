import Game.GameWindow;
import Menu.MenuWindow;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
//import java.io.FileInputStream;
import java.io.IOException;
//import java.io.InputStream;
//import java.security.Provider;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Properties;
import java.util.Random;
import java.util.logging.*;

public class Main extends JFrame {
    JFrame frame = new JFrame();
    GameWindow game_window;
    MenuWindow menu_window;

    public Main() {
//        Logger log = Logger.getLogger(Main.class.getName());
//        try {
//            FileHandler fileHandler = new FileHandler("src/Logs/Log_Main.log", true);
//            SimpleFormatter simple = new SimpleFormatter();
//            fileHandler.setFormatter(simple);
//            log.addHandler(fileHandler);
//        } catch (IOException e) {
//            System.out.println();
//        }
        menu_window = new MenuWindow();
        game_window = new GameWindow();

        frame.setTitle("Vindigio");
        frame.setLocation(0, 0);
        frame.setSize(1280, 720 + 28);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
//        frame.add(menu_window);
//        TODO no comment back line and comment next line  for finish compilation
        frame.add(game_window);
//        log.info("Game window added");
        frame.setVisible(true);

        Timer timer;
        timer = new Timer(0, e -> {
            if (this.game_window.repint) {
                frame.repaint();
            }
//            frame.revalidate();

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

//        Timer sond_timer;
//        sond_timer = new Timer(0, e -> {
//            Random random = new Random();
//            int random_num = random.nextInt(1, 3);
////            System.out.println("music_start: " + random_num);
//            if (random_num == 1) {
//                music("musc1");
//                log.info("Musc1 play");
//            } else if (random_num == 2) {
//                music("musc2");
//                log.info("Musc2 play");
//            }
//        });
//        sond_timer.setRepeats(true);
//        sond_timer.setDelay(25000);
//        sond_timer.start();

//        music();
    }

    public static void main(String[] args) {
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

        new Main();
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
        Timer timer = new Timer(250, e -> {
            play("src/Images_and_sound/sound/f.wav");
        }); timer.start();
        Timer timer2 = new Timer(200, e -> {
            play("src/Images_and_sound/sound/g.wav");
        }); timer2.start();
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
