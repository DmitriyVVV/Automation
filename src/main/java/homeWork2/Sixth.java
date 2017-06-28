package homeWork2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy on 06.04.2017.
 */
public class Sixth {

    public static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

        driver.manage().window().maximize();

        /*---------------------------Сбор данных с сайтов------------------------*/

        //Privat24
        driver.get("https://www.privat24.ua");
        String textFromPage = driver.findElement(By.xpath("//div[1]/div[@class='section-content rate']")).getText(); //возврат текта елемента

        String pokupkaGrivniStr = textFromPage.substring(0,5);
        String prodajaGrivniStr = textFromPage.substring(9,14);

        double pokupkaGrivni = Double.valueOf(pokupkaGrivniStr);
        double prodajaGrivni = Double.valueOf(prodajaGrivniStr);

        System.out.println("Курс покупки доллара в приватбанке: " + pokupkaGrivni);
        System.out.println("Курс продажи доллара в приватбанке: " + prodajaGrivni);

        //Ukrsibbank
        driver.get("https://my.ukrsibbank.com/ru/personal/operations/currency_exchange/");
        String pokupkaGriviVUkrsibStr = driver.findElement(By.xpath("//table[@class='stripeMe content_tbl2']//tr[1]/td[3]")).getText(); //покупка
        String prodajaGrivniVUkrsibStr = driver.findElement(By.xpath("//table[@class='stripeMe content_tbl2']//tr[1]/td[4]")).getText(); // продажа

        pokupkaGriviVUkrsibStr = pokupkaGriviVUkrsibStr.replace(',','.');
        prodajaGrivniVUkrsibStr = prodajaGrivniVUkrsibStr.replace(',','.');

        double pokupkaGrivniVUkrsib = Double.valueOf(pokupkaGriviVUkrsibStr);
        double prodajaGrivniVUkrsib = Double.valueOf(prodajaGrivniVUkrsibStr);

        System.out.println("Курс покупки доллара в УкрСибБанке: " + pokupkaGrivniVUkrsib);
        System.out.println("Курс продажи доллара в УкрСибБанке: " + prodajaGrivniVUkrsib);

        //Aval
        driver.get("https://www.aval.ua/ru/personal/everyday/exchange/exchange/");
        String pokupkaGrivniAvalStr = driver.findElement(By.xpath("//div[@class='body-currency-block-rba']/table[@class='body-currency']//tr[2]/td[@class='right'][1]")).getText();
        String prodajaGrivniAvalStr = driver.findElement(By.xpath("//div[@class='body-currency-block-rba']/table[@class='body-currency']//tr[2]/td[@class='right'][2]")).getText();

        pokupkaGrivniAvalStr = pokupkaGrivniAvalStr.replace(',','.');
        prodajaGrivniAvalStr = prodajaGrivniAvalStr.replace(',','.');

        double pokupkaGrivniAval = Double.valueOf(pokupkaGrivniAvalStr);
        double prodajaGrivniAval = Double.valueOf(prodajaGrivniAvalStr);

        System.out.println("Курс покупки доллара в банке Аваль: " + pokupkaGrivniAval);
        System.out.println("Курс продажи доллара в банке Аваль: " + prodajaGrivniAval);

        //Oshadbank
        driver.get("http://www.oschadbank.ua/ua/");
        String pokupkaGrivniOshadStr = driver.findElement(By.xpath("//strong[@class='buy-USD']")).getText();
        String prodajaGrivniOshadStr = driver.findElement(By.xpath("//strong[@class='sell-USD']")).getText();

        pokupkaGrivniOshadStr = pokupkaGrivniOshadStr.replace(',','.');
        prodajaGrivniOshadStr = prodajaGrivniOshadStr.replace(',','.');

        double pokupkaGrivniOshad = Double.valueOf(pokupkaGrivniOshadStr);
        double prodajaGrivniOshad = Double.valueOf(prodajaGrivniOshadStr);

        System.out.println("Курс покупки доллара в ОщадБанке: " + pokupkaGrivniOshad);
        System.out.println("Курс продажи доллара в ОщадБанке: " + prodajaGrivniOshad);

        //NBU
        driver.get("http://www.bank.gov.ua/control/uk/curmetal/detail/currency?period=daily");
        String officialCursStr = driver.findElement(By.xpath("//tr[9]/td[@class='cell_c'][4]")).getText();
        String quantityOfBillsStr = driver.findElement(By.xpath("//tr[9]/td[@class='cell_c'][3]")).getText();

        double officialCurs = Double.valueOf(officialCursStr);
        double quantityOfBills = Double.valueOf(quantityOfBillsStr);

        double officialCursForBill = officialCurs/quantityOfBills;

        System.out.println("Официальный курс доллара НБУ: " + officialCursForBill);

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
