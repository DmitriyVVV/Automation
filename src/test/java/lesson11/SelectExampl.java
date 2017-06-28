package lesson11;

import core.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

/**
 * Created by Dmitriy on 22.05.2017.
 */
public class SelectExampl extends BrowserFactory{

    @Test
    public void testSelect() throws InterruptedException{
        driver.get("http://www.imdb.com/chart/top");
        Select select = new Select(driver.findElement(By.cssSelector(".lister-sort-by")));
        select.selectByIndex(2);
    }
}
