package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Dmitriy on 06.06.2017.
 */
public class SkipPopUp {

    public void skipVerification(WebDriver driver){

        if(driver.findElements(By.xpath("//div[@class='swiper-slide swiper-slide-active']")).size()!=0){
            driver.findElement(By.xpath("//div[@class='_3j2z _1Pyl']")).click();
        }
    }

    public void skipMutual(String sendMessageOrSkip){
        WebDriver driver = new ChromeDriver();
        if(driver.findElements(By.xpath("//div[@class='Rh4j _2u3W']")).size()!=0){
            if(sendMessageOrSkip.equals("sendMessage")){
                driver.findElement(By.xpath("//div[@class='_2pWz']")).click();
            } else {
                if(sendMessageOrSkip.equals("skip")){
                    driver.findElement(By.xpath("//div[@class='_2yNm']")).click();
                }
            }
        }
    }


}
