import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class window extends JPanel {
    public window() {
        JPanel panel = new JPanel();

        JLabel vindigio_lable = new JLabel("Vindigio");

        panel.add(vindigio_lable);
        add(panel);
    }

    public void paintComponent(Graphics g) {
//        World_Construct();

        g.setColor(Color.black);

        final int width_tiles = 1280 / 20;
        final int height_tiles = 720 / 20;
//        System.out.println(width_tiles + "/" + height_tiles);
        int[][] world_tiles = new int[width_tiles][height_tiles];

        Random rand = new Random();
        for (int i = 0; i < 720; i += 20) {
            for (int j = 0; j < 1280; j += 20) {
                int randomNum = rand.nextInt((100 - 0) + 1) + 0;

                if (randomNum > 10 & randomNum <= 90) {
                    g.setColor(Color.GREEN);
                } else if (randomNum <= 10) {
                    g.setColor(Color.MAGENTA);
                } else if (randomNum > 90 & randomNum <= 95) {
                    g.setColor(Color.ORANGE);
                } else if (randomNum > 95) {
                    g.setColor(Color.CYAN);
                }

                g.fillRect(j, i, 20, 20);
//                System.out.println(i + "/" + j);
            }
        }

//        public static int randInt(int min, int max) {
//            Random rand;
//            int randomNum = rand.nextInt((max - min) + 1) + min;
//            return randomNum;
//        }

//        g.setColor(Color.black);
//        g.fillOval(10, 10, 100, 50);
    }

//    public int[][] World_Construct() {
//        final int width_tiles = 1280 / 720;
//        int[][] world_tiles = new int[1280/20][720/20];
//        return world_tiles;
//    }
}
