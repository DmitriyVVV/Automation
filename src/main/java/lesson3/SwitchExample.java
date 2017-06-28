package lesson3;

/**
 * Created by Dmitriy on 10.04.2017.
 */
public class SwitchExample {
    public static void main(String[] args){
        int i = 5;

        switch(i){
            case 1:
                System.out.println("One");
            break;

            case  2:
                System.out.println("Two");
            break;

            default:
                System.out.println("This is not One or Two");
        }
    }

}
