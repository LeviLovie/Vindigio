package Java_data_classes;

public class MyQuests {
    public Sheep sheep;
    public MyQuests() {
        sheep = new Sheep();
    }
}

class Sheep {
    int quest_num;
    int finish_quest_num;

    public Sheep() {
        quest_num = 0;
        finish_quest_num = 1;
    }
}