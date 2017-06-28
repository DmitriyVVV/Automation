package homeWork10;

import java.util.*;

/**
 * Created by Dmitriy on 22.05.2017.
 */
public class BlackJack {

    public static void fillDeck(List<String> cards){
        cards.add("2CH");
        cards.add("3CH");
        cards.add("4CH");
        cards.add("5CH");
        cards.add("6CH");
        cards.add("7CH");
        cards.add("8CH");
        cards.add("9CH");
        cards.add("10CH");
        cards.add("ValetCH");
        cards.add("QueenCH");
        cards.add("KingCH");
        cards.add("TuzCH");

        cards.add("2Tref");
        cards.add("3Tref");
        cards.add("4Tref");
        cards.add("5Tref");
        cards.add("6Tref");
        cards.add("7Tref");
        cards.add("8Tref");
        cards.add("9Tref");
        cards.add("10Tref");
        cards.add("ValetTref");
        cards.add("QueenTref");
        cards.add("KingTref");
        cards.add("TuzTref");

        cards.add("2Pik");
        cards.add("3Pik");
        cards.add("4Pik");
        cards.add("5Pik");
        cards.add("6Pik");
        cards.add("7Pik");
        cards.add("8Pik");
        cards.add("9Pik");
        cards.add("10Pik");
        cards.add("ValetPik");
        cards.add("QueenPik");
        cards.add("KingPik");
        cards.add("TuzPik");

        cards.add("2Bubn");
        cards.add("3Bubn");
        cards.add("4Bubn");
        cards.add("5Bubn");
        cards.add("6Bubn");
        cards.add("7Bubn");
        cards.add("8Bubn");
        cards.add("9Bubn");
        cards.add("10Bubn");
        cards.add("ValetBubn");
        cards.add("QueenBubn");
        cards.add("KingBubn");
        cards.add("TuzBubn");
    }

    public static int costOfCard(String cardName){

        switch (cardName.charAt(0)){
            case('2'):
                return 2;
            case('3'):
                return 3;
            case('4'):
                return 4;
            case('5'):
                return 5;
            case('6'):
                return 6;
            case('7'):
                return 7;
            case('8'):
                return 8;
            case('9'):
                return 9;
            case('1'):
                return 10;
            case('V'):
                return 10;
            case('Q'):
                return 10;
            case('K'):
                return 10;
            case('T'):
                return 11;
            default:
                return 0;

        }
    }


    public static void showCards(List<String> cards){
        for(int i = 0; i < cards.size(); i++){
            System.out.println(cards.get(i));
        }
    }

    public static void main(String[] args) {
        List<String> cards = new ArrayList<String>();

        Scanner scaner = new Scanner(System.in);

        fillDeck(cards);
        showCards(cards);
        System.out.println();

        Collections.shuffle(cards);
        showCards(cards);

        System.out.println();
        int totalCount = 0;
        int totalCOuntOfCOmputer = 0;

        System.out.println("Cards of computer: ");
        double cardOfComputer=Math.random()*cards.size();
        System.out.println(cards.get((int)(cardOfComputer)));
        totalCOuntOfCOmputer=costOfCard(cards.get((int)(cardOfComputer)));
        cards.remove((int)(cardOfComputer));

        double firstVardOfPlayer = Math.random()*cards.size();
        System.out.println("Your cards: ");
        System.out.println(cards.get((int)(firstVardOfPlayer)));
        totalCount = costOfCard(cards.get((int)(firstVardOfPlayer)));
        cards.remove((int)(firstVardOfPlayer));

        double secondCardOfPlayer = Math.random()*cards.size();
        System.out.println(cards.get((int)(secondCardOfPlayer)));
        totalCount+=costOfCard(cards.get((int)(secondCardOfPlayer)));
        cards.remove((int)(secondCardOfPlayer));

        int newCard = 0;

        do {
            if(totalCount==21){
                System.out.println("Black Jack!!!");
                System.out.println("You Win!!!");
                break;
            }

            if(totalCount>21){
                System.out.println("Too much!!!");
                break;
            }

            System.out.println("You have " + totalCount + " points");
            System.out.println("Do you want to get one more card? (Y/N)");
            String answer = scaner.nextLine();

            if(answer.equals("Y")){
                System.out.println("Take new card: ");
            } else {
                if(answer.equals("N")){
                    System.out.println("You have " + totalCount + " points");
                    System.out.println("Computer have " + totalCOuntOfCOmputer);

                    if(totalCount>totalCOuntOfCOmputer){
                        System.out.println("You win!!!");
                        break;
                    }

                    if(totalCount<totalCOuntOfCOmputer){
                        System.out.println("You lose!!!");
                        break;
                    }
                }
            }

            firstVardOfPlayer = Math.random()*cards.size();
            System.out.println("Your cards: ");
            System.out.println(cards.get((int)(firstVardOfPlayer)));
            newCard = costOfCard(cards.get((int)(firstVardOfPlayer)));
            totalCount+=newCard;
            cards.remove((int)(firstVardOfPlayer));

            System.out.println("Cards of computer: ");
            cardOfComputer=Math.random()*cards.size();
            System.out.println(cards.get((int)(cardOfComputer)));
            totalCOuntOfCOmputer+=costOfCard(cards.get((int)(cardOfComputer)));
            cards.remove((int)(cardOfComputer));

        } while (cards.size()>1);
    }
}