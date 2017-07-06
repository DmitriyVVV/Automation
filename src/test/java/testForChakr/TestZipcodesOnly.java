package testForHily;

import helper.CheckZipCode;
import helper.Factory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by Dmitriy on 24.05.2017.
 */
public class TestZipcodesOnly extends Factory{

    public String generateZip(){
        StringBuilder stringZip = new StringBuilder();

        int zipInt = 1001+(int)(Math.random()*99929+1-1001);
        stringZip.append(zipInt);

        if(stringZip.length()<2){
            stringZip.reverse();
            stringZip.append("0000");
            stringZip.reverse();
        } else {
            if(stringZip.length()<3){
                stringZip.reverse();
                stringZip.append("000");
                stringZip.reverse();
            } else {
                if(stringZip.length()<4){
                    stringZip.reverse();
                    stringZip.append("00");
                    stringZip.reverse();
                } else {
                    if(stringZip.length()<5){
                        stringZip.reverse();
                        stringZip.append("0");
                        stringZip.reverse();
                    }
                }
            }
        }
        return stringZip.toString();
    }

    @Test
    public void testDifferentCodes() throws InterruptedException {
        int i= 0;
        int q = 0;

        while (true) {
            StringBuilder s;

            while (true) {
                q++;
                driver.findElement(By.xpath("//header/div[1]/div[@class='dFTP']")).click();
                driver.findElement(By.xpath("//div/div[@class='_3TEv']")).click();
                Thread.sleep(500);
                driver.findElement(By.xpath("//a[@class='_8ysg _3GDC']")).click();
                driver.findElement(By.xpath("//div[@class='JHYZ'][5]//div[@class='_1Sh8']")).click();
                driver.findElement(By.xpath("//input[@name='zipcode']")).clear();
                s = new StringBuilder(generateZip());
                driver.findElement(By.xpath("//input[@name='zipcode']")).sendKeys(s.toString());
                Thread.sleep(500);
                driver.findElement(By.xpath("//div[@class='JHYZ _2sFO']//div[@class='_1FWC']//button")).click();
                Thread.sleep(500);
                if (driver.findElements(By.xpath("//div[@class='JHYZ _2sFO']//div[@class='_3mt2']")).size() > 0) {
                    System.out.println(i + "." + q + ". Invalid zipcode");
                } else {
                    break;
                }
            }




            CheckZipCode zipCode = new CheckZipCode();
            System.out.println("True data about zipcode: ");
            System.out.print(zipCode.getcountryAndCityOfZip(s.toString()));

            driver.findElement(By.xpath("//header/div[1]/div[@class='dFTP']")).click();
            Thread.sleep(500);

            StringBuilder cityAndState = new StringBuilder(driver.findElement(By.xpath("//div[@class='_1jde'][2]//span[@class='_6oHn']")).getText());
            cityAndState.append(" ");
            cityAndState.append(driver.findElement(By.xpath("//div[@class='_1jde'][1]//span[@class='_6oHn']")).getText());
            System.out.println();
            System.out.println("Our data about zipcode: " + cityAndState);
            i++;
            if(i>50){
                break;
            }
        }
    }

}
