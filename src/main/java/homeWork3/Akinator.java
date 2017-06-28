package homeWork3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy on 11.04.2017.
 */
public class Akinator {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        System.out.println("Варианты ответов: " + "\n" +
                "1: Да" + "\n" +
                "2: Нет" + "\n" +
                "3: Я не знаю" + "\n" +
                "4: Возможно Частично" + "\n" +
                "5: Скорее нет Не совсем");

        System.out.print("Введите Ваш возраст: ");
        Scanner scaner = new Scanner(System.in);
        String age = scaner.nextLine();

        driver.get("http://ru.akinator.com/");
        driver.findElement(By.xpath("//a[@class='rouge']")).click();
        driver.findElement(By.id("elokence_sitebundle_identification_age")).clear();
        driver.findElement(By.id("elokence_sitebundle_identification_age")).sendKeys(age);

        driver.findElement(By.xpath("//input[@type='submit']")).click();

        int answer;
        boolean work = true;

        do
        {
            String question = driver.findElement(By.id("bulle-inner")).getText();
            System.out.println(question);

            answer = 1; //защита от дурака

            System.out.println("Выберите вариант ответа");

            Scanner scan = new Scanner(System.in);
            String answerSrt = scan.nextLine();
            answer = (int)answerSrt.charAt(0);

            switch (answer)
            {
                case (49):
                    driver.findElement(By.id("reponse1")).click();
                    break;

                case (50):
                    driver.findElement(By.id("reponse2")).click();
                    break;

                case (51):
                    driver.findElement(By.id("reponse3")).click();
                    break;

                case (52):
                    driver.findElement(By.id("reponse4")).click();
                    break;

                case(53):
                    driver.findElement(By.id("reponse5")).click();
                    break;

                default:
                    driver.quit();
                    System.out.println("Ложное значение");
                    break;
            }

            Thread.sleep(1500);

            if(driver.getCurrentUrl().equals("http://ru.akinator.com/personnages/propose"))
                /*work = false;*/break;

        } while(true);

        System.out.println(driver.findElement(By.xpath("//div[@id='infos-perso-title']/p")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@id='infos-perso-title']/h2")).getText());
        System.out.println(driver.findElement(By.xpath("//div[@id='infos-perso-content']/p")).getText());

        driver.quit();
    }
}