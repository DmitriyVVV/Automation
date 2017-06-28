package lesson12;

/**
 * Created by Dmitriy on 24.05.2017.
 */
public class Dog extends AbstractClassExample{


    @Override
    public void voice() {
        System.out.println("Gaf Gaf");
        isHungry = true;
    }

    @Override
    public void move() {
        if(isHungry){
            System.out.println("I need food!");
            return;
        }
        System.out.println("Ok, i'll walk a little!");
    }
}
