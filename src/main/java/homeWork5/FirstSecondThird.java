package homeWork5;

import java.util.Scanner;

/**
 * Created by Dmitriy on 20.04.2017.
 */
public class FirstSecondThird
{
    public static void deleteSpaces(String s)
    {
        System.out.println(s.replace(" ", ""));
    }

    public static void afterNew(String s)
    {
        if(s.contains("new"))
        {
            System.out.println((s.substring(s.lastIndexOf("new"))).substring(4));
        }
    }

    public static void sumOfNumbers(String s)
    {
        String s4 = s.replaceAll(", ", " ");
        String s1 = s4 + " ";
        String s2 = "";
        String s3 = "";
        int sum = 0;
        int last = 0;


        int numOfIterations = 0;
        char ar[] = s1.toCharArray();
        for(int i = 0; i<s1.length(); i++)
        {
            if(ar[i]==' ')
            {
                numOfIterations++;
            }
        }

        for(int i = 0; i<numOfIterations; i++)
        {
            if(s1.endsWith(" "))
            s2 = s1.substring(0,s1.indexOf(" "));
            s3 = s1.substring((s1.indexOf(" "))+1);
            s1 = s3;

            int aaa = Integer.valueOf(s2);
            sum = sum + aaa;

        }
        System.out.println("Sum: " + sum);
    }


    public static void main(String[] args)
    {
        System.out.println("Введите строку: ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        deleteSpaces(str);

        System.out.println("Введите строку с символом \"new\": ");
        String str1 = scanner.nextLine();

        afterNew(str1);

        System.out.println("Введите строку цифрами: ");
        String str2 = scanner.nextLine();

        sumOfNumbers(str2);

    }
}
