package lesson2;

/**
 * Created by Dmitriy on 05.04.2017.
 */
public class FloatToChar {

    public static void main(String[] args)
    {

        float f = 6.3f;
        char ch = (char)f;

        System.out.println(ch);
/****************************************/
        char cha;
        Float fa = new Float(7.36f);
        cha = (char) fa.floatValue();
        System.out.println(cha);

    }
}
