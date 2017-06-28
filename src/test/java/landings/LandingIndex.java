package landings;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Dmitriy on 11.05.2017.
 */
public class LandingIndex implements RegistrationMethods {

    public WebDriver driver;

    @BeforeClass
    public void startBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://hitwe.com/");
    }

    @Test
    @Parameters({"login","password"})
    @Override
    public void loginByFb(String login, String password) {
        String parentWindow = driver.getWindowHandle();
        WebElement facebookButton = driver.findElement(By.xpath("//form[@id='form-signin']//a[@class='social-button facebook']"));
        facebookButton.click();

        try {
            driver.switchTo().window("Facebook - Google Chrome");
        } catch (NoSuchWindowException e) {
            e.printStackTrace();
        }

        driver.findElement(By.xpath("//input[@type='text']")).clear();
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(login);
        driver.findElement(By.xpath("//input[@type='password']")).clear();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);


    }

    @Test
    @Parameters({"login","password"})
    @Override
    public void loginByVk(String login, String password) {

    }

    @Test
    @Parameters({"login","password"})
    @Override
    public void loginByMailRu(String login, String password) {

    }

    @Test
    @Parameters({"login","password"})
    @Override
    public void loginByYandex(String login, String password) {

    }

    @Test
    @Parameters({"login","password"})
    @Override
    public void loginByGmail(String login, String password) {

    }

    @Test
    @Parameters({"login","password"})
    @Override
    public void loginByHotmail(String login, String password) {

    }

    @Test
    @Parameters({"login","password"})
    @Override
    public void loginByYahoo(String login, String password) {

    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
