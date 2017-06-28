package homeWork6.structuraClassov;

/**
 * Created by Dmitriy on 26.04.2017.
 */
public class Student extends Schoolboy{
    private int course;
    private String specialisation;
    private int hoursOfPass;
    private double averageScore;

    Student(String name, String surname, String gender,
            int age, int course, String specialisation,
            int hoursOfPass, int averageScore, int form, int averageScoreInSchool){
        super(name, surname, age, gender, form, averageScoreInSchool);
        this.course = course;
        this.specialisation = specialisation;
        this.hoursOfPass = hoursOfPass;
        this.averageScore = averageScore;
    }

    Student(){
        super();
        course = -1;
        specialisation = "";
        hoursOfPass = -1;
        averageScore = -1;
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Учиться на " + course + " курсе");
        System.out.println("По специальности " + specialisation);
        System.out.println("Пропустил " + hoursOfPass + " часов");
        System.out.println("Средний бал за " + course + " курс: " + averageScore);
    }

    public void setCourse(int Course){
        this.course = course;
    }

    public void setCSpecialisation(String specialisation){
        this.specialisation = specialisation;
    }

    public void setHoursOfPass(int hoursOfPass){
        this.hoursOfPass = hoursOfPass;
    }

    public void setAverageScore(double averageScore){
        this.averageScore = averageScore;
    }

    public int getCourse(){
        return course;
    }

    public int getHoursOfPass(){
        return hoursOfPass;
    }

    public double getAverageScore(){
        return averageScore;
    }

    public String getSpecialisation(){
        return specialisation;
    }
}
