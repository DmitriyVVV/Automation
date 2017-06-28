package lesson12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Dmitriy on 24.05.2017.
 */
public class ImdbSearchPage implements Searchpage {

    private WebDriver driver;

    public ImdbSearchPage(WebDriver driver){
        this.driver=driver;
    }

    @Override
    public void inputTExt(String text) {
        driver.findElement(By.xpath("//input[@id='navbar-query']")).clear();
        driver.findElement(By.xpath("//input[@id='navbar-query']")).sendKeys(text);
    }

    @Override
    public void submit() {
        driver.findElement(By.xpath("//div[@class='magnifyingglass navbarSprite']")).click();
    }

    @Override
    public void open() {
        driver.get("http://imdb.com");
    }
}
