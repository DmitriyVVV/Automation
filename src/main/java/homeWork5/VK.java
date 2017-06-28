package homeWork5;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import java.util.Random;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy on 21.04.2017.
 */
public class VK {

    public static String fullName;
    public static String greatingCopy;

    public static WebDriver driver;

    public static void enterVk(String login, String password)
    {
        driver.get("https://vk.com/");

        driver.findElement(By.xpath("//form[@method='post']//input[@name='email']")).clear();
        driver.findElement(By.xpath("//form[@method='post']//input[@name='email']")).sendKeys(login);

        driver.findElement(By.xpath("//form[@method='post']//input[@type='password']")).clear();
        driver.findElement(By.xpath("//form[@method='post']//input[@type='password']")).sendKeys(password);

        driver.findElement(By.xpath("//button[@class='index_login_button flat_button button_big_text']")).click();

        driver.findElement(By.xpath("//div[@class='forgot']/div[@class='checkbox']")).click();
    }

    public static String randGreating()
    {
        String greatings[] = {"С ДР, крч", "Поздравляю", "С левел-апом", "age++", "С Днюхой", "С приближением неизбежности!"};

        Random rnd = new Random(System.currentTimeMillis());
        int numOfGreating = rnd.nextInt(6);

        return greatings[numOfGreating];
    }

    public static void sendGreating()
    {
        driver.findElement(By.xpath("//div[@class='top_nav_btn_icon']")).click();
        int count = 0;
        Object[] ar = driver.findElements(By.xpath("//div[@class='feedback_sticky_text']")).toArray();

        while(ar.length>count)
        {

            driver.findElements(By.xpath("//div[@class='feedback_sticky_text']")).get(count).click();

            fullName = driver.findElement(By.xpath("//a[@class='mem_link']")).getText();

            driver.findElement(By.xpath("//button[@class='flat_button bd_button_pm']")).click();

            driver.findElement(By.xpath("//div[@id='mail_box_editable']")).clear();
            greatingCopy = randGreating();
            driver.findElement(By.xpath("//div[@id='mail_box_editable']")).sendKeys(greatingCopy);

            driver.findElement(By.xpath("//button[@class='flat_button fl_r mail_box_send_btn']")).click();
            count++;
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        driver = new ChromeDriver();

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        /*----------------------------------------------Login---------------------------------------------------------*/
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите логин: ");
        String log = scanner.nextLine();

        System.out.println("Введите пароль: ");
        String pas = scanner.nextLine();

        enterVk(log, pas);
        sendGreating();
        String Surname = fullName.substring(0, fullName.indexOf(" ")-1);
        String name = fullName.substring(fullName.indexOf(" "), fullName.length()-1);

        System.out.print("Сообщение \"");
        System.out.print(greatingCopy + "\"");
        System.out.print(" было отправлено пользователю " + Surname + " " + name);

        Thread.sleep(10000);
        driver.quit();
    }
}





















/*
        if(!driver.findElements(By.xpath("//div[@class='feedback_sticky_text']")).isEmpty())
        {
            driver.findElements(By.xpath("//div[@class='feedback_sticky_text']")).get(0).click();
        }
        else
        {
            System.out.println("Such element isn't found");
            return;
        }

        fullName = driver.findElement(By.xpath("//a[@class='mem_link']")).getText();

        driver.findElement(By.xpath("//button[@class='flat_button bd_button_pm']")).click();

        driver.findElement(By.xpath("//div[@id='mail_box_editable']")).clear();
        greatingCopy = randGreating();
        driver.findElement(By.xpath("//div[@id='mail_box_editable']")).sendKeys(greatingCopy);

        driver.findElement(By.xpath("//button[@class='flat_button fl_r mail_box_send_btn']")).click();*/