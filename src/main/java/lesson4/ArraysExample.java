package lesson4;

/**
 * Created by Dmitriy on 12.04.2017.
 */
public class ArraysExample {
    public static void main(String[] args)
    {
        int a[] = {1,2,3};

        a[0] = 1;
        a[1] = 2;
        a[2] = 3;

        char b[] = {'a','b','c'};

        boolean bool[] = {true,true,false};

        int ar[] = {-514, 25 , -95, -48, 59595, 15, 9999999, -7777};

        int min = ar[0];
        int max = ar[0];

        for(int x:ar)
        {
            min = min>x?x:min;
            max = max<x?x:max;
        }

        System.out.println("Minimum" + min);
        System.out.println("Maximum" + max);
    }
}
