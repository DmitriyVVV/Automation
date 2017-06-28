package homeWork9;

import java.util.*;

/**
 * Created by Dmitriy on 16.05.2017.
 */
public class WorkWithSet {


    public static Set<Cat> createCats(){
        HashSet<Cat> result = new HashSet<Cat>();

        for(int i = 0; i<4; i++){
            Cat cat = new Cat();
            result.add(cat);
        }
        return result;
    }

    public static Set<Dog> createDogs(){
        HashSet<Dog> result = new HashSet<Dog>();

        for(int i = 0; i<3; i++){
            Dog dog = new Dog();
            result.add(dog);
        }
        return result;
    }

    public static Set<Object> join(Set<Cat> cats, Set<Dog> dogs){
        HashSet<Object> pets = new HashSet<Object>();
        pets.addAll(cats);
        pets.addAll(dogs);
        return pets;
    }

    public static void removeCats(Set<Object> pets, Set<Cat> cats){
        pets.removeAll(cats);
    }

    public static void printPets(Set<Object> pets){
        for(Iterator iterator = pets.iterator(); iterator.hasNext();){
            System.out.println(iterator.next());
        }
        System.out.println();
    }


    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Set<Dog> dogs = createDogs();

        Set<Object> pets = join(cats, dogs);
        printPets(pets);

        removeCats(pets, cats);
        printPets(pets);
    }

    public static class Cat{}
    public static class Dog{}
}
