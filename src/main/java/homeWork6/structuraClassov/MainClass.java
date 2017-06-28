package homeWork6.structuraClassov;

/**
 * Created by Dmitriy on 26.04.2017.
 */
public class MainClass {
    public static void main(String[] args) {
        System.out.println("Обьект класса \"Human\": ");
        Human human = new Human("Jack", "Doe", 34, "Male");
        human.getInfo();

        System.out.println();
        System.out.println("Обьект класса \"Schoolboy\": ");
        Schoolboy schoolboy = new Schoolboy("Patrick", "Star", 21, "Male", 5, 3.0);
        schoolboy.getInfo();

        System.out.println();
        System.out.println("Обьект класса \"Student\": ");
        Student student = new Student("Bob", "Spanch", "male", 22, 1, "Cook", 0, 5, 11, 5);
        student.getInfo();

        System.out.println();
        System.out.println("Обьект класса \"Worker\"");
        Worker worker = new Worker("Bil", "Cipher", "Male", 9999, 1, "Distraction",
                9999, 5, 1, 0, "Distraction", 20);
        worker.getInfo();

        System.out.println();
        System.out.println("Обьект класса \"Teacher\": ");
        Teacher teacher = new Teacher("John", "Snow", "Male", 27, 4, "Hunting",
                0, 0, 3, 0, "Swords", 1, "Wall");
        teacher.getInfo();

        System.out.println();
        System.out.println("Обьект класса \"FootballPlayer\"");
        FootballPlayer footballPlayer = new FootballPlayer("Gannibal", "Lector", "Male", 68, 8, "History",
                0, 5, 6, 4, "Golkeaper", 13, "PrettyCanibals");
        footballPlayer.getInfo();
    }
}
