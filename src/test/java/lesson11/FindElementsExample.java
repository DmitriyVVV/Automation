package lesson11;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Dmitriy on 22.05.2017.
 */
public class FindElementsExample extends BrowserFactory{
    @Test
    public void testFindElement(){
        driver.get("http://www.imdb.com/chart/top");
        WebElement element = driver.findElement(By.cssSelector(".lister-list tr"));

        System.out.println(element.getText());
    }

    @Test
    public void testFindElemets(){
        driver.get("http://www.imdb.com/chart/top");

        List<WebElement> elements = driver.findElements(By.cssSelector(".lister tr"));

        for(WebElement element: elements){
            System.out.println(element.getText());
        }

    }
}
