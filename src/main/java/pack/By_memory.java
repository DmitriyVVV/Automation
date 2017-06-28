package pack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class By_memory {
    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException
    {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS );
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        driver.get("https://www.facebook.com/");
        driver.findElement(By.xpath("//div//table//tr/td[1]/input")).clear();
        driver.findElement(By.xpath("//div//table//tr/td[1]/input")).sendKeys("+380674056865");
        driver.findElement(By.xpath("//div//table//tr/td[2]/input")).clear();
        driver.findElement(By.xpath("//div//table//tr/td[2]/input")).sendKeys("Akakiy17");
        driver.findElement(By.xpath("//div//td/label/input")).click();

        Thread.sleep(5000);
        System.out.println(driver.getTitle());

        driver.quit();

    }

}
