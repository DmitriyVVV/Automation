package homeWork2;

/**
 * Created by Dmitriy on 06.04.2017.
 */
public class Fourth {
    public static void main(String[] args)
    {
        int n = 781;
        int n1 = n/100;
        int n2 = n/10-((n/100)*10);
        int n3 = n - (n1*100+n2*10);
        System.out.println(n1  +  n2  + n3);
    }
}
