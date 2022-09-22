package Java_data_classes;
import Java_data_classes.Quests.*;

public class MyQuests {
    public Sheep sheep = new Sheep();
    public void Quest_to_null(String name) {
        if (name == "sheep") {
            this.sheep = null;
        }
    }

    public void Quest_create(String name) {
        if (name == "sheep") {
            this.sheep = new Sheep();
        }
    }
}