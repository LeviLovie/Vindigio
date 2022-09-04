package Java_data_classes;

public class Qwests {
    Sheep sheep;
    public Qwests(String qwest_name) {
        switch (qwest_name) {
            case "Sheep": {
                sheep = new Sheep();
            }
        }
    }
}

class Sheep {
    public static void main(String[] args) {
        System.out.println("Sheep");
    }
}