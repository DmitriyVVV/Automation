package lesson5;

/**
 * Created by Dmitriy on 19.04.2017.
 */
public class BoxRunner {
    public static void main(String[] args)
    {
        Box myBox = new Box();
        Box cube = new Box();
        Box paralelepiped = new Box();

        cube.depth=cube.width=cube.height=10;

        paralelepiped.depth = 15;
        paralelepiped.height = 20;
        paralelepiped.width = 10;

        cube.volume();
        paralelepiped.volume();
    }
}
