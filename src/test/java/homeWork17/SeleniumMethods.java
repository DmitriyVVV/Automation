package homeWork17;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.Set;


/**
 * Created by Dmitriy on 21.06.2017.
 */
public class SeleniumMethods {

    public WebDriver driver = new ChromeDriver();
    public WebDriverWait wait = new WebDriverWait(driver, 10);

    //взять залогиненые куки
    public void cookieTheft(String login, String password) throws InterruptedException{
        driver.manage().window().maximize();
        driver.get("https://trello.com/");
        driver.findElement(By.cssSelector(".mod-right > .global-header-section-button")).click();
        driver.findElement(By.cssSelector(".icon + .label")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='email']")));
        driver.findElement(By.xpath("//input[@type='email']")).clear();
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(login);
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys(Keys.ENTER);

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='password']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']")));
        driver.findElement(By.xpath("//input[@type='password']")).clear();
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys(Keys.ENTER);

        System.out.println(driver.manage().getCookies());
    }

    //@Test
    public void llogin() throws InterruptedException{

        driver.manage().window().maximize();
        driver.get("https://trello.com/");
        driver.manage().deleteAllCookies();
        Cookie cookie = new Cookie("name", "ZCD7biBQb1YoTmcjzXqJMQ2S8EscQOBjuZs6bi59nlUM4nRIPkjrhOElTZs3b5fQ-cG5zVyBQMCGXEOUCJZD9AdhfwrjENhy6LsvZwk8X83GcGBWEYZ9EVi0bo55NEw7");
        driver.manage().addCookie(cookie);
        Thread.sleep(5000);
        driver.navigate().refresh();
    }

    public void setCookie(){


    }

    //Реализовать метод для добавления чек-листа в карточку
    public void addCheckListToCard(){
        driver.get("https://trello.com/b/kNuqDNYV/testboard");
        driver.findElement(By.xpath
                ("//div[@class='js-list list-wrapper'][2]//div[@class='list-card js-member-droppable ui-droppable'][1]" +
                        "/div[@class='list-card-details']/a[@class='list-card-title js-card-name']")).click();
        driver.findElement(By.cssSelector(".js-add-checklist-menu")).click();
        driver.findElement(By.cssSelector(".js-add-checklist")).click();
    }

    //Добавление лейблов к карточке
    public void addLabelToCard(){
        driver.get("https://trello.com/b/kNuqDNYV/testboard");
        driver.findElement(By.xpath
                ("//div[@class='js-list list-wrapper'][2]//div[@class='list-card js-member-droppable ui-droppable'][1]" +
                        "/div[@class='list-card-details']/a[@class='list-card-title js-card-name']")).click();
        driver.findElement(By.cssSelector(".js-edit-labels")).click();
        driver.findElement(By.cssSelector(".card-label-green")).click();
    }

    //Передвинуть карточку из списка в другой список
    public void removeCArdToAnotherList(){
        driver.get("https://trello.com/b/kNuqDNYV/testboard");
        driver.findElement(By.xpath
                ("//div[@class='js-list list-wrapper'][2]//div[@class='list-card js-member-droppable ui-droppable'][1]" +
                        "/div[@class='list-card-details']/a[@class='list-card-title js-card-name']")).click();
        driver.findElement(By.cssSelector(".js-move-card")).click();
        Select select = new Select(driver.findElement(By.cssSelector(".js-select-list")));
        select.selectByIndex(3);
        driver.findElement(By.cssSelector(".js-submit"));
    }

    //Метод для обновления описания в созданной карточке
    public void updateDescription() {
        driver.get("https://trello.com/b/kNuqDNYV/testboard");
        driver.findElement(By.xpath
                ("//div[@class='js-list list-wrapper'][2]//div[@class='list-card js-member-droppable ui-droppable'][1]" +
                        "/div[@class='list-card-details']/a[@class='list-card-title js-card-name']")).click();
        driver.findElement(By.cssSelector(".js-hide-with-desc")).click();
        driver.findElement(By.cssSelector(".field")).clear();
        driver.findElement(By.cssSelector(".field")).sendKeys("DEscription");
        driver.findElement(By.cssSelector(".mod-submit-edit")).click();
    }

    //Метод для добавления комментария к карточке
    public void addCommentToCard(){
        driver.get("https://trello.com/b/kNuqDNYV/testboard");
        driver.findElement(By.xpath
                ("//div[@class='js-list list-wrapper'][2]//div[@class='list-card js-member-droppable ui-droppable'][1]" +
                        "/div[@class='list-card-details']/a[@class='list-card-title js-card-name']")).click();
        driver.findElement(By.cssSelector(".comment-frame > .comment-box > .comment-box-input")).clear();
        driver.findElement(By.cssSelector(".comment-frame > .comment-box > .comment-box-input")).sendKeys("Comment");
        driver.findElement(By.cssSelector(".js-add-comment")).click();
    }


}
/*


driver = new FirefoxDriver();
for(Cookie cookie : allCookies)
{
    driver.manage().addCookie(cookie);
}






* Cookie
* [NID=106=ZCD7biBQb1YoTmcjzXqJMQ2S8EscQOBjuZs6bi59nlUM4nRIPkjrhOElTZs3b5fQ-cG5zVyBQMCGXEOUCJZD9AdhfwrjENhy6LsvZwk8X83GcGBWEYZ9EVi0bo55NEw7; expires=Чт, 21 дек 2017 12:05:20 EET; path=/; domain=.google.com, OCAK=P3tg7O5sNGU32WBNQMkSkyZqjhmcxHeh3B_oOGCkR-c; path=/; domain=accounts.google.com;secure;, GAPS=1:HdUEPkk9xLEXJe_gGQR5-sOJ2jHERQ:7UNtgDMcAN8oQp1K; expires=Пт, 21 июн 2019 01:05:22 EEST; path=/; domain=accounts.google.com;secure;, CheckConnectionTempCookie140=231926; expires=Ср, 21 июн 2017 01:05:31 EEST; path=/accounts; domain=accounts.youtube.com]
*/