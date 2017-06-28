package homeWork18;

import okhttp3.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy on 22.06.2017.
 */
public class TestsWithOkHttpAndJsoup {

    public OkHttpClient okHttpClient = new OkHttpClient.Builder().cookieJar(new DefaultCookieStorage())
            .addInterceptor(new UserAgentInterceptor("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_4)" +
                    " AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")).build();

    public List<String> listOfUsers = new ArrayList<>();

    public int ageFrom = 20;
    public int ageTo = 32;

    @Test
    public void checkRepeats() throws IOException {

        RequestBody requestBody = new FormBody.Builder()
                .add("email", "A2559597@MVRHT.NET")
                .add("password", "qwe").build();
        Request request = new Request.Builder().url("https://kismia.com/sign/in/").post(requestBody).build();
        okHttpClient.newCall(request).execute().body().string();

        Request request1 = new Request.Builder().url("https://kismia.com/matches").build();

        int u = 0;
        do {

            String trueDocOfMatches = okHttpClient.newCall(request1).execute().body().string();

            Document document1 = Jsoup.parse(trueDocOfMatches);

            Element id = document1.select("div.matches").first();

            System.out.println("<--------------------------------------------------------------------------------------->");
            System.out.println(id.attr("data-yes-user-id")); //хапаем id юзера

            if(listOfUsers.contains(id.attr("data-yes-user-id"))){
                System.out.println("Repeated user");
                System.out.println("!!!ERROR!!!");
                break;
            } else {
                listOfUsers.add(id.attr("data-yes-user-id"));
            }


            RequestBody requestBodyButton = new FormBody.Builder()
                    .add("answer", "1")
                    .add("user_id", id.attr("data-yes-user-id").toString()).build();
            Request requestButton = new Request.Builder().url("https://kismia.com/matches").post(requestBodyButton).build();

            okHttpClient.newCall(requestButton).execute().body();

            u++;
        } while (u<5);

        System.out.println("<--------------------------------------------------------------------------------------->");

    }

    @Test(priority = 2)
    public void checkAges() throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("email", "A2559597@MVRHT.NET")
                .add("password", "qwe").build();
        Request request = new Request.Builder().url("https://kismia.com/sign/in/").post(requestBody).build();
        okHttpClient.newCall(request).execute().body().string();

        for(int userNum = 0; userNum<listOfUsers.size(); userNum++){
            Request request1 = new Request.Builder().url("https://kismia.com/u"+ listOfUsers.get(userNum)).build();
            String usersPage = okHttpClient.newCall(request1).execute().body().string();

            Document document1 = Jsoup.parse(usersPage);

            Element id = document1.select("div.inform-col").first();

            String age = id.text();
            age = age.substring(age.indexOf(", ")+2, age.indexOf(", ")+4);

            Integer intAge = new Integer(age);

            System.out.println(intAge);
            if(intAge<ageFrom ||intAge>ageTo){
                System.out.println("Wrong age");
                System.out.println("!!!ERROR!!!");
                break;
            }
        }

    }

    @Test(priority = 1)
    public void setAges() throws IOException {
        RequestBody requestBody = new FormBody.Builder()
                .add("email", "A2559597@MVRHT.NET")
                .add("password", "qwe").build();
        Request request = new Request.Builder().url("https://kismia.com/sign/in/").post(requestBody).build();
        okHttpClient.newCall(request).execute().body().string();

        Request request1 = new Request.Builder().url("https://kismia.com/profile/settings/").build();
        okHttpClient.newCall(request1).execute().body().string();

        RequestBody requestBodyForSetAgeAndGender = new FormBody.Builder()
                .add("search_age_from", ""+ageFrom)
                .add("search_age_to", ""+ageTo)
                .add("search_gender", "f").build();
        Request requestForAgeAndGender = new Request.Builder().url("https://kismia.com/restapi/user/settings/search").post(requestBodyForSetAgeAndGender).build();
        okHttpClient.newCall(requestForAgeAndGender).execute().body();
    }
}

/*
* имя емеил
* ссш
*
* */