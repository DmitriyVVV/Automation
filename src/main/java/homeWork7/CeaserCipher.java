package homeWork7;


/**
 * Created by Dmitriy on 04.05.2017.
 */
public class CeaserCipher {

        public static StringBuilder decode(StringBuilder s){
            String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

            for(int i = 0; i<s.length(); i++) {
                char suka = s.charAt(i);
                int neededNum = (ALPHABET.indexOf(suka)+1)%26;
                s.setCharAt(i, ALPHABET.charAt(neededNum));
            }

            return s;
        }

        public static StringBuilder uncode(StringBuilder s){
            String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
            for(int i = 0; i<s.length(); i++) {
                char suka = s.charAt(i);
                if(ALPHABET.indexOf(suka)==0){
                    s.setCharAt(i, 'z');
                } else {
                    int neededNum = (ALPHABET.indexOf(suka)-1)%26;
                    s.setCharAt(i, ALPHABET.charAt(neededNum));
                }
            }
            return s;
        }

        public static void main(String[] args) {

            StringBuilder s = new StringBuilder("qwerty");
            StringBuilder s1 = new StringBuilder(decode(s));
            System.out.println(s1);
            System.out.println(uncode(s1));
    }
}
