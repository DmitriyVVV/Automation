package pageObject;

import core.DriverActionsFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Dmitriy on 12.06.2017.
 */
public abstract class LoginForm extends DriverActionsFactory{

    protected abstract void TypeLogin(String login);

    protected abstract void typePassword(String password);

    protected abstract void clickSubmit();

    public void login(String login, String password){
        TypeLogin(login);
        typePassword(password);
        clickSubmit();
        getWebDriverWait(10).until(ExpectedConditions.urlContains(".com/u"));
    }
}
