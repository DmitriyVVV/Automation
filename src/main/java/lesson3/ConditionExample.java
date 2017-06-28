package lesson3;

/**
 * Created by Dmitriy on 10.04.2017.
 */
public class ConditionExample {
    public static void main(String[] args){

        int a, b;
        a = b = 5;

        if(a==b) {
            System.out.println("a и b равны!");
        }
        else {
            System.out.println("a и b не равны!");
        }

        System.out.println(a==b?"a и b равны!":"a и b не равны!");
    }
}
