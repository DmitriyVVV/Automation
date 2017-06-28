package homeWork3;

/**
 * Created by Dmitriy on 11.04.2017.
 */
public class EqualNames {
    public  static void main(String[] args){
        String firstName = "Петя";
        String secondNAme = "Петя";

        if(firstName.equals(secondNAme))
        {
            System.out.println("Эти двое являются тезками");
        }
        else
        {
            System.out.println("У этих двоих разные имена");
        }
    }

}
