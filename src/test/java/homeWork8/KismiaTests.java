package homeWork8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy on 12.05.2017.
 */


public class KismiaTests {

    public WebDriver driver;



    @BeforeTest
    public void beginTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void login() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        driver.get("https://kismia.com/");
        String email = "A2559597@MVRHT.NET";
        String password = "qwe";
        driver.get("https://kismia.com/matches");
        driver.findElement(By.xpath("//div[@class='form-input']/input[@id='user-email']")).clear();
        driver.findElement(By.xpath("//div[@class='form-input']/input[@id='user-email']")).sendKeys(email);

        driver.findElement(By.xpath("//div[@class='form-input']/input[@id='user-password']")).clear();
        driver.findElement(By.xpath("//div[@class='form-input']/input[@id='user-password']")).sendKeys(password);
        driver.findElement(By.xpath("//form[@id='sign-in-form']/button[@class='submit']")).click();
        Thread.sleep(1500);
    }

    @Test(dependsOnMethods = "login")
    public void sendMessage() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        driver.get("https://kismia.com/matches");

        driver.findElement(By.xpath("//li[@class='new-aside-menu__elem'][1]/a[@class='new-aside-menu__link']")).click();
       // driver.findElement(By.xpath("//a[@class='button-FR button--yellow-border button--yellow-small js-trigger-on-close']")).click();//попап
        driver.findElement(By.xpath("//div[1]/div/a[@class='user-card__btn user-card__btn--options js-show-hide-options']")).click();
        driver.findElement(By.xpath("//div[1]/div[@class='relative-ctn']/ul/li[@class='user-action-options__elem '][1]/a[@class=' user-action-options__link un_redirect_link']")).click();
        driver.findElement(By.xpath("//textarea")).clear();
        driver.findElement(By.xpath("//textarea")).sendKeys("Hello");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(1500);
    }

    @Test(dependsOnMethods = "login")
    public void changeAgeAndGender() throws InterruptedException {

        driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        driver.get("https://kismia.com/matches");
        driver.findElement(By.xpath("//div[@class='new-header__photo']/img")).click();
        driver.findElement(By.xpath("//li[2]/a[@class='new-header-subs__link']")).click();
        driver.findElement(By.xpath("//a[@class='button-FR button--yellow-border button--yellow-small js-trigger-on-close']")).click();//попап
        int neededAgeFrom = 20;
        int neededAgeTo = 30;
        String neededGender = "Female";

        if(neededGender=="Male"){
            driver.findElement(By.xpath("//li[1]/input[@name='search_gender']")).click();
        } else {
            driver.findElement(By.xpath("//li[2]/input[@name='search_gender']")).click();
        }

        int ageFrom = neededAgeFrom - 17;
        driver.findElement(By.xpath("//select[@name='search_age_from']/option[" +ageFrom+"]")).click();

        int ageTo = neededAgeTo - 17;
        driver.findElement(By.xpath("//select[@name='search_age_to']/option["+ageTo+"]")).click();

        driver.findElement(By.xpath("//div[@class='settings-button-block settings-button-block--blue js_saveBlock']/button[@class='button-FR settings__button button--flat-green js_save']")).click();

        //Thread.sleep(5000);
    }

    @AfterTest
    public void endOfTest(){
        driver.quit();
    }

}
