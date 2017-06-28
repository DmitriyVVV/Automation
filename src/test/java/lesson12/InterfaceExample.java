package lesson12;

import core.BrowserFactory;
import org.testng.annotations.Test;

/**
 * Created by Dmitriy on 24.05.2017.
 */
public class InterfaceExample extends BrowserFactory{

    @Test
    public void testSearch(){
        Searchpage searchpage = new ImdbSearchPage(driver);
        searchpage.open();
        searchpage.inputTExt("M");
        searchpage.submit();
    }
}
