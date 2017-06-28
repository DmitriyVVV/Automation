package homeWork6;

import java.util.Scanner;

/**
 * Created by Dmitriy on 25.04.2017.
 */
public class Calculator {

    public static int positionOfOperator(String example) {
        if(example.contains("+")){
            return example.indexOf("+");
        } else {
            if(example.contains("*")){
                return example.indexOf("*");
            } else {
                if(example.contains("/")){
                    return example.indexOf("/");
                } else {
                    if(example.contains("-")){
                        return example.indexOf("-");
                    } else {
                        return 0;
                    }
                }
            }
        }
    }

    public static double result(String example) {
        String firstPart = example.substring(0, positionOfOperator(example));
        String secondPart = example.substring(positionOfOperator(example)+1);

        int a = Integer.parseInt(firstPart);
        int b = Integer.parseInt(secondPart);

        if(example.charAt(positionOfOperator(example)) == '+'){
            return a+b;
        } else {
            if(example.charAt(positionOfOperator(example)) == '*'){
                return a*b;
            } else {
                if(example.charAt(positionOfOperator(example)) == '/'){
                    return ((double)a/(double)b);
                } else {
                    if(example.charAt(positionOfOperator(example)) == '-'){
                        return a-b;
                    } else {
                        return 0;
                    }
                }
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String example = scanner.nextLine();
        System.out.println(result(example));
    }
}