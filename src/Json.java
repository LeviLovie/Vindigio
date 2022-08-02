import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class Json {
    static final String json_filename = "src/Data.json";

    public JSONObject json_parse() {
        JSONObject jsonO = new JSONObject();

        JSONParser parser = new JSONParser();
        try {
            jsonO = (JSONObject) parser.parse(new FileReader(this.json_filename));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return jsonO;
    }

    public void json_save(JSONObject jsonO) {
        try (FileWriter file = new FileWriter(this.json_filename)) {
            file.write(jsonO.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public DataPlayer load_player() {
        JSONObject jsonO = this.json_parse();

        JSONObject player = (JSONObject) jsonO.get("player");
        JSONObject coordinate = (JSONObject) player.get("coordinate");

        int player_x = ((Long) coordinate.get("x")).intValue();
        int player_y = ((Long) coordinate.get("y")).intValue();

        return new DataPlayer(player_x, player_y);
    }

    public void save_player(DataPlayer player) {
        JSONObject jsonO = this.json_parse();

        JSONObject json_player = (JSONObject) jsonO.get("player");
        JSONObject coordinate = (JSONObject) json_player.get("coordinate");

        coordinate.put("x", player.x);
        coordinate.put("y", player.y);

        this.json_save(jsonO);
    }

    public DataWorld load_world(String world_name) {
        JSONObject jsonO = this.json_parse();

        JSONObject worlds = (JSONObject) jsonO.get("worlds");
        JSONObject world = (JSONObject) worlds.get(world_name);
        JSONObject size = (JSONObject) world.get("size");

        int world_width = ((Long) size.get("width")).intValue();
        int world_height = ((Long) size.get("height")).intValue();
        int[][] world_tiles = new int[world_height][world_width];

        JSONArray columnsContent = (JSONArray) world.get("tiles");
        Iterator columnI = columnsContent.iterator();

        int column = 0;
        while (columnI.hasNext()) {
            JSONArray rowsContent = (JSONArray) columnI.next();
            Iterator rowI = rowsContent.iterator();

            int row = 0;
            while (rowI.hasNext()) {
                world_tiles[column][row] = ((Long) rowI.next()).intValue();
                row++;
            }

            column++;
        }

        return new DataWorld(world_name, world_width, world_height, world_tiles);
    }

    public void save_world(DataWorld world) {
        JSONObject jsonO = this.json_parse();

        JSONObject worlds = (JSONObject) jsonO.get("worlds");
        JSONObject json_world = (JSONObject) worlds.get(world.name);
        JSONObject size = (JSONObject) json_world.get("size");

        size.put("width", world.width);
        size.put("height", world.height);

        JSONArray columnsContent = new JSONArray();
        for (int i = 0; i < world.height; i++) {
            JSONArray rowsContent = new JSONArray();
            for (int j = 0; j < world.width; j++) {
                rowsContent.add(world.tiles[i][j]);
            }
            columnsContent.add(rowsContent);
        }

        json_world.put("tiles", columnsContent);

        this.json_save(jsonO);
    }
}
