package homeWork6.structuraClassov;

/**
 * Created by Dmitriy on 26.04.2017.
 */
public class FootballPlayer extends Student{
    private String role;
    private String command;
    private int number;

    FootballPlayer(String name, String surname, String gender,
            int age, int course, String specialisation,
            int hoursOfPass, int averageScore, int form,
            int averageScoreInSchool, String role, int number, String command){
        super(name, surname, gender, age, course, specialisation, hoursOfPass, averageScore, form, averageScoreInSchool);
        this.role = role;
        this.command = command;
        this.number = number;
    }

    FootballPlayer(){
        super();
        role = "";
        command = "";
        number = -1;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("В команде состоит как: " + role);
        System.out.println("Играет в команде: " + command);
        System.out.println("Играет под номером: " + number);
    }

    public void setRole(String role){
        this.role = role;
    }

    public void setCommand(String command){
        this.command = command;
    }

    public void setNumber(int number){
        this.number = number;
    }

    public String getRole(){
        return role;
    }

    public String getCommand(){
        return command;
    }

    public int getNumber(){
        return number;
    }
}
