package homeWork2;

import java.util.Scanner;

/**
 * Created by Dmitriy on 06.04.2017.
 */
public class Fifth {
    public static void main(String[] args)
    {
        System.out.println("Введите символ: ");
        Scanner scanner = new Scanner(System.in); // Объявляем сканнер
        String s = scanner.nextLine(); // получем введенную линию в String

        char ch = s.charAt(0);

        int i = (int)ch;

        System.out.println("Числовое представление символа " + ch + " выглядит как " +i);
    }
}
