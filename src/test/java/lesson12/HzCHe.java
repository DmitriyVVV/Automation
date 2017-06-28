package lesson12;

import core.BrowserFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Dmitriy on 24.05.2017.
 */
public class HzCHe extends BrowserFactory{
    @DataProvider
    public Object[][] pages(){
        return new Object[][]{
                { new ImdbSearchPage(driver)}
        };
    }

    @Test(dataProvider = "pages")
    public void testSearch(Searchpage searchpage){
        searchpage.open();
        searchpage.inputTExt("Стражи галактики");
        searchpage.submit();
    }


}
