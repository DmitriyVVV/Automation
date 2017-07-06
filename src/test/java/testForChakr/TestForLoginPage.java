package testForChakr;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import helper.SkipPopUp;

/**
 * Created by Dmitriy on 31.05.2017.
 */
public class TestForLoginPage{

    SkipPopUp obj = new SkipPopUp();

    public static WebDriver driver;

    String loginForTest;

    public static String generateMail(int size){
        String CHARACTERS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";

        StringBuilder builder = new StringBuilder();
        for(int i = 0; i<size; i++){
            double a = Math.random()*CHARACTERS.length();
            builder.append(CHARACTERS.charAt((int)a));
        }
        builder.append("@testmail.com");


        return builder.toString();
    }

    @Test
    public void CreateUserByForm() throws InterruptedException{

        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();

//Первый степ
        String s = "";
        do {
            driver.get("http://login.chakrads.com/login");
            driver.findElement(By.xpath("//button")).click();
            driver.findElement(By.xpath("//div/input[1]")).clear();
            driver.findElement(By.xpath("//div/input[1]")).sendKeys("Piter");
            driver.findElement(By.xpath("//div/input[2]")).clear();
            s = generateMail(5);
            driver.findElement(By.xpath("//div/input[2]")).sendKeys(s);
            driver.findElement(By.xpath("//div/input[3]")).clear();
            driver.findElement(By.xpath("//div/input[3]")).sendKeys("qwe1rty2");
            driver.findElement(By.xpath("//div/button")).click();
            Thread.sleep(3000);
        } while (!driver.getCurrentUrl().equals("http://login.chakrads.com/age"));

        loginForTest = s;

        s = s + "||";
        String filePath = "C:\\\\Users\\\\Dmitriy\\\\Downloads\\notes3.txt";

        try {
            Files.write(Paths.get(filePath), s.getBytes(), StandardOpenOption.APPEND);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

//Второй степ
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[1]/div/span/div/input")).clear();
        driver.findElement(By.xpath("//div[1]/div/span/div/input")).sendKeys("9");
        driver.findElement(By.xpath("//div[1]/div/span/div/input")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//div[2]/div/span/div/input")).clear();
        driver.findElement(By.xpath("//div[2]/div/span/div/input")).sendKeys("8");
        driver.findElement(By.xpath("//div[2]/div/span/div/input")).sendKeys(Keys.ENTER);

        driver.findElement(By.xpath("//div[3]/div/span/div/input")).clear();
        driver.findElement(By.xpath("//div[3]/div/span/div/input")).sendKeys("1989");
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

//Переход на главную страницу



        driver.get("http://login.chakrads.com");
        obj.skipVerification(driver);
        System.out.println("User email: " + s);
        driver.findElement(By.xpath("//div[@class='dFTP']")).click();
        Thread.sleep(1000);
        StringBuilder stringBuilder = new StringBuilder(driver.getCurrentUrl());
        stringBuilder.substring(stringBuilder.lastIndexOf("/"), stringBuilder.length());
        System.out.println(stringBuilder);
        driver.quit();


    }

    @Test
    public void login() throws InterruptedException{
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get("http://login.chakrads.com/login");
        driver.findElement(By.xpath("//input[@class='login-text-input'][1]")).clear();
        driver.findElement(By.xpath("//input[@class='login-text-input'][1]")).sendKeys(loginForTest);
        driver.findElement(By.xpath("//input[@class='login-text-input'][2]")).clear();
        driver.findElement(By.xpath("//input[@class='login-text-input'][2]")).sendKeys("qwe1rty2");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(1000);

        obj.skipVerification(driver);

        driver.findElement(By.xpath("//div[@class='dFTP']")).click();
        StringBuilder stringBuilder = new StringBuilder(driver.getCurrentUrl());
        System.out.println(stringBuilder);
        driver.quit();
    }

    @Test
    public void loginByFb() throws InterruptedException{
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        driver.get("http://login.chakrads.com/login");


        driver.findElement(By.xpath("//div[@class='social-title']")).click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String mainWindow =  it.next();
        String popUp =  it.next();
        driver.switchTo().window(popUp);

        driver.findElement(By.xpath("//input[@class='inputtext _55r1 inputtext inputtext']")).clear();
        driver.findElement(By.xpath("//input[@class='inputtext _55r1 inputtext inputtext']")).sendKeys("aaqnxljqgv_1496326159@tfbnw.net");
        driver.findElement(By.xpath("//input[@type='password']")).clear();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("qwe1rty2");
        driver.findElement(By.xpath("//input[@name='login']")).click();
        driver.switchTo().window(mainWindow);
        Thread.sleep(1000);

        obj.skipVerification(driver);

        driver.findElement(By.xpath("//div[@class='dFTP']")).click();
        StringBuilder stringBuilder = new StringBuilder(driver.getCurrentUrl());
        System.out.println(stringBuilder);
        driver.quit();
    }

}
