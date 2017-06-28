package landings;

import org.testng.annotations.Test;

/**
 * Created by Dmitriy on 11.05.2017.
 */
public interface RegistrationMethods {

    void loginByFb(String login, String password);

    void loginByVk(String login, String password);

    void loginByMailRu(String login, String password);

    void loginByYandex(String login, String password);

    void loginByGmail(String login, String password);

    void loginByHotmail(String login, String password);

    void loginByYahoo(String login, String password);
}
