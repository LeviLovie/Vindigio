import Game.GameWindow;
import Menu.MenuWindow;

import javax.swing.*;

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
    }

    public static void main(String[] args) {
        new Main();
    }
}
