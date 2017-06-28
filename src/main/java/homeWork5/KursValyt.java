package homeWork5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
/**
 * Created by Dmitriy on 21.04.2017.
 */
public class KursValyt {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException
    {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        /*-----------------------------------------Privat24--------------------------------------------------*/
        driver.get("https://www.privat24.ua");
        String privat24Str = driver.getPageSource();
        String strForPrivat24  = "<div class=\"section-content rate\">";

        String strWithKurs = privat24Str.substring(privat24Str.indexOf("<div class=\"section-content rate\">")+strForPrivat24.length(),
                privat24Str.indexOf("<div class=\"section-content rate\">")+strForPrivat24.length()+17);

        String pokupkaGrivniStr = strWithKurs.substring(2,8);
        String prodajaGrivniStr = strWithKurs.substring(11,17);

        double pokupkaGrivni = Double.valueOf(pokupkaGrivniStr);
        double prodajaGrivni = Double.valueOf(prodajaGrivniStr);

        System.out.println("Курс покупки доллара в приватбанке: " + pokupkaGrivni);
        System.out.println("Курс продажи доллара в приватбанке: " + prodajaGrivni);

        /*--------------------------------------------------------------------------------------------------*/
        driver.get("https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/");
        String ukrSibStr = driver.getPageSource();

        String strOfHTML = "<tr><td>USD</td><td>доллар США</td>";


        String strWithData = ukrSibStr.substring(
                ukrSibStr.indexOf("<tr><td>USD</td><td>доллар США</td>"),
                ukrSibStr.indexOf("<tr><td>USD</td><td>доллар США</td>")+strOfHTML.length()+50);

        String str[] = strWithData.split("<td>", 7);

        String pokupkaGriviVUkrsibStr = str[3].substring(0,7);
        String prodajaGrivniVUkrsibStr = str[4].substring(0,7);

        pokupkaGriviVUkrsibStr = pokupkaGriviVUkrsibStr.replace(',','.');
        prodajaGrivniVUkrsibStr = prodajaGrivniVUkrsibStr.replace(',','.');

        double pokupkaGrivniVUkrsib = Double.valueOf(pokupkaGriviVUkrsibStr);
        double prodajaGrivniVUkrsib = Double.valueOf(prodajaGrivniVUkrsibStr);

        System.out.println("Курс покупки доллара в УкрСибБанке: " + pokupkaGrivniVUkrsib);
        System.out.println("Курс продажи доллара в УкрСибБанке: " + prodajaGrivniVUkrsib);

        /*-------------------------------------------------Aval--------------------------------------------------------*/
        driver.get("https://www.aval.ua/ru/personal/everyday/exchange/exchange/");
        String strAval = driver.getPageSource();

        String dataAval  = "Продажа</th></tr><tr><td class=\"name\">Доллары США</td><td class=\"right\">";
        String strWithDataOFAval = strAval.substring(strAval.indexOf("Продажа</th></tr><tr><td class=\"name\">Доллары США</td><td class=\"right\">")+dataAval.length()-30,
                strAval.indexOf("Продажа</th></tr><tr><td class=\"name\">Доллары США</td><td class=\"right\">")+dataAval.length()+50);

        String strArAval[] = strWithDataOFAval.split("<td class=\"right\">", 10);

        String pokupkaGrivniAvalStr = strArAval[1].substring(0,6);
        String prodajaGrivniAvalStr = strArAval[2].substring(0,6);

        pokupkaGrivniAvalStr = pokupkaGrivniAvalStr.replace(',','.');
        prodajaGrivniAvalStr = prodajaGrivniAvalStr.replace(',','.');

        double pokupkaGrivniAval = Double.valueOf(pokupkaGrivniAvalStr);
        double prodajaGrivniAval = Double.valueOf(prodajaGrivniAvalStr);

        System.out.println("Курс покупки доллара в банке Аваль: " + pokupkaGrivniAval);
        System.out.println("Курс продажи доллара в банке Аваль: " + prodajaGrivniAval);

