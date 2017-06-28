package homeWork7;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy on 04.05.2017.
 */
public class CompareImdbAndKinopoisk {

    public static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        /*---------------------------------------------IMDB-----------------------------------------------------------*/

        Map<String, Double> mapOfImdb = new HashMap<String, Double>();
        Map<Integer, String> mapOfImdbManipulate = new HashMap<Integer, String>();
        int counter = 1;
        driver.get("http://m.imdb.com/chart/top");
        for(int i = 1; i<=125; i++) {
            for(int k = 1; k<3; k++) {
                StringBuilder fullString = new StringBuilder
                        (driver.findElement(By.xpath("//div[@class='row chart-row'][" + i + "]//div[" + k + "]/div[@class='media']/a/span/h4")).getText());

                StringBuilder rateString = new StringBuilder
                        (driver.findElement(By.xpath("//div[@class='row chart-row'][" + i + "]//div[" + k + "]/div[@class='media']/a/span/p/span[2]")).getText());

                rateString.replace(rateString.indexOf(","), rateString.indexOf(",") + 1, ".");
                Double rate = new Double(rateString.toString());
                StringBuilder s = new StringBuilder(fullString.delete(0, fullString.indexOf(".") + 2));
                s.delete(s.length() - 7, s.length());

                mapOfImdb.put(s.toString(), rate);
                mapOfImdbManipulate.put(counter,s.toString());
                counter++;

            }
        }
        System.out.println("Список фильмов с imdb");
        for(int i = 1; i<251; i++){
            System.out.println(mapOfImdbManipulate.get(i) + " " + mapOfImdb.get(mapOfImdbManipulate.get(i)));
        }

        System.out.println("\n\n\n");
        /*------------------------------------------Kinopoisk---------------------------------------------------------*/
        driver.get("https://www.kinopoisk.ru/top/");
        Map<String, Double> mapOfKinopoisk = new HashMap<String, Double>();
        Map<Integer, String> mapOfKinopoiskManipulate = new HashMap<Integer, String>();

        int counter2 = 1;
        for(int i = 2; i<252; i++){
            if(driver.findElements(By.xpath("//tr[" + i + "]//span[@class='text-grey']")).size()>0){
                StringBuilder name = new StringBuilder
                    (driver.findElement(By.xpath("//tr[" + i + "]//span[@class='text-grey']")).getText());
                StringBuilder rateKinopoiskString = new StringBuilder
                        (driver.findElement(By.xpath("//tr[" + i + "]/td//a[@class='continue']")).getText());
                Double rateKinopoisk = new Double(rateKinopoiskString.toString());
                mapOfKinopoisk.put(name.toString(), rateKinopoisk);
                mapOfKinopoiskManipulate.put(counter2, name.toString());
                counter2++;
            }
        }

        System.out.println("\n\n\n");
        System.out.println("Список фильмов с кинопоиска (Только иностранные)");
        for(int i = 1; i<counter2; i++){
            System.out.println(mapOfKinopoiskManipulate.get(i) + " " + mapOfKinopoisk.get(mapOfKinopoiskManipulate.get(i)));
        }
        driver.quit();
        System.out.println("\n\n\n");


        List<Map.Entry<Integer, String>> list = new LinkedList<Map.Entry<Integer, String>>(mapOfImdbManipulate.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        System.out.println("Вывод фильмов в нужном виде");
        for(Map.Entry<Integer, String> item: list){
            System.out.println(item.getValue()
                    + " imbd: " + mapOfImdb.get(item.getValue())
                    + " \\kinopoisk: " + mapOfKinopoisk.get(item.getValue()));
        }
    }
}