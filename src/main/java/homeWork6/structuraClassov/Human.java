package homeWork6.structuraClassov;

/**
 * Created by Dmitriy on 26.04.2017.
 */
public class Human {
    private String name;
    private String surname;
    private int age;
    private String gender;

    Human(String name, String surname, int age, String gender){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.gender = gender;
    }

    Human(){
        name = "";
        surname = "";
        age = -1;
        gender = "";
    }

    public void getInfo(){
        System.out.println("Имя: " + name);
        System.out.println("Фамилия: " + surname);
        System.out.println("Возраст: " + age);
        System.out.println("Возраст: " + gender);
    }

    public void setName(String name){
        this.name = name;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public void setAge(String name){
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getGender(){
        return gender;
    }

    public int getAge(){
        return age;
    }
}