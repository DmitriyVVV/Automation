package pack;

import java.util.*;

/**
 * Created by Dmitriy on 29.05.2017.
 */
public class Ekzamen {

//Итерации по Map
    public static void mapIteration(){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "John");
        map.put(2, "Ben");
        map.put(3, "Piter");
        map.put(4, "Jake");

        for(Map.Entry<Integer, String> entry: map.entrySet()){
            System.out.println(entry.getKey() + entry.getValue());
        }
    }

//Есть List<String> names. Удалить из него все элементы включающие букву “S”
    public static void deleteElementsFromList(){
        List<String> list = new ArrayList<>();
        list.add("Stiven");
        list.add("Ben");
        list.add("chak");
        list.add("sven");
        list.add("Seven");
        list.add("Ssssss");
        list.add("sssssS");
        list.add("ssSsss");
        list.add("louSonn");

        for(int i = 0; i<list.size(); i++){
            if(list.get(i).contains("S")){
                list.remove(i);
                i=0;
            }
        }

        for(String s: list){
            System.out.println(s);
        }
    }

//Отсортировать список имен по убыванию. (От Я до А)
    public static void sortNamesByDekr(){
        List<String> list = new ArrayList<>();
        list.add("Stiven");
        list.add("Ben");
        list.add("Chak");
        list.add("X-man");
        list.add("Avraam");
        list.add("Aanut");

        String temp;
        for (int i = 0; i<list.size(); i++){
            for(int q = 0; q<list.size(); q++){
                if(list.get(i).compareTo(list.get(q))>0){
                    temp = list.get(i);
                    list.set(i, list.get(q));
                    list.set(q, temp);
                }
            }
        }

        for(String s: list){
            System.out.println(s);
        }
    }

    public static void main(String[] args) {
        mapIteration();
        System.out.println();
        deleteElementsFromList();
        System.out.println();
        sortNamesByDekr();
    }

}
