package homeWork4;

/**
 * Created by Dmitriy on 14.04.2017.
 */
public class ShellAlgorithm {
    public static void main(String[] args)
    {
        int ch[] = new int[5000];

        for(int i = 0; i<ch.length; i++)
        {
            ch[i] = (int) (Math.random()*10);
        }

        System.out.println("Before sorting: ");

        for(int i =0; i<ch.length; i++)
        {
            System.out.print(ch[i]+",");
            if(i%100==0 && i!=0)
                System.out.println();
        }


        int i, j, k, h, m=0, b=ch.length;
        int[] d = { 1, 4, 10, 23, 57, 145, 356, 911, 1968, 4711, 11969, 27901,
                84801, 213331, 543749, 1355339, 3501671, 8810089, 21521774,
                58548857, 157840433, 410151271, 1131376761, 2147483647 };
        while (d[m] < b) ++m;
        while (--m >= 0)
        {
            k = d[m];
            for (i = k; i < b; i++)
            {     // k-сортировка
                j=i;
                h=ch[i];
                while ((j >= k) && (ch[j-k] > h))
                {
                    ch[j]=ch[j-k];
                    j -= k;
                }
                ch[j] = h;
            }
        }

        System.out.println("\n" +"\n" + "\n" + "After sorting: ");
        for(int z =0; z<ch.length; z++)
        {
            System.out.print(ch[z]+",");
            if(z%100==0 && z!=0)
                System.out.println();
        }
    }
}
