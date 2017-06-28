package homeWork3;

/**
 * Created by Dmitriy on 11.04.2017.
 */
public class Seasons {
    public static void main(String[] args)
    {
        int numOfMounth = 1;

        if(numOfMounth == 12 || numOfMounth==1 || numOfMounth==2)
        {
            System.out.println("Это зима");
        }
        else if(numOfMounth == 3 || numOfMounth == 4 || numOfMounth == 5)
        {
            System.out.println("Это весна");
        }
        else if(numOfMounth == 6 || numOfMounth == 7 || numOfMounth ==8)
        {
            System.out.println("Это лето");
        }
        else if(numOfMounth == 9 || numOfMounth == 10 || numOfMounth ==11)
        {
            System.out.println("Это осень");
        }
        else
            {
                System.out.println("Такого месяца нету");
            }
    }
}
