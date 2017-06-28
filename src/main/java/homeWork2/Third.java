package homeWork2;

/**
 * Created by Dmitriy on 06.04.2017.
 */
public class Third {
    public static void main(String[] args)
    {
        double n = 37.99;
        double m = n - (int)n;
        if((int)(m*10)>5)
            System.out.println((int)n+1);
        else
            System.out.println((int)n);
    }
}
