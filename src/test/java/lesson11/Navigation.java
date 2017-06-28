package lesson11;

import core.BrowserFactory;
import org.testng.annotations.Test;

/**
 * Created by Dmitriy on 22.05.2017.
 */
public class Navigation extends BrowserFactory{

    @Test
    public void testNavigation(){
        driver.get("http://google.com");
        driver.get("http://facebook.com");

        System.out.println("Current URL: " + driver.getCurrentUrl());

        driver.navigate().back();

        System.out.println("After.back() URL " + driver.getCurrentUrl());
        driver.navigate().forward();
        System.out.println("After forward URL " + driver.getCurrentUrl());
    }
}
