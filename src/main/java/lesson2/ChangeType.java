package lesson2;

/**
 * Created by Dmitriy on 05.04.2017.
 */
public class ChangeType {




    public static void main(String[] args) {
        int i = 605233;
        long lo = i;
        short s = (short) lo;

        System.out.println(s);

        char ch = 'J';
        int intCh = (int) ch;

        System.out.println("J corresponds with " + intCh);

        //Классы оболочки
        Integer i1 = new Integer(100);
        Character c = new Character('c');
        Boolean b = new Boolean(true);

    }
}
