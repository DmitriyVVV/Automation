package pageObject;

import core.DriverActionsFactory;
import core.WorkWithElements;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy on 12.06.2017.
 */
public class Matches extends DriverActionsFactory{
    public WorkWithElements like = new WorkWithElements(By.cssSelector(".icon--matches-like"), "LikeButton");
    public WorkWithElements dislike = new WorkWithElements(By.cssSelector(".icon--matches-dislike"), "DislikeButton");

    private WorkWithElements userIdElem = new WorkWithElements(By.cssSelector(".matches-carousel [data-uid]"), "UserIDElem");

    public void open(){
        get("http://kismia.com");
    }

    public String getCurrentId(){
        return userIdElem.getAttribute("data-uid");
    }

    public List<String> disLikeUser(int count){
        List<String> userIdList = new ArrayList<>();
        for(int i = 0; i<count; i++){
            String currentUSerId = getCurrentId();
            userIdList.add(currentUSerId);
            dislike.click();
        }
        return  userIdList;
    }
}
