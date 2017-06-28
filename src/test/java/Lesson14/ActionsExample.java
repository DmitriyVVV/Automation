package Lesson14;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

/**
 * Created by Dmitriy on 31.05.2017.
 */
public class ActionsExample{
    WebDriver driver = new ChromeDriver();

    @Test
    public void metod() throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://www.imdb.com");

        WebElement element = driver.findElement(By.cssSelector("#consumer_main_nav @navTitleMEnu"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(5000);
    }
}
