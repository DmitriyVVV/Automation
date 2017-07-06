package testForHily;


import core.BrowserFactory;
import org.openqa.selenium.By;
import helper.CreateUser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy on 09.06.2017.
 */
/**
 *
 * Трэш и содомия
 * Забудь это
 *
 */


public class TestMail extends BrowserFactory{

    public void loginWIthUseTempMail() throws InterruptedException {
//Тырим почту
        driver.get("https://10minutemail.com");
        String tempMail = driver.findElement(By.xpath("//input[@class='mail-address-address']")).getAttribute("value");
//Создаем юзера с нужной почтой
        CreateUser obj = new CreateUser();
        obj.createUser(tempMail);
//Логиним юзера с нужной почтой
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get("http://login.chakrads.com/login");
        driver.findElement(By.xpath("//input[@class='login-text-input'][1]")).clear();
        driver.findElement(By.xpath("//input[@class='login-text-input'][1]")).sendKeys(tempMail);
        driver.findElement(By.xpath("//input[@class='login-text-input'][2]")).clear();
        driver.findElement(By.xpath("//input[@class='login-text-input'][2]")).sendKeys("qwe1rty2");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        Thread.sleep(1000);
//Проверяем почту


    }
}
