import org.json.simple.*;
import org.json.simple.parser.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Json {
    JSONParser parser = new JSONParser();
    private JSONObject jsonO;
    private JSONObject worlds;
    public int world_width;
    public int world_height;
    public int[][] world_tiles;

    public void json_parse() {
        try {
            jsonO = (JSONObject) parser.parse(new FileReader("src/Date.json"));
            worlds = (JSONObject) jsonO.get("worlds");
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void get_world(String load_world) {
        JSONObject world = (JSONObject) worlds.get(load_world);

        JSONObject size = (JSONObject) world.get("size");

        this.world_width = ((Long) size.get("width")).intValue();
        this.world_height = ((Long) size.get("height")).intValue();

        this.world_tiles = new int[this.world_height][this.world_width];

        JSONArray columnsContent = (JSONArray) world.get("tiles");
        Iterator columnI = columnsContent.iterator();

        int column = 0;
        while (columnI.hasNext()) {
            JSONArray rowsContent = (JSONArray) columnI.next();
            Iterator rowI = rowsContent.iterator();

            int row = 0;
            while (rowI.hasNext()) {
                this.world_tiles[column][row] = ((Long) rowI.next()).intValue();
                row++;
            }

            column++;
        }
    }
}
