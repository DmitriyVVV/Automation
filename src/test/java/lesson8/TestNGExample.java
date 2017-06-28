package lesson8;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Created by Dmitriy on 10.05.2017.
 */

public class TestNGExample {

    public WebDriver driver;


    @Test
    public void A() {
        System.out.println("A is used");
        Assert.assertTrue(true, "False because so I wan\'t");
    }

    @Test
    public void B(){
        System.out.println("B is used");
    }

    @Test
    public void C(){
        System.out.println("C is used");
    }

    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void getGoogle(){
        driver.get("http://google.com");
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
