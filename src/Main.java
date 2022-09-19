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
//    TerminalWindow terminalwindow;

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

//        terminalwindow = new TerminalWindow();
//        TerminalFrame.setTitle("Vindigio terminal");
//        TerminalFrame.setLocation(1280, 720 + 50);
//        TerminalFrame.setSize(500, 280);
//        TerminalFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
//        TerminalFrame.setResizable(false);
//        TerminalFrame.add(terminalwindow);
////        log.info("Game window added");
//        TerminalFrame.setVisible(true);

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

        Timer timer;
        timer = new Timer(0, e -> {
            if (this.game_window.repint) {
                GameFrame.repaint();
                TerminalFrame.repaint();
            }

//            if (this.terminalwindow.textField.getText() != null) {
////                System.out.println(this.terminalwindow.textField.getText());
//                if (this.terminalwindow.textField.getText() == "true") {
//                    System.out.println("true");
//                }
////                if (this.terminalwindow.textField.getText() == "quest = true") {
////                    System.out.println(true);
//////                    this.game_window.world.pause = true;
//////                    this.game_window.world.pause_qwest = true;
//////                    this.game_window.world.pause_dialog = false;
////                    this.terminalwindow.textField.setText(null);
////                } else if (this.terminalwindow.textField.getText() == "quest = false") {
////                    System.out.println(false);
//////                    this.game_window.world.pause = false;
//////                    this.game_window.world.pause_qwest = false;
//////                    this.game_window.world.pause_dialog = false;
////                    this.terminalwindow.textField.setText(null);
////                }
//            }
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
        sond_timer.start();

        music();
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
