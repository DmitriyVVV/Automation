package homeWork5;


import java.util.Scanner;

/**
 * Created by Dmitriy on 20.04.2017.
 */
public class CompareStrings {
    public static void main(String[] args)
    {
        System.out.println("Выберите желаемую опцию: ");
        System.out.println("1. Сравнить строки на равенство \n 2. Сравнить строки без учета регистра \n 3. Сравнить строки без учета пробелов между буквами/словами");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        System.out.println("Введите первую строку");
        String s1 = scanner.nextLine();
        System.out.println("Введите вторую строку");
        String s2 = scanner.nextLine();

        int x = Integer.valueOf(s);
        switch (x)
        {
            case 1:
            {
                if(s1.equals(s2))
                {
                    System.out.println("Строки равны");
                }
                else
                {
                    System.out.println("Строки не равны");
                }
            }
            break;

            case 2:
            {
                if(s1.equalsIgnoreCase(s2))
                {
                    System.out.println("Строки равны, без учета регистра");
                }
                else
                {
                    System.out.println("Строки разные, без учета регистра");
                }
            }
            break;

            case 3:
            {
                String s11 = s1.replaceAll(" ", "");
                String s21 = s2.replaceAll(" ", "");
                if(s11.equals(s21))
                {
                    System.out.println("Строки равны без учета пробелов");
                }
                else
                {
                    System.out.println("Строки разныйе без учета пробелов");
                }
            }
            break;
        }
    }
}