package testForHily;

import helper.Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import helper.SkipPopUp;
/**
 * Created by Dmitriy on 24.05.2017.
 */
public class TestOfActivity extends Factory {

    SkipPopUp obj = new SkipPopUp();

    @Test
    public void openUsersPage(){
        obj.skipVerification(driver);
        driver.findElement(By.xpath("//div/a[3]/span")).click();
        if(driver.findElements(By.xpath("//div/div[@class='aUZd _1Teu']/div[@class='gXt4']")).size()>0){
            driver.findElement(By.xpath("//div/div[@class='aUZd _1Teu']/div[@class='gXt4']")).click();
            System.out.println(driver.getTitle());
        }
    }

    @Test
    public void openAllUsersList() throws InterruptedException{
        obj.skipVerification(driver);
        driver.findElement(By.xpath("//div/a[3]/span")).click();
        if(driver.findElements(By.xpath("//div[@class='_1MX8']/div[@class='aUZd _1Teu']/div[@class='_23yp']")).size()>0){
            driver.findElement(By.xpath("//div[@class='_1MX8']/div[@class='aUZd _1Teu']/div[@class='_23yp']")).click();
            List<WebElement> elementList = driver.findElements(By.xpath("//div/div[@class='_1PK1']"));
            String s = driver.findElement(By.xpath("//div[@class='_2MUb']/div[@class='_3HBn']")).getText();
            System.out.println(s + " " + elementList.size());
            System.out.println(driver.getTitle());
        }

        Thread.sleep(500);
    }
}
