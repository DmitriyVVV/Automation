package testForChakr;

import helper.Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;
import helper.SkipPopUp;
/**
 * Created by Dmitriy on 23.05.2017.
 */
public class TestsForMessagesPage extends Factory {

    SkipPopUp obj = new SkipPopUp();

    @Test
    public void sendMessage() throws  InterruptedException{

        obj.skipVerification(driver);

        driver.findElement(By.xpath("//div/a[2]/span")).click();
        Thread.sleep(500);


        double randUser = Math.random()*1000;



        if(driver.findElements(By.xpath("//div[@class='_3vr1']")).size()>0){
            driver.findElement(By.xpath("//div[@class='_2z4r']")).clear();
            String sendMes = "1234567890qwertyuiopasdfghjklzxcvbnm,./[]';lQWERTYUIOPASDFGHJKL;'ZXCVBNM,./ ";
            driver.findElement(By.xpath("//div[@class='_2z4r']")).sendKeys(sendMes);
            driver.findElement(By.xpath("//button[@class='_3UBv']")).click();
        } else {
            driver.get("http://chakrads.com/chat/" + randUser);
            driver.findElement(By.xpath("//div[@class='_2z4r']")).clear();
            String sendMes = "1234567890qwertyuiopasdfghjklzxcvbnm,./[]';lQWERTYUIOPASDFGHJKL;'ZXCVBNM,./ ";
            driver.findElement(By.xpath("//div[@class='_2z4r']")).sendKeys(sendMes);
            driver.findElement(By.xpath("//button[@class='_3UBv']")).click();
        }
        Thread.sleep(2000);
    }

    @Test
    public void openPageOfUser() {

        obj.skipVerification(driver);

        driver.findElement(By.xpath("//div/a[2]/span")).click();
        if(driver.findElements(By.xpath("//div[@class='_3vr1']")).size()>0){
            driver.findElement(By.xpath("//div[@class='_2d4V']")).click();
            System.out.println("-" + driver.getTitle());
        }

    }

    @Test
    public void deleteMessages(){

        obj.skipVerification(driver);

        driver.findElement(By.xpath("//div/a[2]/span")).click();

        if(driver.findElements(By.xpath("//div[@class='_3vr1']")).size()>0){
            driver.findElement(By.xpath("//div[@class='_3vr1']")).click();
            List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='AIRe']"));
            for(WebElement element:elementList){
                element.click();
            }
            driver.findElement(By.xpath("//div[@class='_3Pt1']")).click();
        }
    }

    @Test
    public void cancelDeleting(){

        obj.skipVerification(driver);

        driver.findElement(By.xpath("//div/a[2]/span")).click();

        if(driver.findElements(By.xpath("//div[@class='_3vr1']")).size()>0){
            driver.findElement(By.xpath("//div[@class='_3vr1']")).click();
            List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='AIRe']"));
            for(WebElement element:elementList){
                element.click();
            }
            driver.findElement(By.xpath("//div[@class='_3_tk']")).click();
        }
    }


}
