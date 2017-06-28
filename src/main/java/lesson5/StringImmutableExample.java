package lesson5;

/**
 * Created by Dmitriy on 19.04.2017.
 */
public class StringImmutableExample {
    public  static void main(String[] args)
    {
/*        //String не изменяемая. Строки надо переназначать
        String myString = "Jack";
        myString.concat(" Sparrow");

        System.out.println(myString);
        //concat возвращает новую строку, а не изменяет старую
        myString = myString.concat(" Sparrow");
        System.out.println(myString);
*/
        System.out.println();

        int a = 345;
        String str = String.valueOf(a);
        int a1 = Integer.valueOf(str);

        System.out.println(str);
        System.out.println(a1);


        boolean b = true;
        String strBool = String.valueOf(b);
        boolean b1 = Boolean.valueOf(strBool);

        System.out.println(strBool);
        System.out.println(b1);

        double c = 3.489;
        String strDouble = String.valueOf(c);
        double c1 = Double.valueOf(strDouble);

        System.out.println(strDouble);
        System.out.println(c1);
    }
}
