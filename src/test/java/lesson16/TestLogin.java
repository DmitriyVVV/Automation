package lesson16;

import core.BrowserFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pageObject.MainPage;
import pageObject.Matches;

/**
 * Created by Dmitriy on 12.06.2017.
 */
public class TestLogin extends BrowserFactory{
    Matches obj = new Matches();

    @Test
    public void tryLogin(){
        MainPage mainPage = new MainPage();
        obj.open();
        mainPage.loginForm.login("A2559597@MVRHT.NET", "qwe");

    }
}
