package homeWork4;

/**
 * Created by Dmitriy on 14.04.2017.
 */
public class Simple2 {
    public static void main(String[] args)
    {
        int ar[] = {12, 45, -78 , 45 , 45 , -78 , 34 , 33};

        int min = ar[0];

        for(int i:ar)
        {
           min = i<min?i:min;
        }

        System.out.println("Minimum " + min);

        for(int q = 0; q<ar.length; q++)
        {
            if(ar[q]==min)
            {
                System.out.println("ar[" + q + "] = " +ar[q]);
            }

        }

        int max = ar[0];

        for(int g:ar)
        {
            max = g>max?g:max;
        }

        System.out.println("Maximum " + max);


    }
}
