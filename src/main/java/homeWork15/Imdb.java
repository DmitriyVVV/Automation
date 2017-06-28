package homeWork15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy on 13.06.2017.
 */
public class Imdb {

    public static List<String> namesOfActorsList = new ArrayList<>();
    public static ChromeOptions options = new ChromeOptions();
    public static DesiredCapabilities capabilities = new DesiredCapabilities().chrome();
    public static WebDriver driver = new ChromeDriver(capabilities);
    public static Map<String, Double> actorAndMark = new HashMap<>();
    public static WebDriverWait wait = new WebDriverWait(driver, 1);


    public static void main(String[] args) {
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability("pageLoadStrategy", "eager");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter list of actors. Enter \"End\" if you want to finish");
        do{
            namesOfActorsList.add(scanner.nextLine());
        } while (!namesOfActorsList.contains("End"));

        driver.get("http://www.imdb.com/");
        driver.manage().window().maximize();
        for(String s: namesOfActorsList){
            if(s.equals("End")){
                break;
            }

            driver.findElement(By.cssSelector("#navbar-query")).clear();
            driver.findElement(By.cssSelector("#navbar-query")).sendKeys(s);
            driver.findElement(By.cssSelector("#navbar-submit-button")).click();
            driver.findElement(By.cssSelector(".primary_photo")).click();

            int totalNumOfFilms;
            int numOfFilmsWhichNotShowedYet;
            int marksOfEnebledFilms;
            double marks=0;

            totalNumOfFilms = driver.findElements
                    (By.cssSelector("#filmo-head-actor+.filmo-category-section > .filmo-row")).size();
            numOfFilmsWhichNotShowedYet = driver.findElements(By.cssSelector(".in_production")).size();


            for(int i = 1; i<=totalNumOfFilms; i++){
                driver.findElement(By.xpath("//div[@class='filmo-category-section'][1]/div["+i+"]/b/a")).click();
                if(driver.findElements(By.xpath("//span[@itemprop='ratingValue']")).size()!=0){
                    String s1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@itemprop='ratingValue']"))).getText();
                    /*String s1 = driver.findElement
                            (By.xpath("//span[@itemprop='ratingValue']")).getText();*/
                    marks+=new Double(s1.replace(',','.'));
                }
                driver.navigate().back();
            }

            marksOfEnebledFilms = totalNumOfFilms - numOfFilmsWhichNotShowedYet;
            actorAndMark.put(s, (marks/marksOfEnebledFilms));
        }
        driver.quit();



        System.out.println(actorAndMark);

    }
}
/*sean connery
brad pit
Leonardo diCaprio
Johnny Depp
Salma Hayek*/