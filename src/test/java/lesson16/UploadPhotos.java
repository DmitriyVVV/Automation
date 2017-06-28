package lesson16;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.MainPage;
import pageObject.Matches;

/**
 * Created by Dmitriy on 14.06.2017.
 */
public class UploadPhotos extends BrowserFactory{

    Matches obj = new Matches();

    @Test
    public void tryLogin(){
        driver.manage().window().maximize();
        MainPage mainPage = new MainPage();
        obj.open();
        mainPage.loginForm.login("A2559597@MVRHT.NET", "qwe");

    }

    public void uploadPhoto(String pathToFile) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElement(By.xpath("//a[@class='profile_btn addphoto']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#file-input"))).sendKeys(pathToFile);
        driver.findElement(By.xpath("//span[@class='docs-tooltip']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='web-camera__btn save-all-photos']/span"))).click();
        driver.navigate().refresh();
    }

    @Test(dependsOnMethods = "tryLogin")
    public void downloadValidPhoto(){
        uploadPhoto("C:\\Users\\Dmitriy\\Downloads\\1.jpg");
    }

    @Test(dependsOnMethods = "tryLogin")
    public void downloadTextFile(){
        uploadPhoto("C:\\Users\\Dmitriy\\Downloads\\3.txt");
    }

    @Test(dependsOnMethods = "tryLogin")
    public void downloadSmallPhoto(){
        uploadPhoto("C:\\Users\\Dmitriy\\Downloads\\4.jpg");
    }

    @Test(dependsOnMethods = "tryLogin")
    public void downloadBigPhoto(){
        uploadPhoto("C:\\Users\\Dmitriy\\Downloads\\5.jpg");
    }



/*

    @Test(dependsOnMethods = "tryLogin")
    public void uploadPhoto() throws InterruptedException{
        WebDriverWait wait = new WebDriverWait(driver, 5);
        driver.findElement(By.xpath("//a[@class='profile_btn addphoto']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#file-input"))).sendKeys("C:\\Users\\Dmitriy\\Downloads\\1.jpg");
        driver.findElement(By.xpath("//span[@class='docs-tooltip']")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='web-camera__btn save-all-photos']/span"))).click();
    }*/
}

//driver.findElement(By.cssSelector("#file-input")).sendKeys("C:\\Users\\Dmitriy\\Downloads\\1.jpg");
//driver.findElement(By.xpath("//a[@class='profile_btn addphoto']")).click();