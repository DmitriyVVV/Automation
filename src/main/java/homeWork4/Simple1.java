package homeWork4;

/**
 * Created by Dmitriy on 14.04.2017.
 */
public class Simple1 {
    public static void main(String[] args)
    {
        int ar[] = new int[10];
        int count = 0;

        for(int i = 0; i<20; i++)
        {
            if((i%2)!=0)
            {
                ar[count]=i;
                count++;
            }
        }

        for(int c:ar)
        {
            System.out.print(c + ", ");
        }

    }
}
