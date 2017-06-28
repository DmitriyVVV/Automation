package homeWork3;

/**
 * Created by Dmitriy on 11.04.2017.
 */
public class SwitchExerscise {
        public static void main(String[] args)
        {
            int numberOfDay = 8;

            switch(numberOfDay){
                case (1):
                    System.out.println("Это понедельник");
                    break;

                case(2):
                    System.out.println("Это вторник");
                    break;

                case(3):
                    System.out.println("Это среда");
                    break;

                case(4):
                    System.out.println("Это четверг");
                    break;

                case(5):
                    System.out.println("Это пятница");
                    break;

                case(6):
                    System.out.println("Это суббота");
                    break;

                case(7):
                    System.out.println("Это воскресенье");
                    break;

                default:
                    System.out.println("Соответствующего дня недели нету");
            }
        }
    }

