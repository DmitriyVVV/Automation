package forPivchik;

import com.google.gson.Gson;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Keyboard;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy on 03.07.2017.
 */
public class PlayGame {

    public static OkHttpClient okHttpClient = new OkHttpClient();

    Gson gson = new Gson();

    public static final String KEY ="9e7497068fe38b1ba67756718937911b";
    public static final String TOKEN = "fcab0f0e8a83a5437c433ee70c8c27049686833675958d8d03ef1bb1138cc798";
    public static final String BASE_URL = "https://api.trello.com/1/";
    public static String boardId = "kNuqDNYV";

    /*String idList = "59417be26de84e2f3c4f5953";
    String idCard = "5942814af8dbad5f294cc854";*/

    public static WebDriver driver = new ChromeDriver();
    public static boolean isNotFinished = true;


    //Создание листа
    public static String createList(String name) throws IOException {
        String url = BASE_URL +"boards/" + boardId + "/lists" + "?key="+ KEY + "&token=" + TOKEN;

        RequestBody requestBody = new FormBody.Builder()
                .add("name", name).build();
        //.add("idBoard", boardId).build();


        Request request = new Request.Builder().post(requestBody).url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }

    public static String createCArd(String name, int num) throws IOException{
        String url = BASE_URL + "cards" + "?key=" + KEY + "&token=" + TOKEN;

        String s = "";

        RequestBody requestBody = new FormBody.Builder()
                .add("name", name)
                .add("desc", s+num)
                .add("idList", "595a7ff7862e47bef751255e").build();

        Request request = new Request.Builder().post(requestBody).url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }


    public static void main(String args[]) throws IOException, InterruptedException{

        //System.out.println(createList("Score"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        String score = "";

        for(int i=0; i<2; i++) {
            int o = 0;
            driver.get("http://2048game.com/");
            Actions builder = new Actions(driver);

            do {

                //Thread.sleep(1000);
                builder.sendKeys(Keys.ARROW_UP).perform();
                //Thread.sleep(1000);
                builder.sendKeys(Keys.ARROW_RIGHT).perform();
                //Thread.sleep(1000);
                builder.sendKeys(Keys.ARROW_DOWN).perform();
                //Thread.sleep(1000);
                builder.sendKeys(Keys.ARROW_LEFT).perform();
                //Thread.sleep(1000);

                if(driver.findElement(By.cssSelector(".retry-button")).isDisplayed()){
                    score = driver.findElement(By.cssSelector(".scores-container .score-container")).getText();
                    driver.findElement(By.cssSelector(".retry-button")).click();
                    isNotFinished = false;
                    o++;
                    createCArd(score, o);
                }


            } while (/*isNotFinished*/true);


        }
        driver.close();
    }
}
