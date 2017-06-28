package lesson4;

import java.util.Arrays;

/**
 * Created by Dmitriy on 12.04.2017.
 */
public class BuubleSort {
    public static void main(String[] args)
    {
        int ar[] = {5614, -541, 5415, 41, 12, 0, 87, -3};

        int temp = ar[0];

        /*for(int x = 0; x<ar.length; x++) {
            for (int y = 0; y<ar.length-1; y++) {
                if (ar[x] > ar[y]) {
                    temp = ar[x];
                    ar[x] = ar[y];
                    ar[y] = temp;
                }
            }
        }*/

        Arrays.sort(ar); //сортировка по возрастанию

        for(int i:ar)
            System.out.print(i + " ");


    }
}
