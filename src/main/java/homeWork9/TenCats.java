package homeWork9;

import sun.security.x509.CertAttrSet;

import java.util.*;

/**
 * Created by Dmitriy on 18.05.2017.
 */
public class TenCats {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = converMapToSet(map);
        printSetCat(set);
    }

    public static Map<String, Cat> createMap(){
        Map<String, Cat> map = new HashMap<String, Cat>();
        Cat cat = new Cat("Блохастый");
        map.put("Барсик", cat);
        cat = new Cat("Худой");
        map.put("Мурчик", cat);
        cat = new Cat("Толстый");
        map.put("Пушок", cat);
        cat = new Cat("Лысый");
        map.put("Пидрила шерстяная", cat);
        cat = new Cat("Пушистый");
        map.put("Кошак", cat);
        cat = new Cat("Мягкий");
        map.put("КотЭ", cat);
        cat = new Cat("Теплый");
        map.put("Беляшик", cat);
        cat = new Cat("Персидский");
        map.put("Шаурменька", cat);
        cat = new Cat("Аббисинский");
        map.put("Кот-В-Сапогах", cat);
        cat = new Cat("Шерстяной");
        map.put("Кот-Без-Сапогов", cat);

        return map;
    }

    public static Set<Cat> converMapToSet(Map<String, Cat> map){
        Set set = map.entrySet();
        Iterator i = set.iterator();

        HashSet<Cat> catsSet = new HashSet<Cat>();
        Cat cat;

        while(i.hasNext()){
            Map.Entry setMap = (Map.Entry)i.next();
            cat = new Cat((String) setMap.getKey());
            catsSet.add(cat);
        }

        return catsSet;
    }

    public static void printSetCat(Set<Cat> set){
        for(Iterator iterator = set.iterator(); iterator.hasNext();){
            System.out.println(iterator.next());
        }
    }

    public static class Cat{
        private  String name;

        public Cat(String name){
            this.name = name;
        }

        public String toString(){
            return "Cat " + this.name;
        }
    }
}
