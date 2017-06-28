package Lesson14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

/**
 * Created by Dmitriy on 31.05.2017.
 */
public class CapabilityExample {
    WebDriver driver = new ChromeDriver();
    @Test
    public void ehnufijd(){
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability("pageLoadStratefy", "none");
        driver = new ChromeDriver(capabilities);
    }

}
