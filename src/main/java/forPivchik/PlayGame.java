package forPivchik;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy on 03.07.2017.
 */
public class PlayGame {

    public static OkHttpClient okHttpClient = new OkHttpClient();

    public static final String KEY ="9e7497068fe38b1ba67756718937911b";
    public static final String TOKEN = "fcab0f0e8a83a5437c433ee70c8c27049686833675958d8d03ef1bb1138cc798";
    public static final String BASE_URL = "https://api.trello.com/1/";
    public static String boardId = "kNuqDNYV";


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

        //System.out.println(createList("Score")); //если нужен новый лист

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        String score = "";

            int o = 0;
            driver.get("http://2048game.com/");
            Actions builder = new Actions(driver);

            do {

                builder.sendKeys(Keys.ARROW_UP).perform();
                builder.sendKeys(Keys.ARROW_RIGHT).perform();
                builder.sendKeys(Keys.ARROW_DOWN).perform();
                builder.sendKeys(Keys.ARROW_LEFT).perform();

                if(driver.findElement(By.cssSelector(".retry-button")).isDisplayed()){
                    score = driver.findElement(By.cssSelector(".scores-container .score-container")).getText();
                    driver.findElement(By.cssSelector(".retry-button")).click();
                    isNotFinished = false;
                    o++;
                    createCArd(score, o);
                }

            } while (o<10);

        driver.close();
    }
}