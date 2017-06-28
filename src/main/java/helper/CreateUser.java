package helper;


import com.sun.corba.se.impl.oa.poa.ActiveObjectMap;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import static java.lang.Math.random;

/**
 * Created by Dmitriy on 23.05.2017.
 */
public class CreateUser {

    public static WebDriver driver;

    public  String generateMail(int size){
        String CHARACTERS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i<size; i++){
            double a = Math.random()*CHARACTERS.length();
            builder.append(CHARACTERS.charAt((int)a));
        }
        builder.append("@testmail.com");


        return builder.toString();
    }

    public void createUser(String email) throws InterruptedException{

            driver = new ChromeDriver();

            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

            driver.manage().window().maximize();

//Первый степ
            String s = email;
            do {
                driver.get("http://login.chakrads.com/login");
                driver.findElement(By.xpath("//button")).click();
                driver.findElement(By.xpath("//div/input[1]")).clear();
                driver.findElement(By.xpath("//div/input[1]")).sendKeys("Piter");
                driver.findElement(By.xpath("//div/input[2]")).clear();
                //s = generateMail(5);
                driver.findElement(By.xpath("//div/input[2]")).sendKeys(email);
                driver.findElement(By.xpath("//div/input[3]")).clear();
                driver.findElement(By.xpath("//div/input[3]")).sendKeys("qwe1rty2");
                driver.findElement(By.xpath("//div/button")).click();
                Thread.sleep(3000);
            } while (!driver.getCurrentUrl().equals("http://login.chakrads.com/age"));


            s = s + "||";
            String filePath = "C:\\\\Users\\\\Dmitriy\\\\Downloads\\notes3.txt";

            try {
                Files.write(Paths.get(filePath), s.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

//Второй степ
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[1]/div/span/div/input")).clear();
            driver.findElement(By.xpath("//div[1]/div/span/div/input")).sendKeys("5");
            driver.findElement(By.xpath("//div[1]/div/span/div/input")).sendKeys(Keys.ENTER);

            driver.findElement(By.xpath("//div[2]/div/span/div/input")).clear();
            driver.findElement(By.xpath("//div[2]/div/span/div/input")).sendKeys("6");
            driver.findElement(By.xpath("//div[2]/div/span/div/input")).sendKeys(Keys.ENTER);

            driver.findElement(By.xpath("//div[3]/div/span/div/input")).clear();
            driver.findElement(By.xpath("//div[3]/div/span/div/input")).sendKeys("1995");
            driver.findElement(By.xpath("//div[3]/div/span/div/input")).sendKeys(Keys.ENTER);

            driver.findElement(By.xpath("//button")).click();

//Третий степ
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@class='step-text-input ']")).clear();
            driver.findElement(By.xpath("//input[@class='step-text-input ']")).sendKeys("10001");
            driver.findElement(By.xpath("//button")).click();
//Четвертый степ
            Thread.sleep(500);
            WebElement element = driver.findElement(By.xpath("//input"));
            element.sendKeys("C:\\Users\\Dmitriy\\Downloads\\testPic.jpg");
            Thread.sleep(500);
            driver.findElement(By.xpath("//button[@type='submit']")).click();
            Thread.sleep(500);
            driver.findElement(By.xpath("//button[@class='next-button congratulation-to-hily']")).click();

            driver.quit();
    }
}