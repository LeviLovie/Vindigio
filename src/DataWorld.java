public class DataWorld {
    public String name;
    public int width;
    public int height;
    public int[][][] tiles;

    public int[] collision_numbs = {3, 5, 6};

    public DataWorld(String name, int width, int height, int[][][] tiles) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.tiles = tiles;
    }

    public boolean can_go_to(int x, int y) {
        boolean result = true;
        for (int i = 0; i < 3; i++) {
            if (tiles[x][y][1] == collision_numbs[i]) {
//                System.out.println(x + ", " + y + ":  + false");
                result = false;
                break;
            }
        }
        return result;
//        throw new java.lang.Error("DataWorld.can_go_to: what?");
    }
}
