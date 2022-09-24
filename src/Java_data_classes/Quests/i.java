package Java_data_classes.Quests;

public class i {
    int quest_num;
    int finish_quest_num;
    String task = "Press i";
    public i() {
        quest_num = 0;
        finish_quest_num = 2;
    }

    public String Get_task() {
        return this.task;
    }
    public int Get_quest_num() {
        return this.quest_num;
    }
    public void Set_quest_num(int num) {
        this.quest_num = num;
    }
    public int Get_finish_quest_num() {
        return this.finish_quest_num;
    }
    public void Set_finish_quest_num(int num) {
        this.finish_quest_num = num;
    }
}
