package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy on 24.05.2017.
 */
public class CheckZipCode {
    public WebDriver driver;

    public String getcountryAndCityOfZip(String zip){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.get("http://www.geonames.org/postalcode-search.html?q=&country=US");
        driver.findElement(By.xpath("//body/form[@name='searchForm']/input[@name='q']")).clear();
        driver.findElement(By.xpath("//body/form[@name='searchForm']/input[@name='q']")).sendKeys(zip);
        driver.findElement(By.xpath("//input[@value='search']")).click();
        StringBuilder cityAndCoutry = new StringBuilder(driver.findElement(By.xpath("//tr[2]/td[2]")).getText());
        cityAndCoutry.append(" ");
        cityAndCoutry.append(driver.findElement(By.xpath("//tr[2]/td[5]")).getText());
        driver.close();
        return cityAndCoutry.toString();
    }
}