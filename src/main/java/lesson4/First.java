package lesson4;

/**
 * Created by Dmitriy on 12.04.2017.
 */
public class First {
    public static void main(String[] args)
    {
        int a = 1;
        System.out.println("Original a value " + a);
        System.out.println("Post-increment a " + a++);
        System.out.println("After post-increment" + a);
        System.out.println("Pre-increment a " + ++a);
        System.out.println("After pre-increment" + a);

        Methods ob = new Methods();
        System.out.println(ob.sum(7,8));
    }
}