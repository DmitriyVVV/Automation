package homeWork7;

/**
 * Created by Dmitriy on 04.05.2017.
 */
public class StringVSStringBuilder {
    public static void main(String[] args) {
        String s = "";
        long startTime = System.nanoTime();

        for(int i = 0; i<100000; i++){
            s+="q";
        }
        long endTime = System.nanoTime()-startTime;
        System.out.println("Время выполнения String: " + endTime);

        StringBuilder s1 = new StringBuilder("");

        long startTimeBuilder = System.nanoTime();
        for(int i = 0; i<100000; i++){
            s1.append("w");
        }
        long endTimeBuilder = System.nanoTime()-startTimeBuilder;

        System.out.println("Время выполнения StringBuilder: " + endTimeBuilder);

        if(endTime>endTimeBuilder){
            System.out.println("StringBuilder быстрее");
        } else {
            System.out.println("String быстрее");
        }
    }
}
