package Java_data_classes;
import Java_data_classes.Quests.*;

public class MyQuests {
    public j press_j = new j();
    public i press_i = new i();
    public void Quest_to_null(String name) {
        if (name == "i") {
            this.press_j = null;
        } else if (name == "j") {
            this.press_i = null;
        }
    }

    public void Quest_create(String name) {
        if (name == "i") {
            this.press_j = new j();
        } else if (name == "j") {
            this.press_i = new i();
        }
    }
}