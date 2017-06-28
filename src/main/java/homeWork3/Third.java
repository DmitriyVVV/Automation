package homeWork3;

/**
 * Created by Dmitriy on 11.04.2017.
 */
public class Third {
    public static void main(String[] args)
    {
        int nums[] = {7,2,3,4,-15};

        int min = nums[0];
        int max = nums[0];

        for(int i=0; i<nums.length; i++){
            min = nums[i]<min?nums[i]:min;
            max = nums[i]>max?nums[i]:max;
        }

        System.out.println("Минимальное число " + min);
        System.out.println("Максимально число " + max);

        /*Scanner scan = new Scanner(System.in);
        String answerSrt = scan.nextLine();
        int answer = (int)answerSrt.charAt(0);

        System.out.println(answer);*/
    }
}
