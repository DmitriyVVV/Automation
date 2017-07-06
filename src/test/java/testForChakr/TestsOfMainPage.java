package testForChakr;

import helper.Factory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.*;
import helper.SkipPopUp;
/**
 * Created by Dmitriy on 23.05.2017.
 */
public class TestsOfMainPage extends Factory{

    SkipPopUp obj = new SkipPopUp();

    @Test
    public void clickOnButton()   {
        obj.skipVerification(driver);
        driver.findElement(By.xpath("//a[@class='_1aq6 Fa1u _1UGL']")).click();
        driver.findElement(By.xpath("//div[@class='Do3T']")).click();
        driver.findElement(By.xpath("//div[2]//div[@class='_1LIS']")).click();
    }

    @Test(priority = 2)
    public void openUsersProfile() {
        obj.skipVerification(driver);
        driver.findElement(By.xpath("//a[@class='_1aq6 Fa1u _1UGL']")).click();
        driver.findElement(By.xpath("//div[@class='_2NUD']")).click();
        System.out.println(driver.getCurrentUrl());
        driver.navigate().back();
    }

    @Test(priority = 3)
    public void clickAllLInks() throws InterruptedException{
        obj.skipVerification(driver);

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

        driver.findElement(By.xpath("//div/a[2]/span")).click();
        sleep(500);
        System.out.println("-" + driver.getTitle());
        driver.navigate().back();

        driver.findElement(By.xpath("//div/a[3]/span")).click();
        sleep(500);
        System.out.println("-" + driver.getTitle());
        driver.navigate().back();

        sleep(500);
        driver.findElement(By.xpath("//header/div[1]/div[@class='dFTP']")).click();
        sleep(500);
        System.out.println("-" + driver.getTitle());
        driver.navigate().back();
/*
        driver.findElement(By.xpath("//ul/li[1]")).click();
        Thread.sleep(500);
        System.out.println("-" + driver.getTitle());
        driver.navigate().back();

        driver.findElement(By.xpath("//ul/li[2]")).click();
        Thread.sleep(500);
        System.out.println("-" + driver.getTitle());
        driver.navigate().back();*/

        /*driver.findElement(By.xpath("//ul/li[3]")).click();
        Thread.sleep(500);
        System.out.println("-" + driver.getTitle());
        driver.navigate().back();
                                                                    //не кликабельные пока что
        driver.findElement(By.xpath("//ul/li[4]")).click();
        Thread.sleep(500);
        System.out.println("-" + driver.getTitle());
        driver.navigate().back();*/

        sleep(500);
        driver.findElement(By.xpath("//div[@class='_3TEv']")).click();
        driver.findElement(By.xpath("//a[@class='_8ysg _3GDC']")).click();
        sleep(500);
        System.out.println("-" + driver.getTitle());
        driver.navigate().back();

        /*//пока что редиректит на главную
        driver.findElement(By.xpath("//div/div[@class='_3TEv']")).click();
        driver.findElement(By.xpath("//a[@class='router-link-active _8ysg _3mqc']")).click();
        Thread.sleep(500);
        System.out.println("-" + driver.getTitle());
        driver.navigate().back();

        driver.findElement(By.xpath("//div/div[@class='_3TEv']")).click();
        driver.findElement(By.xpath("//a[@class='router-link-active _8ysg KWxP']")).click();
        Thread.sleep(500);
        System.out.println("-" + driver.getTitle());
        driver.navigate().back();
        */
        driver.findElement(By.xpath("//div[@class='_3TEv']")).click();
        driver.findElement(By.xpath("//div[@class='_8ysg KnEV']")).click();
        sleep(500);
        System.out.println("-" + driver.getTitle());
    }
}
