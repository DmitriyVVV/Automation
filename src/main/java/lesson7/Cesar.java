package lesson7;

/**
 * Created by Dmitriy on 26.04.2017.
 */
public class Cesar {
    public static void main(String[] args) {
        StringBuilder s  = new StringBuilder("abc");
        String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

        for(int i = 0; i<s.length(); i++) {
            char suka = s.charAt(i);
            int neededNum = (ALPHABET.indexOf(suka)+1)%26;
            s.setCharAt(i, ALPHABET.charAt(neededNum));
        }

        System.out.println(s);


    }
}
