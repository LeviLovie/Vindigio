package Java_data_classes;

public class DataNPC {
    public int[][] npc = {
        {7, 7}
    };
    public String[] nps_names = {
        "villager"
    };

    public void npc_go_to(int npc, int to_y, int to_x, int[][] tiles) {
        if (npc > this.npc.length) {throw new java.lang.Error("Java_data_classes.DataNPC: 10: " + "Npc num > npc.length");}


    }
}
