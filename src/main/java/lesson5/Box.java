package lesson5;

/**
 * Created by Dmitriy on 19.04.2017.
 */
public class Box {
    public double width;
    public double height;
    public double depth;

    public void volume()
    {
        System.out.print("Объем равен ");
        System.out.println(width*height*depth);
    }
}
