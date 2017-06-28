package lesson3;

/**
 * Created by Dmitriy on 10.04.2017.
 */
public class StringEqualsExample {
    public static void main(String[] args){
        String str1 = new String("Привет");
        String str2 = new String("Привет");
        String sameStr = str1;

        boolean b1 = str1 == str2;
        boolean b2 = str1.equals(str2);
        boolean b3 = str1 == sameStr;

    }
}
