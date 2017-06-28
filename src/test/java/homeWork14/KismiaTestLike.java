package homeWork14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Dmitriy on 02.06.2017.
 */
public class KismiaTestLike {
    public WebDriver driver;
    public String fromTotal;
    public String toTotal;

    @BeforeTest
    public void beginTest(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Test
    public void login(){

        driver.get("https://kismia.com/");
        String email = "A2559597@MVRHT.NET";
        String password = "qwe";
        driver.get("https://kismia.com/matches");
        driver.findElement(By.xpath("//div[@class='form-input']/input[@id='user-email']")).clear();
        driver.findElement(By.xpath("//div[@class='form-input']/input[@id='user-email']")).sendKeys(email);

        driver.findElement(By.xpath("//div[@class='form-input']/input[@id='user-password']")).clear();
        driver.findElement(By.xpath("//div[@class='form-input']/input[@id='user-password']")).sendKeys(password);
        driver.findElement(By.xpath("//form[@id='sign-in-form']/button[@class='submit']")).click();
    }

    @Test(dependsOnMethods = "login", priority = 2)
    @Parameters({"From","To","Gender"})
    public void setAge(String from, String to, String gender) {
        fromTotal = from;
        toTotal = to;

        driver.navigate().refresh();
        driver.get("https://kismia.com/profile/settings");

        if(gender.equals("m")){
            driver.findElement(By.xpath("//li[1]/input[@name='search_gender']")).click();
        } else {
            if(gender.equals("f")){
                driver.findElement(By.xpath("//li[2]/input[@name='search_gender']")).click();
            }
        }

        Select selectFrom = new Select(driver.findElement(By.xpath("//select[@name='search_age_from']")));
        selectFrom.selectByIndex(Integer.parseInt(from)-18);

        Select selectTo = new Select(driver.findElement(By.xpath("//select[@name='search_age_to']")));
        selectTo.selectByIndex(Integer.parseInt(to)-18);

        if(driver.findElements(By.xpath("//div[3]/button[@class='button-FR settings__button button--flat-green js_save']")).size()!=0){
            driver.findElement(By.xpath("//div[3]/button[@class='button-FR settings__button button--flat-green js_save']")).click();
        } else {
            System.out.println("Button is not visible");
        }

    }

    @Test(dependsOnMethods = "login", priority = 3)
    @Parameters({"quantityOfIterationToCheckRepeats"})
    public void checkAgeOfUsers(int quantityOfIterationToCheckRepeats) throws InterruptedException{

        driver.get("https://kismia.com/matches");
        driver.navigate().refresh();

        WebDriverWait wait = new WebDriverWait(driver, 5);

        List<String> list = new ArrayList<>();
        for(int i = 0; i<quantityOfIterationToCheckRepeats; i++){
            if(list.contains(driver.findElement(By.xpath("//div/div/div/a")).getAttribute("data-uid"))){
                System.out.println("Error!!! Duplicate!!!");
                break;
            }
            list.add(driver.findElement(By.xpath("//div/div/div/a")).getAttribute("data-uid"));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//i[@class='icon icon--matches-dislike']")));
            driver.findElement(By.xpath("//i[@class='icon icon--matches-dislike']")).click();
        }

        List<String> stringList= new ArrayList<>();

        for(String s:list){
            driver.get("https://kismia.com/u" + s);
            StringBuilder stringBuilder = new StringBuilder(driver.findElement(By.xpath("//div[@class='inform-col']/h1")).getText());
            StringBuilder str = new StringBuilder(stringBuilder.substring(stringBuilder.indexOf(", ")+2, stringBuilder.indexOf(", ")+4));
            stringList.add(str.toString());
        }

        int fromInt = Integer.parseInt(fromTotal);
        int toInt = Integer.parseInt(toTotal);


        for(String s:stringList){
            int i = Integer.parseInt(s);
            if(i<fromInt || i>toInt){
                System.out.println("Error age");
            }
            System.out.println(i);
        }
    }

    @AfterTest
    public void endOfTest(){
        driver.quit();
    }
}
