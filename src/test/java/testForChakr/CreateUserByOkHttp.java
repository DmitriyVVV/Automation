package testForChakr;

import okhttp3.*;
import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Dmitriy on 05.07.2017.
 */
public class CreateUserByOkHttp {

    public OkHttpClient okHttpClient = new OkHttpClient.Builder().cookieJar(new DefaultCookieStorage())
            .addInterceptor(new UserAgentInterceptor("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_4)" +
            " AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36")).build();

    public static List<Cookie> cookies = new ArrayList<>();

    public String generateEmail(int size){

        String CHARACTERS = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";
        String uniquePart = "";

        for(int i=0; i<size; i++){
            double a = Math.random()*CHARACTERS.length();
            uniquePart+=CHARACTERS.charAt((int)a);
        }

        return "automationtestsnew+"  + uniquePart + "@gmail.com";
    }

    public String generateName(){
        String names[] = {"Jack", "Frank", "Bill", "Saymon", "Chak", "Samuel", "Tom", "Jerry", "John", "Govard", "Brad"};
        double a = Math.random()*names.length;
        return names[(int)a];
    }

    public void addEmailToList(String email){
        email = email + "||";
        String filePath = "C:\\\\Users\\\\Dmitriy\\\\Downloads\\notes3.txt";

        try {
            Files.write(Paths.get(filePath), email.getBytes(), StandardOpenOption.APPEND);
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }


    @Test
    public void createUser() throws IOException{


        String email = generateEmail(5);
        addEmailToList(email);

        RequestBody requestBodyMainStep = new FormBody.Builder()
                .add("name", generateName())
                .add("email", email)
                .add("pwd", "qwe1rty2")
                .add("gender", "1")
                .add("captcha", "null").build();
        Request requestMainStep = new Request.Builder().url("http://auth.chakrads.com/registration").post(requestBodyMainStep).build();
        //Response response = okHttpClient.newCall(requestMainStep).execute();
        String s  = okHttpClient.newCall(requestMainStep).execute().body().string();
        System.out.println(s);
        String accessToken = s.substring(s.indexOf("{\"accessToken\":\"")+16, s.indexOf("\",\"userId\""));
        String userId = s.substring(s.indexOf("\",\"userId\":")+11, s.indexOf(",\"expires\":"));
        String expires = s.substring(s.indexOf(",\"expires\":")+11, s.indexOf(",\"refreshToken\":\""));
        String refreshToken = s.substring(s.indexOf(",\"refreshToken\":\"")+17, s.indexOf("\"}"));

        System.out.println(accessToken);
        System.out.println(userId);
        System.out.println(expires);
        System.out.println(refreshToken);

        Cookie cookie;

        /*for(Cookie cookie: DefaultCookieStorage.cookies){
            System.out.println(cookie.name());
        }*/

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
