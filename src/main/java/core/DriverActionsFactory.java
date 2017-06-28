package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Dmitriy on 07.06.2017.
 */
public class DriverActionsFactory {
    protected static WebDriver driver;

    public static WebDriver driver(){
        return driver;
    }

    public void get(String url){
        driver.get(url);
        getWebDriverWait(WaitTime.DEFAULT_ELEMENT_WAIT).until(CustomConditions.pageLoaded());
    }

    protected WebDriverWait getWebDriverWait(long timeout){
        return new WebDriverWait(driver(), timeout);
    }
}
