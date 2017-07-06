package lesson20;

import org.testng.annotations.Test;

/**
 * Created by Dmitriy on 05.07.2017.
 */
public class TestEnum {

    @Test
    public void alalal(){


        ERROR invalidEmail = ERROR.INVALID_EMAIL_ERROR;

        System.out.println(invalidEmail.getMessage());

    }

}
