package jsoupExample;

import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.io.IOException;

/**
 * Created by Dmitriy on 21.06.2017.
 */
public class JsoupExample{
    public WebDriver driver = new ChromeDriver();

    //@Test
    public void lalala() throws IOException{
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new UserAgentInterceptor("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")).build();

        String html = client.newCall(new Request.Builder().url("http://www.business-template.com/").build()).execute().body().string();

        Document document = Jsoup.parse(html);

        System.out.println(document.body());
        Elements elements = document.select(".exchange-rates-container .rate");

        Request request = new Request.Builder().url("http://business-template.com").build();
       // Response response = okHttpClient.newCall(request).execute();


    }

    @Test
    public void lalalala() throws IOException{
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new UserAgentInterceptor("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_4) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")).build();

        String html = client.newCall(new Request.Builder().url("https://kismia.com").build()).execute().body().string();

        Document document = Jsoup.parse(html);

        for(Cookie cookie: TestCookies.cookies){
            System.out.println(cookie.name());
        }

        RequestBody requestBody = new FormBody.Builder()
                .add("email", "A2559597@MVRHT.NET")
                .add("password", "qwe").build();
        Request request = new Request.Builder().url("https://kismia.com/sign/in/").post(requestBody).build();

        System.out.println(client.newCall(request).execute().body().string());

        driver.get("https://kismia.com/sign/in/");
    }

}
