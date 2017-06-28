package homeWork9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy on 18.05.2017.
 */
public class Spisok {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> list){
        int min = list.get(0);
        for(int i = 0; i<list.size(); i++){
            if(list.get(i)<min){
                min= list.get(i);
            }
        }
        return min;
    }

    public static List<Integer> getIntegerList() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<Integer>();

        String quantityStr = reader.readLine();
        int quantity = new Integer(quantityStr);

        while(quantity>0){
            list.add( new Integer(reader.readLine()));
            quantity--;
        }



        return list;
    }
}
