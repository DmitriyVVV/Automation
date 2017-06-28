package lesson3;

/**
 * Created by Dmitriy on 10.04.2017.
 */
public class WhileExample {
    public static void main(String[] args){
        int i = 1;
        while(i<5){
            System.out.print(i+" ");
            i++;
        }

        System.out.println();

        i = 1;
        do {
            i++;
            System.out.print(i + " ");
        }while(i<5);
    }
}
