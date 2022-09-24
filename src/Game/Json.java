package Game;

import Java_data_classes.DataPlayer;
import Java_data_classes.DataQwest;
import Java_data_classes.DataWorld;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class Json {
    public int villager_x;
    public int villager_y;
    public int coins;
    private static final String path_in_resuorces = "Vindigio/src/Json_data/Data.json";
    private static final String path_in_local_resuorces = "src/Json_data/Data.json";
    private final String path_to_resurces = System.getProperty("user.home") + "/Library/";
    public String[] texts = new String[64];
    public int[] inventory = new int[5];
    public int inventory_in;
    private String quest_num;

    public JSONObject json_parse() {
        JSONObject jsonO = new JSONObject();
//        JSONObject json1 = new JSONObject();
        JSONParser parser = new JSONParser();

        try {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream("src");
        } catch (Exception e) {
            System.out.println(e);
        }

//        System.out.println(json_filename);

        try {
            jsonO = (JSONObject) parser.parse(new FileReader(path_to_resurces + path_in_resuorces));
//            jsonO = (JSONObject) parser.parse(new FileReader(path_in_local_resuorces));
        } catch (IOException | ParseException e) {
//            System.out.println("Create new directory");
////            File file = new File("~/Documents/Vindigio/src");
//            String path = "~/documents/test/test2";
//            File file = new File(path);
//            file.mkdirs();
//            file.mkdirs();
            e.printStackTrace();
        }

        return jsonO;
    }

    public void json_save(JSONObject jsonO) {
        try (FileWriter file = new FileWriter(path_in_resuorces)) {
            file.write(jsonO.toJSONString());
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dialog_load(String npc_name, String dialog_name) {
        JSONObject jsonO = this.json_parse();

        Arrays.fill(this.texts, "");

        JSONObject dialogs = (JSONObject) jsonO.get("dialogs");
        JSONObject npc = (JSONObject) dialogs.get(npc_name);
        JSONObject dialog = (JSONObject) npc.get(dialog_name);

        JSONArray texts = (JSONArray) dialog.get("text");
        Iterator iter = texts.iterator();

        int text_num = 0;
        while (iter.hasNext()) {
            this.texts[text_num] = ((String) iter.next());
            text_num++;
        }
    }

    public void dialog_save(String npc_name, String num, String[] text) {
        JSONObject jsonO = this.json_parse();
        JSONObject dialogs = new JSONObject();
        JSONObject npc = new JSONObject();
        JSONObject jnum = new JSONObject();
        JSONArray jtext = new JSONArray();

        Collections.addAll(jtext, text);

        jnum.put("text", jtext);
        npc.put(num, jnum);
        dialogs.put(npc_name, npc);
        jsonO.put("dialogs", dialogs);


        this.json_save(jsonO);
    }

    public DataQwest qwest_load(String qwest_name) {
//        "shep": {
//              "title": "Save a ship!",
//              "start_if": "§if_start: game",
//              "dialog": [
//                  "Привет путник!",
//                  "Помнишь какая сильная гроза была вчера?",
//                  "Мои овцы испугались молнии,",
//                  "выломали дверь загона и убежали в лес.",
//                  "Поможешь мне пожалуйста привести их обратно в загон?"
//              ],
//              "after_start": "§in: forest, spawn: 10 ships",
//              "finish_if": "§10 ships in a Villager fence",
//              "reword": "§give: 15 coins to player"
//        }

        JSONObject json1 = new JSONObject();

        try {
            JSONParser parser = new JSONParser();
            json1 = (JSONObject) parser.parse(new FileReader("src/Json_data/Qwests.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        JSONObject qwest = (JSONObject) json1.get("shep");
//        System.out.println(qwest);
        String title = qwest.get("title").toString();
        String start_if = qwest.get("start_if").toString();
        String after_start = qwest.get("after_start").toString();
        String finish_if = qwest.get("finish_if").toString();
        String reword = qwest.get("reword").toString();

        JSONArray dialog = (JSONArray) qwest.get("dialog");
        Iterator iterator = dialog.iterator();

        String[] dialog_new = new String[128];

        int i = 0;
        while (iterator.hasNext()) {
            dialog_new[i] = (String) iterator.next();
            i++;
        }

        return new DataQwest(
                title, start_if, after_start,
                finish_if, dialog_new, reword);
    }

    public String[] list_worlds() {
        JSONObject jsonO = this.json_parse();
        JSONObject worlds = (JSONObject) jsonO.get("worlds");
        String[] world_names = new String[worlds.size()];

        int i = 0;
        for (Iterator iterator = worlds.keySet().iterator(); iterator.hasNext(); i++) {
            world_names[i] = ((String) iterator.next()).toString();
        }

        return world_names;
    }

    public DataPlayer load_player() {
        JSONObject jsonO = this.json_parse();

//        JSONObject game = (JSONObject) jsonO.get("game");
//        System.out.println(game);
        JSONObject player = (JSONObject) jsonO.get("player");
        JSONObject coordinate = (JSONObject) player.get("coordinate");
        JSONObject inventory = (JSONObject) player.get("inventory");

//        long version = ((Long) game.get("version")).intValue();
//
//        if (version != 0.2) { // TODO Change version!
//            System.err.println("Game version != data.json version");
//        }

        int player_x = ((Long) coordinate.get("x")).intValue();
        int player_y = ((Long) coordinate.get("y")).intValue();

        this.inventory[0] = ((Long) inventory.get("0")).intValue();
        this.inventory[1] = ((Long) inventory.get("1")).intValue();
        this.inventory[2] = ((Long) inventory.get("2")).intValue();
        this.inventory[3] = ((Long) inventory.get("3")).intValue();
        this.inventory[4] = ((Long) inventory.get("4")).intValue();
        this.inventory_in = ((Long) inventory.get("in")).intValue();

        this.coins = ((Long) player.get("coins")).intValue();

        return new DataPlayer(player_x, player_y, (String) player.get("quest"), ((Long) player.get("quest_num")).intValue());
    }

    public void load_npc(String nps_name) {
        JSONObject jsonO = this.json_parse();

        JSONObject npc = (JSONObject) jsonO.get("npc");
        JSONObject npc_c = (JSONObject) npc.get(nps_name);

        this.villager_x = ((Long) npc_c.get("x")).intValue();
        this.villager_y = ((Long) npc_c.get("y")).intValue();
    }

    public void save_npc(String nps_name) {
        JSONObject jsonO = this.json_parse();

        JSONObject npc_c = new JSONObject();
        npc_c.put("y", this.villager_y);
        npc_c.put("x", this.villager_x);

        JSONObject json_player = new JSONObject();
        json_player.put("villager", npc_c);

        jsonO.put("npc", json_player);

        this.json_save(jsonO);
    }

    public void save_player(DataPlayer player, String quest_name, int quest_num) {
        JSONObject jsonO = this.json_parse();

        JSONObject coordinate = new JSONObject();
        coordinate.put("x", player.x);
        coordinate.put("y", player.y);

        JSONObject inventory = new JSONObject();
        inventory.put("0", this.inventory[0]);
        inventory.put("1", this.inventory[1]);
        inventory.put("2", this.inventory[2]);
        inventory.put("3", this.inventory[3]);
        inventory.put("4", this.inventory[4]);
        inventory.put("in", this.inventory_in);

        JSONObject json_player = new JSONObject();
        json_player.put("coordinate", coordinate);
        json_player.put("coins", this.coins);
        json_player.put("inventory", inventory);
        json_player.put("quest", quest_name);
        json_player.put("quest_num", quest_num);

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
