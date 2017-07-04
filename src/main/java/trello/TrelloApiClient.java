package trello;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.testng.annotations.Test;


import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;


/**
 * Created by Dmitriy on 14.06.2017.
 */
public class TrelloApiClient {
    OkHttpClient okHttpClient = new OkHttpClient();

    Gson gson = new Gson();

    public static final String KEY ="9e7497068fe38b1ba67756718937911b";
    public static final String TOKEN = "fcab0f0e8a83a5437c433ee70c8c27049686833675958d8d03ef1bb1138cc798";
    public static final String BASE_URL = "https://api.trello.com/1/";
    public String boardId = "kNuqDNYV";

    public Board getBoard() throws IOException{
        String url = BASE_URL+"boards/"+boardId+"?key="+KEY+"&token="+TOKEN;
        Request request = new Request.Builder().url(url).build();
        String respJson = okHttpClient.newCall(request).execute().body().string();
        return gson.fromJson(respJson, Board.class);
    }

    //@Test
    public void ervijn() throws IOException {
        System.out.println(getBoard());
    }

    public String createList(String idBoard, String name) throws IOException{
        String url = BASE_URL +"lists" + "?key="+ KEY + "&token=" + TOKEN;

        RequestBody requestBody = new FormBody.Builder()
                .add("name", name)
                .add("idBoard", idBoard).build();

        Request request = new Request.Builder().post(requestBody).url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }

    //@Test
    public void listCreate()throws IOException {//не работает нихуя
        System.out.println(createList("JAck", Board.id));
    }

    //Создание карточки
    public String createCard(String name) throws IOException{
        String url = BASE_URL + "cards" + "?key=" + KEY + "&token=" + TOKEN;

        RequestBody requestBody = new FormBody.Builder()
                .add("name", name)
                .add("idList", "59417be26de84e2f3c4f5953").build();

        Request request = new Request.Builder().post(requestBody).url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }

    //@Test
    public void createCArd() throws IOException{
        System.out.println(createCard("Cartochka"));
    }


    //Нужны Id списков
    public String getIdLists() throws IOException{
        String url = BASE_URL + "boards/" + boardId + "/lists" + "?key=" + KEY + "&token=" + TOKEN;
        Request request = new Request.Builder().url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }

    //@Test
    public void getList()throws IOException {
        System.out.println(getIdLists());
    }

    //Получение списка карточек
    /*public String getListOfCards() throws IOException {
        String url = BASE_URL + "lists/" + "59417be26de84e2f3c4f5953" + "/cards/" + "all" + "?key=" + KEY + "&token=" + TOKEN;

        Request request = new Request.Builder().url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }*/

    //@Test
    public  void getListCards() throws  IOException {
        System.out.println(getListOfCards());
    }

    public List<TrelloList> getBoardList(String boardId) throws IOException {
        String url = BASE_URL + "boards/" + boardId + "/lists/" + "?key=" + KEY + "&token=" + TOKEN;
        Request request = new Request.Builder().url(url).build();
        String json =  okHttpClient.newCall(request).execute().body().string();
        Type type = new TypeToken<List<TrelloList>>(){}.getType();
        return  gson.fromJson(json, type);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    String idList = "59417be26de84e2f3c4f5953";
    String idCard = "5942814af8dbad5f294cc854";

    //Создание карточки
    public String createCArd(String name) throws IOException{
        String url = BASE_URL + "cards" + "?key=" + KEY + "&token=" + TOKEN;

        RequestBody requestBody = new FormBody.Builder()
                .add("name", name)
                .add("idList", idList).build();

        Request request = new Request.Builder().post(requestBody).url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }

    //Получение списка карточек в листе
    public String getListOfCards() throws IOException {
        String url = BASE_URL + "lists/" + idList + "/cards/" + "all" + "?key=" + KEY + "&token=" + TOKEN;

        Request request = new Request.Builder().url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }

    //Получение списка листов
    public String getListOfPages() throws IOException {
        String url = BASE_URL + "boards/" + boardId + "/lists" + "?key=" + KEY + "&token=" + TOKEN;

        Request request = new Request.Builder().url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }

    //Получение информации о карточке
    public String dataAboutCard() throws IOException {
        String url = BASE_URL + "cards/" +  "5942814af8dbad5f294cc854" + "&key=" + KEY + "&token=" + TOKEN;

        Request request = new Request.Builder().url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }

    //Создание листа
    public String createList(String name) throws IOException {
        String url = BASE_URL +"boards/" + boardId + "/lists" + "?key="+ KEY + "&token=" + TOKEN;

        RequestBody requestBody = new FormBody.Builder()
                .add("name", name).build();
                //.add("idBoard", boardId).build();


        Request request = new Request.Builder().post(requestBody).url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }


    //Комментирование карточки
    public String commentCard(String text) throws IOException {
        String url = BASE_URL + "cards/" + idCard + "/actions/comments" + "?key=" + KEY + "&token=" + TOKEN;

        RequestBody requestBody = new FormBody.Builder()
                .add("text", text).build();

        Request request = new Request.Builder().post(requestBody).url(url).build();
        return okHttpClient.newCall(request).execute().body().string();
    }


    @Test
    public void runRequest() throws IOException{
        //System.out.println(createCard("New Card"));
        //System.out.println(getListOfCards());
        //System.out.println(getListOfPages());
        //System.out.println(dataAboutCard());/**/
        //System.out.println(createList("New_List"));
        //System.out.println(commentCard("It is a comment."));/**/
    }
}
