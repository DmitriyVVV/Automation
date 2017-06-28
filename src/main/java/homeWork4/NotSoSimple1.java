package homeWork4;

import java.util.Scanner;

/**
 * Created by Dmitriy on 14.04.2017.
 */
public class NotSoSimple1 {
    public  static void main(String[] args)
    {
        char rusAlf[] = {'а', 'б', 'в', 'г', 'д', 'е', 'ё',
                'ж', 'з', 'и', 'й',	'к', 'л', 'м', 'н',
                'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х',
                'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э',
                'ю', 'я'};

        /*char anglAlf[] = {'a', 'b', 'c', 'd', 'e', 'f',
                'h', 'i', 'k', 'l', 'm', 'n', 'o', 'p',
                'q', 'r', 's', 't', 'v', 'x', 'y', 'z'};*/

        String translitRus[] = {"a", "b", "v", "g", "d", "e", "yo", "j", "z", "i", "y",
                "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "f", "h", "ts",
                "ch", "sh", "shch", "/'", "i", "/'", "ye", "yu", "ya"};


        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();

        for(int i = 0; i<word.length(); i++)
        {
            int index;

            word.charAt(i);
            for(int k=0; k<rusAlf.length; k++)
            {
                if(rusAlf[k]==word.charAt(i))
                    System.out.print(translitRus[k]);
            }

        }

        System.out.println();
        //Scanner scanner1 = new Scanner(System.in);
        String word1 = scanner.nextLine();

        for(int i = 0; i<word1.length(); i++)
        {

            word1.charAt(i);

            char ch = word1.charAt(i);
            String s = String.valueOf(ch);

            for(int k=0; k<translitRus.length; k++)
            {
                if(translitRus[k].equals(s))
                    System.out.print(rusAlf[k]);
            }

        }
    }
}
