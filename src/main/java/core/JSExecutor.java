package core;

import org.openqa.selenium.JavascriptExecutor;

import static core.DriverActionsFactory.driver;
/**
 * Created by Dmitriy on 07.06.2017.
 */
public class JSExecutor {

    private static JavascriptExecutor executor (){
        return (JavascriptExecutor) driver();
    }

    public static Object executeScript(String script, Object ... arg){
        return executor().executeScript(script, arg);
    }
}
