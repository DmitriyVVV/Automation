package homeWork9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy on 17.05.2017.
 */
public class Stroki {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new ArrayList<String>();
        do{
            list.add(reader.readLine());
        }while(!list.contains(""));
        System.out.println("End");
        sort(list);
        display(list);
    }

    public static void display(List<String> list){
        for(int i = list.size()-1; i>=0; i--){
            System.out.println(list.get(i));
        }
    }

    public static void sort(List<String> list){
        String str, str1;

        for(int x = 0; x<list.size(); x++) {
            for (int y = 0; y<list.size()-1; y++) {
                if(!isGreaterThen(list.get(y), list.get(x))){

                    str = list.get(x);
                    str1 = list.get(y);

                    list.remove(list.get(x));
                    list.add(x, str1);

                    list.remove(list.get(y));
                    list.add(y, str);
                }
            }
        }

    }

    public static boolean isGreaterThen(String a, String b){
        return  a.compareTo(b)>0;
    }
}
