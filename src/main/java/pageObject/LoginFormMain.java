package pageObject;

import core.WorkWithElements;
import org.openqa.selenium.By;

/**
 * Created by Dmitriy on 12.06.2017.
 */
public class LoginFormMain extends LoginForm{

    private WorkWithElements emailFil = new WorkWithElements(By.cssSelector("#user-email"), "email");
    private WorkWithElements passFill = new WorkWithElements(By.cssSelector("#user-password"), "Pass");
    private WorkWithElements loginButton = new WorkWithElements(By.cssSelector("#sign-in-form > .submit"), "Login");

    @Override
    protected void TypeLogin(String login) {
        emailFil.type(login);
    }

    @Override
    protected void typePassword(String password) {
        passFill.type(password);
    }

    @Override
    protected void clickSubmit() {
        loginButton.click();
    }
}
