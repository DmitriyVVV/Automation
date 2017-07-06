package testForChakr;

import helper.CheckZipCode;
import helper.Factory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import helper.SkipPopUp;
/**
 * Created by Dmitriy on 24.05.2017.
 */
public class TestOfSettingsPage extends Factory{

    SkipPopUp obj = new SkipPopUp();

    @Test
    public void changeName() throws InterruptedException{

        obj.skipVerification(driver);

        driver.findElement(By.xpath("//header/div[1]/div[@class='dFTP']")).click();
        Thread.sleep(500);
        StringBuilder s = new StringBuilder(driver.findElement(By.xpath("//div[@class='_2Qng']")).getText());
        System.out.print("Old name : " + s);


        driver.findElement(By.xpath("//div/div[@class='_3TEv']")).click();
        driver.findElement(By.xpath("//a[@class='_8ysg _3GDC']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//div[@class='JHYZ'][1]//div[@class='_1Sh8']")).click();
        s.append("q");
        System.out.print(" New name: " + s);
        driver.findElement(By.xpath("//input[@name='name']")).clear();
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys(s.toString());
        driver.findElement(By.xpath("//div[@class='JHYZ _2sFO'][1]//div[@class='_1FWC']//button")).click();

        driver.findElement(By.xpath("//header/div[1]/div[@class='dFTP']")).click();
        Thread.sleep(500);
        System.out.println(" We have: " + driver.findElement(By.xpath("//div[@class='_2Qng']")).getText());
    }

    @Test
    public void changeData() throws InterruptedException{
        obj.skipVerification(driver);
        driver.findElement(By.xpath("//div/div[@class='_3TEv']")).click();
        driver.findElement(By.xpath("//a[@class='_8ysg _3GDC']")).click();

        StringBuilder s = new StringBuilder(driver.findElement(By.xpath("//div[@class='JHYZ'][2]//div[@class='z8Lh']")).getText());

        driver.findElement(By.xpath("//div[@class='JHYZ'][2]//div[@class='_1Sh8']")).click();

        Select selectYear = new Select(driver.findElement(By.xpath("//select[@name='year']")));
        double i1 = Math.random()*50+1;
        selectYear.selectByIndex((int)i1);

        Select selectMonth = new Select(driver.findElement(By.xpath("//select[@name='month']")));
        double i2 = Math.random()*11+1;
        selectMonth.selectByIndex((int)i2);

        Select selectDay = new Select(driver.findElement(By.xpath("//select[@name='day']")));
        double i3 = Math.random()*27+1;
        selectDay.selectByIndex((int)i3);

        if(driver.findElements(By.xpath("//div[@class='JHYZ _2sFO']//div[@class='_1FWC']//button")).size()>1){
            driver.findElement(By.xpath("//div[@class='JHYZ _2sFO'][2]//div[@class='_1FWC']//button")).click();
        } else {
            driver.findElement(By.xpath("//div[@class='JHYZ _2sFO']//div[@class='_1FWC']//button")).click();
        }

        Thread.sleep(1000);

        driver.navigate().refresh();
        Thread.sleep(500);
        System.out.println("Old data: " + s + " New data: " + driver.findElement(By.xpath("//div[@class='JHYZ'][2]//div[@class='z8Lh']")).getText());
    }

    @Test
    public void changeStatus(){
        obj.skipVerification(driver);
        driver.findElement(By.xpath("//div/div[@class='_3TEv']")).click();
        driver.findElement(By.xpath("//a[@class='_8ysg _3GDC']")).click();

        driver.findElement(By.xpath("//div[@class='JHYZ'][3]//div[@class='_1Sh8']")).click();
        Select select = new Select(driver.findElement(By.xpath("//select[@name='relationship']")));
        select.selectByIndex((int)(Math.random()*7+1));

        if(driver.findElements(By.xpath("//div[@class='JHYZ _2sFO']//div[@class='_1FWC']//button")).size()>2){
            driver.findElement(By.xpath("//div[@class='JHYZ _2sFO'][3]//div[@class='_1FWC']//button")).click();
        } else {
            driver.findElement(By.xpath("//div[@class='JHYZ _2sFO']//div[@class='_1FWC']//button")).click();
        }
    }

