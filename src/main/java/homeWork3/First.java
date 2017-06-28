package homeWork3;

/**
 * Created by Dmitriy on 11.04.2017.
 */
public class First {
    public static void main(String[] args)
    {
        int nums[] = {1,2,-3,-4,2};
        int min = nums[0];
        int num;

        for(num = 0; num<nums.length; num++)
        {
            min = nums[num]<min?nums[num]:min;
        }

        int max = nums[0];

        for(num = 0; num<nums.length; num++){
            max = nums[num]>max?nums[num]:max;
        }

        int quantityOfMax = 0;

        for(num = 0; num<nums.length; num++){
            if(nums[num]==max)
            {
                quantityOfMax++;
            }
        }

        System.out.println("Количество максимальных значений " + quantityOfMax);

        System.out.println("Минимальное число " + min);

    }
}
