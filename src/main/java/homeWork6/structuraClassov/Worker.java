package homeWork6.structuraClassov;

/**
 * Created by Dmitriy on 26.04.2017.
 */
public class Worker extends Student{
    private String qualification;
    private int experience;

    Worker(String name, String surname, String gender,
           int age, int course, String specialisation,
           int hoursOfPass, int averageScore, int form,
           int averageScoreInSchool, String qualification, int experience){
        super(name, surname, gender, age, course, specialisation, hoursOfPass, averageScore, form, averageScoreInSchool);
        this.qualification = qualification;
        this.experience = experience;
    }

    Worker(){
        super();
        this.qualification = "";
        this.experience = -1;
    }

    @Override
    public void getInfo(){
        super.getInfo();
        System.out.println("Имеет квалификацию " + qualification);
        System.out.println("Опыт работы " + experience + " лет");
    }

    public void setQualification(String qualification){
        this.qualification = qualification;
    }

    public void setExperience(int experience){
        this.experience = experience;
    }

    public String getQualification(){
        return qualification;
    }

    private int getExperience(){
        return experience;
    }
}
