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

    public String[] list_worlds() {
        JSONObject jsonO = this.json_parse();
        JSONObject worlds = (JSONObject) jsonO.get("worlds");
        String[] world_names = new String[worlds.size()];

        int i = 0;
        for (Iterator iterator = worlds.keySet().iterator(); iterator.hasNext(); i++) {
            world_names[i] = (String) iterator.next();
        }

        return world_names;
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

        JSONObject coordinate = new JSONObject();
        coordinate.put("x", player.x);
        coordinate.put("y", player.y);

        JSONObject json_player = new JSONObject();
        json_player.put("coordinate", coordinate);

        jsonO.put("player", json_player);

        this.json_save(jsonO);
    }

    public DataWorld load_world(String world_name) {
        JSONObject jsonO = this.json_parse();

        JSONObject worlds = (JSONObject) jsonO.get("worlds");
        JSONObject world = (JSONObject) worlds.get(world_name);
        JSONObject size = (JSONObject) world.get("size");

        int world_width = ((Long) size.get("width")).intValue();
        int world_height = ((Long) size.get("height")).intValue();
        int[][][] world_tiles = new int[world_height][world_width][3];

        JSONArray tiles = (JSONArray) world.get("tiles");
        Iterator columnI = tiles.iterator();

        int column = 0;
        while (columnI.hasNext()) {
            JSONArray tilesRow = (JSONArray) columnI.next();
            Iterator rowI = tilesRow.iterator();

            int row = 0;
            while (rowI.hasNext()) {
                try {
                    JSONArray tilesP = (JSONArray) rowI.next();
                    Iterator columnP = tilesP.iterator();

                    world_tiles[column][row][0] = ((Long) columnP.next()).intValue();
                    world_tiles[column][row][1] = ((Long) columnP.next()).intValue();
                    world_tiles[column][row][2] = ((Long) columnP.next()).intValue();
                } catch (Exception e) {
                    System.out.println(column + ", " + row);
                    throw e;
                }

                row++;
            }

            column++;
        }

        return new DataWorld(world_name, world_width, world_height, world_tiles);
    }

    public void save_world(DataWorld world) {
        JSONObject size = new JSONObject();
        size.put("width", world.width);
        size.put("height", world.height);

        JSONArray tiles = new JSONArray();
        for (int i = 0; i < world.height; i++) {
            JSONArray tilesRow = new JSONArray();
            for (int j = 0; j < world.width; j++) {
                JSONArray tiles3d = new JSONArray();
                tiles3d.add(world.tiles[i][j][0]);
                tiles3d.add(world.tiles[i][j][1]);
                tiles3d.add(world.tiles[i][j][2]);
                tilesRow.add(tiles3d);
            }
            tiles.add(tilesRow);
        }

        JSONObject json_world = new JSONObject();
        json_world.put("size", size);
        json_world.put("tiles", tiles);

        JSONObject jsonO = this.json_parse();

        JSONObject worlds = (JSONObject) jsonO.get("worlds");
        worlds.put(world.name, json_world);

        this.json_save(jsonO);
    }

    public void delete_world(String world_name) {
        JSONObject jsonO = this.json_parse();

        JSONObject worlds = (JSONObject) jsonO.get("worlds");
        worlds.remove(world_name);

        this.json_save(jsonO);
    }
}
