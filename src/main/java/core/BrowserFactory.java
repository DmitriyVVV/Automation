package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Created by Dmitriy on 22.05.2017.
 */
public class BrowserFactory extends DriverActionsFactory{


    @BeforeTest
    public void setUp(){
        driver = new ChromeDriver();
    }

    @AfterTest
    public void teamDown(){
        driver.quit();
    }

}