    @Test
    public void changeTyprOfRelationship()throws InterruptedException{
        obj.skipVerification(driver);
        driver.findElement(By.xpath("//header/div[1]/div[@class='dFTP']")).click();
        driver.findElement(By.xpath("//div/div[@class='_3TEv']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@class='_8ysg _3GDC']")).click();

        driver.findElement(By.xpath("//div[@class='JHYZ'][4]//div[@class='_1Sh8']")).click();
        Select select = new Select(driver.findElement(By.xpath("//select[@name='relationshipType']")));
        select.selectByIndex((int)(Math.random()+1));

        if(driver.findElements(By.xpath("//div[@class='JHYZ _2sFO']//div[@class='_1FWC']//button")).size()>2){
            driver.findElement(By.xpath("//div[@class='JHYZ _2sFO'][4]//div[@class='_1FWC']//button")).click();
        } else {
            driver.findElement(By.xpath("//div[@class='JHYZ _2sFO']//div[@class='_1FWC']//button")).click();
        }
    }

    @Test
    public void changeGender()throws InterruptedException{
        obj.skipVerification(driver);
        driver.findElement(By.xpath("//header/div[1]/div[@class='dFTP']")).click();
        driver.findElement(By.xpath("//div/div[@class='_3TEv']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@class='_8ysg _3GDC']")).click();

        driver.findElement(By.xpath("//div[@class='JHYZ'][5]//div[@class='_1Sh8']")).click();
        Select select = new Select(driver.findElement(By.xpath("//select[@name='gender']")));
        select.selectByIndex((int)(Math.random()+1));

        if(driver.findElements(By.xpath("//div[@class='JHYZ _2sFO']//div[@class='_1FWC']//button")).size()>2){
            driver.findElement(By.xpath("//div[@class='JHYZ _2sFO'][5]//div[@class='_1FWC']//button")).click();
        } else {
            driver.findElement(By.xpath("//div[@class='JHYZ _2sFO']//div[@class='_1FWC']//button")).click();
        }
    }

    @Test
    public void changeZipcode() throws InterruptedException{
        obj.skipVerification(driver);
        driver.findElement(By.xpath("//header/div[1]/div[@class='dFTP']")).click();
        driver.findElement(By.xpath("//div/div[@class='_3TEv']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@class='_8ysg _3GDC']")).click();
        driver.findElement(By.xpath("//div[@class='JHYZ'][6]//div[@class='_1Sh8']")).click();

        driver.findElement(By.xpath("//input[@name='zipcode']")).clear();
        driver.findElement(By.xpath("//input[@name='zipcode']")).sendKeys("11001");
        if(driver.findElements(By.xpath("//div[@class='JHYZ _2sFO']//div[@class='_1FWC']//button")).size()>3){
            driver.findElement(By.xpath("//div[@class='JHYZ _2sFO'][5]//div[@class='_1FWC']//button")).click();
        } else {
            driver.findElement(By.xpath("//div[@class='JHYZ _2sFO']//div[@class='_1FWC']//button")).click();
        }

        CheckZipCode zipCode = new CheckZipCode();
        System.out.println("True data about zipcode: ");
        System.out.print(zipCode.getcountryAndCityOfZip("11001"));

        driver.findElement(By.xpath("//header/div[1]/div[@class='dFTP']")).click();
        Thread.sleep(1000);

        StringBuilder cityAndState = new StringBuilder(driver.findElement(By.xpath("//div[@class='_1jde'][2]//span[@class='_6oHn']")).getText());
        cityAndState.append(" ");
        cityAndState.append(driver.findElement(By.xpath("//div[@class='_1jde'][1]//span[@class='_6oHn']")).getText());
        System.out.println();
        System.out.println("Our data about zipcode: " + cityAndState);
    }

    @Test
    public void checkSubscribing() throws InterruptedException {
        obj.skipVerification(driver);
        //driver.findElement(By.xpath("//header/div[1]/div[@class='dFTP']")).click();
        driver.findElement(By.xpath("//div/div[@class='_3TEv']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@class='_8ysg _3GDC']")).click();
        driver.findElement(By.xpath("//div[@class='JHYZ'][7]//div[@class='_1Sh8']")).click();

        driver.findElement(By.xpath("//label["+(int)(Math.random()+2)+"]/input[@type='radio']")).click();
        driver.findElement(By.xpath("//div[@class='JHYZ _2sFO']//div[@class='_1FWC']//button")).click();
    }
}
