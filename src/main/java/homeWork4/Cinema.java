package homeWork4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy on 17.04.2017.
 */
public class Cinema {

    public static WebDriver driver;

    public static void main(String[] args)
    {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("http://liniakino.com/showtimes/aladdin/");

        boolean isElementEnabled = true;

        for(int i = 1; i<10; i++)
        {
            try {
                driver.findElement(By.xpath("//li[1]/div[@class='showtime']/div[" +i+ "]/label[@class='date']"));
            }
            catch(org.openqa.selenium.NoSuchElementException e)
            {
                isElementEnabled = false;
            }

            if(isElementEnabled)
            {
                System.out.print(i + ": ");
                System.out.println(driver.findElement(By.xpath("//li[1]/div[@class='showtime']/div[" +i+ "]/label[@class='date']")).getText());
            }
        }

        System.out.println("Выберите дату сеанса: 1, 2, ... ");

        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int divN = ((int)s.charAt(0)) - 48;

        boolean isEnabledTime = true;

        for(int i = 1; i<10; i++)
        {
            try
            {
                driver.findElement(By.xpath("//li[1]/div[@class='showtime']/div[" + divN +"]//ul[@class='showtime-time']/li["+i+"]/a[@class='vkino-link  show actual']"));
            }
            catch (org.openqa.selenium.NoSuchElementException a)
            {
                isEnabledTime = false;
            }

            if(isEnabledTime) {
                System.out.print(i + ": ");
                System.out.println(driver.findElement(By.xpath(
                        "//li[1]/div[@class='showtime']/div[" + divN + "]//ul[@class='showtime-time']/li[" + i + "]/a[@class='vkino-link  show actual']"
                )).getText());
            }
        }

        System.out.println("Выберите время сеанса 1-9: ");

        String f = scanner.nextLine();

        int liN = ((int)f.charAt(0)) - 48;
        driver.findElement(By.xpath("//li[1]/div[@class='showtime']/div[" + divN +" ]//ul[@class='showtime-time']/li[" + liN +" ]/a")).click();

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));

        System.out.println("Занятые места: ");

        boolean oneMoreElementOccupied = true;

        for(int i = 1; i<20; i++)
        {
            try {
                driver.findElement(By.xpath("//div[@class='wrapper']/div[2]//div[@class='seat seat-occupied'][" + i + "]")).getText();
            }
            catch(org.openqa.selenium.NoSuchElementException e)
            {
                oneMoreElementOccupied = false;
            }

            if(oneMoreElementOccupied)
            {
                if(driver.findElement(By.xpath("//div[@class='wrapper']/div[2]//div[@class='seat seat-occupied'][" + i + "]")).getText().equals("1"))
                {
                    System.out.println(" ");
                }
                System.out.print(driver.findElement(By.xpath("//div[@class='wrapper']/div[2]//div[@class='seat seat-occupied'][" + i + "]")).getText());
                System.out.print(" ");

            }
        }

        System.out.println(" ");
        System.out.println("Свободные места: ");

        boolean oneMoreElementEnabled = true;

        for(int i = 1; i<200; i++)
        {
            try {
                driver.findElement(By.xpath("//div[@class='wrapper']/div[2]//div[@class='seat seat-color1'][" + i + "]")).getText();
            }
            catch(org.openqa.selenium.NoSuchElementException e)
            {
                oneMoreElementEnabled = false;
            }

            if(oneMoreElementEnabled)
            {
                if(driver.findElement(By.xpath("//div[@class='wrapper']/div[2]//div[@class='seat seat-color1'][" + i + "]")).getText().equals("1"))
                {
                    System.out.println(" ");
                }
                System.out.print(driver.findElement(By.xpath("//div[@class='wrapper']/div[2]//div[@class='seat seat-color1'][" + i + "]")).getText());
                System.out.print(" ");
            }
        }

        System.out.print("\n End");
        driver.quit();
    }
}
