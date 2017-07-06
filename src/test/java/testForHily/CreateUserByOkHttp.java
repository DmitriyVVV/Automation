package testForHily;

import okhttp3.*;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy on 05.07.2017.
 */
public class CreateUserByOkHttp {

    public static List<Cookie> cookies = new ArrayList<>();

    public OkHttpClient okHttpClient = new OkHttpClient.Builder().cookieJar(new DefaultCookieStorage())
            .addInterceptor(new UserAgentInterceptor("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_4)" +
            " AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")).build();



    @Test
    public void createUser() throws IOException{

        RequestBody requestBodyMainStep = new FormBody.Builder()
                .add("name", "Chak")
                .add("email", "v123d@testmail.com")
                .add("pwd", "qwe1rty2")
                .add("gender", "1")
                .add("captcha", "null").build();
        Request requestMainStep = new Request.Builder().url("http://auth.chakrads.com/registration").post(requestBodyMainStep).build();
        String s = okHttpClient.newCall(requestMainStep).execute().body().string();
        System.out.println(s);

        RequestBody requestBodyBirthDate = new FormBody.Builder()
                .add("birth_date", "1990-05-05").build();
        Request requestBirthDate = new Request.Builder().url("http://app.chakrads.com/user").post(requestBodyBirthDate).build();
        System.out.println(okHttpClient.newCall(requestBirthDate).execute().body().string());

        RequestBody requestBodyZipcode = new FormBody.Builder()
                .add("zipcode", "11001").build();
        Request requestZipcode = new Request.Builder().url("http://app.chakrads.com/user/geo/zipcode").post(requestBodyZipcode).build();
        System.out.println(okHttpClient.newCall(requestZipcode).execute().body().string());


        RequestBody requestBodyAvatar = new FormBody.Builder() //работать не должно, если работает то плохо
                .add("photo_id", "15447").build();
        Request requestAvatar = new Request.Builder().url("http://app.chakrads.com/user/photos/avatar").post(requestBodyAvatar).build();
        System.out.println(okHttpClient.newCall(requestAvatar).execute().body().string());


    }
}
