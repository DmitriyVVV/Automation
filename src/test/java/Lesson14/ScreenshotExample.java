package Lesson14;

import core.BrowserFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Dmitriy on 31.05.2017.
 */
public class ScreenshotExample extends BrowserFactory {
    WebDriver driver = new ChromeDriver();
    @Test
    public void takeScreenShot() throws IOException{
        driver.get("https://google.com");
        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenShot,  new File("C:\\\\Users\\\\Dmitriy\\\\Downloads\\ruigh.png"));
    }

    @Test
    public void listenerTest(){
        driver = new EventFiringWebDriver(driver).register(new EventListenerExample());
        driver.get("https://google.com");
        driver.findElement(By.xpath("//div"));
        driver.quit();
    }


}
