package lesson16;

import core.BrowserFactory;
import org.testng.annotations.Test;
import pageObject.Matches;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Dmitriy on 12.06.2017.
 */
public class TestMatchesPage extends BrowserFactory {
    Matches matches = new Matches();
    Map<String, Integer> duplicatePage = new HashMap<>();

    @Test
    public void likeDislike() throws InterruptedException{
        new TestLogin().tryLogin();
        matches.open();
        System.out.println(matches.getCurrentId());
        List<String> disLikeUsersLisr = matches.disLikeUser(10);
        Thread.sleep(5000);

        for(String uid: disLikeUsersLisr){
            if(duplicatePage.containsKey(uid)){
                duplicatePage.put(uid, duplicatePage.get((uid)+1));
            } else {
                duplicatePage.put(uid, 1);
            }

        }
        System.out.println(duplicatePage);
    }
}
