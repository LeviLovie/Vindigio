import Game.GameWindow;
import Menu.MenuWindow;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Main extends JFrame {
    JFrame frame = new JFrame();

    GameWindow game_window;
    MenuWindow menu_window;

    boolean is_menu = true;

    public Main() {
        menu_window = new MenuWindow();
        game_window = new GameWindow();

        frame.setTitle("Vindigio");
        frame.setLocation(0, 0);
        frame.setSize(1280, 720 + 28);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
//        frame.add(menu_window);
//        TODO no comment back line and comment next line  for finish compilation
        frame.add(menu_window);
        frame.setVisible(true);

        Timer timer;
        timer = new Timer(0, e -> {
            frame.repaint();
//            frame.revalidate();
            if (is_menu == true) {
                if (this.menu_window.menu == false) {
                    frame.add(game_window);
                    frame.remove(menu_window);
                    this.game_window.game_b = true;
                    is_menu = false;
                }
            } else {
                if (this.game_window.game_b == false) {
                    frame.add(menu_window);
                    frame.remove(game_window);
                    this.menu_window.menu = true;
                    is_menu = true;
                }
            }
        });
        timer.setRepeats(true);
        // Aprox. 60 FPS
        timer.setDelay(17);
        timer.start();

//        for (;;) {
//            File audioFile = new File("src/Images_and_sound/sound/back.wav");
//            AudioInputStream audioStream = null;
//            try {
//                audioStream = AudioSystem.getAudioInputStream(audioFile);
//            } catch (UnsupportedAudioFileException ex) {
//                throw new RuntimeException(ex);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//
//            AudioFormat format = audioStream.getFormat();
//            DataLine.Info info = new DataLine.Info(Clip.class, format);
//
//            Clip audioClip = null;
//            try {
//                audioClip = (Clip) AudioSystem.getLine(info);
//            } catch (LineUnavailableException ex) {
//                throw new RuntimeException(ex);
//            }
//
//            try {
//                audioClip.open(audioStream);
//            } catch (LineUnavailableException ex) {
//                throw new RuntimeException(ex);
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
////            audioClip.start();
//        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
