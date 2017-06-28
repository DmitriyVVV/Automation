package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy on 23.05.2017.
 */
public class Factory {
    public WebDriver driver;

    @BeforeClass
    public void login(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get("http://login.chakrads.com/login");
        driver.findElement(By.xpath("//input[@class='login-text-input'][1]")).clear();
        driver.findElement(By.xpath("//input[@class='login-text-input'][1]")).sendKeys("rfuyhrfurf@testmail.com");
        driver.findElement(By.xpath("//input[@class='login-text-input'][2]")).clear();
        driver.findElement(By.xpath("//input[@class='login-text-input'][2]")).sendKeys("qwe1rty2");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @AfterClass
    public void close(){
        driver.quit();
    }
}
