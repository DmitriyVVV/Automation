package core;

import org.testng.annotations.Test;

/**
 * Created by Dmitriy on 07.06.2017.
 */
public class TestBrowserFActory extends BrowserFactory {
    @Test
    public void egfbeh(){
        get("http://google.com");
    }
}
