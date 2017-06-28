package homeWork5;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Dmitriy on 20.04.2017.
 */
public class Game {
    public static void main(String[] args)
    {
        Random rnd = new Random(System.currentTimeMillis());
        int target = rnd.nextInt(100+1);

        System.out.println("Введите своё число: ");
        Scanner scanner = new Scanner(System.in);
        String x = scanner.nextLine();

        int numOfPlayer = Integer.valueOf(x);

        int numOfComputer = rnd.nextInt(100+1);
        System.out.println("Ход соперника: " + numOfComputer);

        if(Math.abs(target - numOfPlayer)<Math.abs(target - numOfComputer))
        {
            System.out.println("Вы победили!!!");
            System.out.println("Загаданное число: " + target);
        }
        else if (Math.abs(target - numOfPlayer)>Math.abs(target - numOfComputer))
        {
            System.out.println("Вы проиграли!!!");
            System.out.println("Загаданное число: " + target);
        }
        else
        {
            System.out.println("Ничья");
            System.out.println("Загаданное число: " + target);
        }
    }
}
