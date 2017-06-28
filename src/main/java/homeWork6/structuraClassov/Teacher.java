package homeWork6.structuraClassov;

/**
 * Created by Dmitriy on 26.04.2017.
 */
public class Teacher extends Student{
    private String qualification;
    private int experience;
    private String nameOfSchool;

    Teacher(String name, String surname, String gender,
           int age, int course, String specialisation,
           int hoursOfPass, int averageScore, int form,
           int averageScoreInSchool, String qualification, int experience, String nameOfSchool){
        super(name, surname, gender, age, course, specialisation, hoursOfPass, averageScore, form, averageScoreInSchool);
        this.qualification = qualification;
        this.experience = experience;
        this.nameOfSchool = nameOfSchool;
    }

    Teacher(){
        super();
        this.qualification = "";
        this.experience = -1;
        this.nameOfSchool = "";
    }

    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Специальность преподавателя: " + qualification);
        System.out.println("Опыт работы: " + experience);
        System.out.println("Название школы в которой преподает: " + nameOfSchool);
    }

    public void setQualification(String qualification){
        this.qualification = qualification;
    }

    public void setExperience(int experience){
        this.experience = experience;
    }

    public void setNameOfSchool(String nameOfSchool){
        this.nameOfSchool = nameOfSchool;
    }

    public String getQualification(){
        return qualification;
    }

    public String getNameOfSchool(){
        return nameOfSchool;
    }

    public int getExperience(){
        return experience;
    }
}
