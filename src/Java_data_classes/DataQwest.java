package Java_data_classes;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class DataQwest {

//    JSONObject qwest = (JSONObject) json1.get(qwest_name);
//    JSONObject title = (JSONObject) json1.get("title");
//    JSONObject start_if = (JSONObject) json1.get("start_if");
//    JSONObject after_start = (JSONObject) json1.get("after_start");
//    JSONObject finish_if = (JSONObject) json1.get("finish_if");
//    JSONObject reword = (JSONObject) json1.get("reword");
//    JSONArray dialog = (JSONArray) json1.get("dialog");
    public String title;
    public String start_if;
    public String after_start;
    public String finish_if;
    public String[] dialog;
    public String reword;

    public DataQwest(String title, String start_if, String after_start, String finish_if, String[] dialog, String reword) {
        this.title = title;
        this.start_if = start_if;
        this.after_start = after_start;
        this.finish_if = finish_if;
        this.dialog = dialog;
        this.reword = reword;
    }
}
