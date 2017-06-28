package homeWork4;

/**
 * Created by Dmitriy on 14.04.2017.
 */
public class Simple4And5 {
    public static void main(String[] args)
    {
        int ar[] = {1,2,3,4,5,6,7,8,9,10,11,12};

        int max =ar [0];
        int indexOfMax = 0;



        for(int i:ar){
            max = i>max?i:max;
        }

        for(int i = 0; i<ar.length; i++)
        {
            if(ar[i]==max)
            {
                indexOfMax = i;
                break;
            }
        }

        int min = ar[0];
        int indexOfMin = 0;

        for (int i:ar) {
            min = i<min?i:min;
        }

        for(int i=0; i<ar.length; i++)
        {
            if(ar[i]==min) {
                indexOfMin = i;
                break;
            }
        }

        System.out.println("Minimum " + min);
        System.out.println("Maximum " + max);

        int temp = ar[indexOfMax];
        ar[indexOfMax] = ar[indexOfMin];
        ar[indexOfMin] = temp;

        for(int i:ar)
        {
            System.out.print(i + ",");
        }


        double sum = 0;

        for(int i:ar)
        {
            sum+=i;
        }

        System.out.println();
        System.out.println("СРЗНАЧ " + sum/ar.length);
    }
}
