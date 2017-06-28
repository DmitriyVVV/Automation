package homeWork9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Dmitriy on 18.05.2017.
 */
public class ZadachaPoAlgoritmam {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);
    }

    public static void sort(String[] array)
    {
        List<String> listOfFruits = new ArrayList<String>();
        List<String> listOfNumbers = new ArrayList<String>();
        int i = 0;

        while(i<array.length) {
            if (isNumber(array[i])) {
                listOfNumbers.add(array[i]);
            } else {
                listOfFruits.add(array[i]);
            }
            i++;
        }

        String str, str1;
        for(int x = 0; x<listOfFruits.size(); x++) {
            for (int y = 0; y<listOfFruits.size()-1; y++) {
                if(isGreaterThan(listOfFruits.get(y), listOfFruits.get(x))){

                    str = listOfFruits.get(x);
                    str1 = listOfFruits.get(y);

                    listOfFruits.remove(listOfFruits.get(x));
                    listOfFruits.add(x, str1);

                    listOfFruits.remove(listOfFruits.get(y));
                    listOfFruits.add(y, str);
                }
            }
        }

        for(int x = 0; x<listOfNumbers.size(); x++) {
            for (int y = 0; y<listOfNumbers.size()-1; y++) {
                if(!isGreaterThan(listOfNumbers.get(y), listOfNumbers.get(x))){

                    str = listOfNumbers.get(x);
                    str1 = listOfNumbers.get(y);

                    listOfNumbers.remove(listOfNumbers.get(x));
                    listOfNumbers.add(x, str1);

                    listOfNumbers.remove(listOfNumbers.get(y));
                    listOfNumbers.add(y, str);
                }
            }
        }

        for(Iterator iterator = listOfFruits.iterator(); iterator.hasNext();){
            System.out.println(iterator.next());
        }
        System.out.println("==================================");
        for(Iterator iterator = listOfNumbers.iterator(); iterator.hasNext();){
            System.out.println(iterator.next());
        }
        System.out.println("==================================");

        int size;
        if(listOfFruits.size()>listOfNumbers.size()){
            size = listOfFruits.size();
        } else {
            size = listOfNumbers.size();
        }

        System.out.println("========");
        for(int i1 = 0; i1<size; i1++){
            if(i1<listOfFruits.size()){
                System.out.println(listOfFruits.get(i1));
            }

            if(i1<listOfNumbers.size()){
                System.out.println(listOfNumbers.get(i1));
            }
        }
        System.out.println("========");


    }



    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}