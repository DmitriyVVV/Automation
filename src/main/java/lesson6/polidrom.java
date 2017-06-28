package lesson6;

/**
 * Created by Dmitriy on 24.04.2017.
 */
public class polidrom {
    public static void main(String[] args) {
        String polidrome = "Step on no pets";
        polidrome = polidrome.toLowerCase();
        String polidrome2 = "";

        for(int i = polidrome.length()-1; i>=0; i--) {
            polidrome2+=polidrome.charAt(i);
        }

        System.out.println(polidrome2);

        if(polidrome2.equals(polidrome)) {
            System.out.println("Полиндром");
        } else {
            System.out.println("Да иди ты нахер");
        }
    }
}
