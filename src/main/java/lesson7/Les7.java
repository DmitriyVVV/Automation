package lesson7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Dmitriy on 26.04.2017.
 */
public class Les7 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        LinkedList<String> list1 = new LinkedList<String>();

        Iterator<String> iterator = list.iterator();

        while(iterator.hasNext()){
            String text = iterator.next();
            System.out.println(text);
        }
    }
}
