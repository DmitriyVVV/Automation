package lesson12;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by Dmitriy on 24.05.2017.
 */
public class KinopoiskSearchPoisk implements Searchpage{

    private WebDriver driver;

    public KinopoiskSearchPoisk(WebDriver driver){
        this.driver=driver;
    }

    @Override
    public void inputTExt(String text) {
        driver.findElement(By.xpath("//input[@id='search_input']")).clear();
        driver.findElement(By.xpath("//input[@id='search_input']")).sendKeys(text);
    }

    @Override
    public void submit() {
        driver.findElement(By.xpath("//input[@class='searchButton1']")).click();
    }

    @Override
    public void open() {
        driver.get("https://www.kinopoisk.ru/");
    }
}