        /*---------------------------------------------Oshadbank--------------------------------------------------------------*/
        driver.get("http://www.oschadbank.ua/ua/");
        String strOshad = driver.getPageSource();
        String tempOshad = "<strong class=\"buy-USD\"";

        String dataOshad = strOshad.substring(strOshad.indexOf("<strong class=\"buy-USD\"")+tempOshad.length(),
                strOshad.indexOf("<strong class=\"buy-USD\"")+tempOshad.length()+100);

        String pokupkaGrivniOshadStr = dataOshad.substring(dataOshad.indexOf("</strong>")-7, dataOshad.indexOf("</strong>"));
        String prodajaGrivniOshadStr = dataOshad.substring(dataOshad.lastIndexOf("</strong>")-7, dataOshad.lastIndexOf("</strong>"));

        pokupkaGrivniOshadStr = pokupkaGrivniOshadStr.replace(',','.');
        prodajaGrivniOshadStr = prodajaGrivniOshadStr.replace(',','.');

        double pokupkaGrivniOshad = Double.valueOf(pokupkaGrivniOshadStr);
        double prodajaGrivniOshad = Double.valueOf(prodajaGrivniOshadStr);

        System.out.println("Курс покупки доллара в ОщадБанке: " + pokupkaGrivniOshad);
        System.out.println("Курс продажи доллара в ОщадБанке: " + prodajaGrivniOshad);

        /*------------------------------------------------NBU------------------------------------------------------------*/
        driver.get("http://www.bank.gov.ua/control/uk/curmetal/detail/currency?period=daily");
        String strNBU = driver.getPageSource();
        //<td class="cell_c">
        String dataNBU = strNBU.substring(strNBU.indexOf("Долар США"), strNBU.indexOf("Долар США") + 100);

        String nbuStr = dataNBU.substring(45, 54);
        double nbuF = Double.valueOf(nbuStr);
        double officialCursForBill = nbuF/100;


                /*------------------------------------------Вычисления-----------------------------------------------------*/

        //Средний курс покупки и продажи
        System.out.println("Средний курс покупки доллара: " +
                (pokupkaGrivni + pokupkaGrivniAval + pokupkaGrivniOshad + pokupkaGrivniVUkrsib + officialCursForBill)/5);
        System.out.println("Средний курс продажи валюты: " +
                (prodajaGrivni + prodajaGrivniAval + prodajaGrivniOshad + prodajaGrivniVUkrsib + officialCursForBill)/5);


        //Названия банков
        String[] nameOfBanks = {"ПриватБанк", "Банк Аваль", "Ощадбанк", "УкрсСибБанк", "НБУ"};

        //Банк с самым низким курсом покупки доллара
        double[] minPokupka = {pokupkaGrivni, pokupkaGrivniAval, pokupkaGrivniOshad, pokupkaGrivniVUkrsib, officialCursForBill};
        double min = minPokupka[0];
        int indexOfMin = 0;

        for (int i = 1; i<minPokupka.length; i++)
            if (minPokupka[i]<min) {
                min = minPokupka[i];
                indexOfMin = i;
            }

        System.out.println("Банк с самым низким курсом покупки доллара: " + nameOfBanks[indexOfMin]);

        //Банк с самым высоким курсом продажи
        double[] maxProdaja = {prodajaGrivni, prodajaGrivniAval, prodajaGrivniOshad, prodajaGrivniVUkrsib, officialCursForBill};
        double max = maxProdaja[0];
        int indexOfMax = 0;

        for (int counter = 1; counter<maxProdaja.length; counter++)
            if (maxProdaja[counter]> max){
                max = maxProdaja[counter];
                indexOfMax = counter;
            }

        System.out.println("Банк с самым высоким курсом продажи доллара: " + nameOfBanks[indexOfMax]);




        driver.quit();
    }
}
