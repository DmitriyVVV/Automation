package lesson8;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by Dmitriy on 10.05.2017.
 */
public class ParamsExample {
    @Test
    @Parameters({"userEmail"})
    public void login(String email){
        System.out.println(email);
    }
}
