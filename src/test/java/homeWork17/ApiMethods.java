package homeWork17;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * Created by Dmitriy on 20.06.2017.
 */
public class ApiMethods {
    OkHttpClient okHttpClient = new OkHttpClient();

    public static final String KEY = "9e7497068fe38b1ba67756718937911b";
    public static final String TOKEN = "fcab0f0e8a83a5437c433ee70c8c27049686833675958d8d03ef1bb1138cc798";
    public static final String BASE_URL = "https://api.trello.com/1/";
    public static final String BOARD_ID = "kNuqDNYV";

    String idList = "59417be26de84e2f3c4f5953";
    String idCard = "5942814af8dbad5f294cc854";

    //Реализовать метод для добавления чек-листа в карточку
    public String addCheckListToCard() throws IOException {
        String url = BASE_URL + "cards/" + idCard + "/checklists" + "?key=" + KEY + "&token=" + TOKEN;

        RequestBody requestBody = new FormBody.Builder().build();

        Request request = new Request.Builder().post(requestBody).url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }

    //Добавление лейблов к карточке
    public String addLabel(String color) throws IOException {
        String url = BASE_URL + "cards/" + idCard + "/labels" + "?key=" + KEY + "&token=" + TOKEN;

        RequestBody requestBody = new FormBody.Builder()
                .add("color", color).build();

        Request request = new Request.Builder().post(requestBody).url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }

    //Передвинуть карточку из списка в другой список
    public String removeCardToAnotherList(String cardId, String neededList) throws IOException {
        String url = BASE_URL + "cards/" + cardId + "/idList" + "?key=" + KEY + "&token=" + TOKEN;

        RequestBody requestBody = new FormBody.Builder()
                .add("value", neededList).build();

        Request request = new Request.Builder().put(requestBody).url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }

    //Метод для обновления описания в созданной карточке
    public String updateDescription(String cardId, String newDescrition) throws IOException {
        String url = BASE_URL + "cards/" + cardId + "/desc" + "?key=" + KEY + "&token=" + TOKEN;

        RequestBody requestBody = new FormBody.Builder()
                .add("value", newDescrition).build();

        Request request = new Request.Builder().put(requestBody).url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }

    //Метод для добавления комментария к карточке
    public String addComment(String text) throws IOException {
        String url = BASE_URL + "cards/" + idCard + "/actions/comments" + "?key=" + KEY + "&token=" + TOKEN;

        RequestBody requestBody = new FormBody.Builder()
                .add("text", text).build();

        Request request = new Request.Builder().post(requestBody).url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }

    @Test
    public void testMethods() throws IOException {
        //System.out.println(addCheckListToCard());
        //System.out.println(addLabel("red"));
        //System.out.println(updateDescription(idCard, "Check"));
        //System.out.println(addComment("New Comment"));
        //System.out.println(removeCardToAnotherList(idCard, "594172e5387732334d5ca276"));
    }


}
