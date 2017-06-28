package homeWork6.structuraClassov;

/**
 * Created by Dmitriy on 26.04.2017.
 */
public class Schoolboy extends Human{
    private int form;
    private double averageScore;

    Schoolboy(String name, String surname, int age, String gender, int form, double averageScore){
        super(name, surname, age, gender);
        this.averageScore = averageScore;
        this.form = form;
    }

    Schoolboy(){
        super();
        this.averageScore = -1;
        this.form = -1;
    }



    @Override
    public void getInfo() {
        super.getInfo();
        System.out.println("Учиться в классе: " + form);
        System.out.println("Имеет средний бал: " + averageScore + " за " + form + " класс");
    }

    public void setForm(int form){
        this.form = form;
    }

    public void setAverageScore(){
        this.averageScore = averageScore;
    }

    public int getForm(){
        return form;
    }

    public double getAverageScore(){
        return averageScore;
    }
}