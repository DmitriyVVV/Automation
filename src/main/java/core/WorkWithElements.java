package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static core.DriverActionsFactory.driver;
/**
 * Created by Dmitriy on 07.06.2017.
 */
public class WorkWithElements extends DriverActionsFactory{

    public WorkWithElements(By by, String name){
        this.by = by;
        this.name = name;
    }

    private int waitTime =15;
    private By by;
    private String name = "";

    public void click(){
        driver.findElement(by).click();
    }

    public void type(String text){
        find().clear();
        find().sendKeys(text);
    }

    public WebElement find(){
        getWebDriverWait(WaitTime.DEFAULT_ELEMENT_WAIT).until(ExpectedConditions.presenceOfElementLocated(by));
        return driver().findElement(by);
    }

    public String getAttribute(String attributeName){
        return find().getAttribute(attributeName);
    }
}
