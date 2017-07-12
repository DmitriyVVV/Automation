package homeWork22;

import imap.ImapClient;
import imap.With;
import imap.*;
import org.apache.commons.mail.EmailException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy on 10.07.2017.
 */
public class KismiaTest {
//

    @Test
    public void registration() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://kismia.com");
        driver.findElement(By.cssSelector("#form-registration")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='iam-boy']")).click();
        driver.findElement(By.xpath("//div[@class='form-input']/input[@id='user-reg-myname']")).clear();
        driver.findElement(By.xpath("//div[@class='form-input']/input[@id='user-reg-myname']")).sendKeys("Alfred2");
        driver.findElement(By.xpath("//div[@id='block-first']/button[@class='submit']")).click();

        driver.findElement(By.xpath("//input[@id='user-reg-myemail']")).clear();
        driver.findElement(By.xpath("//input[@id='user-reg-myemail']")).sendKeys("automationtestsnew" + "+tyhtyh2" +"@gmail.com");
        driver.findElement(By.xpath("//input[@id='user-reg-mypass']")).clear();
        driver.findElement(By.xpath("//input[@id='user-reg-mypass']")).sendKeys("qwe1rty2");
        driver.findElement(By.xpath("//div[@id='block-last']/button[@class='submit']")).click();

        /*
        for(int o = 0; o<10; o++) {
            for (int i = 0; i < 8; i++) {
                driver.findElement(By.xpath("//label[@for='r" + i + "-0']")).click();
                Thread.sleep(100);
            }
            driver.findElement(By.xpath("//a[@class='button-FR button--variant-test-next button--green']")).click();
            Thread.sleep(500);
        }
        //надо еще анкету заполнить
        */
    }

    //@Test(priority = 2)
    public void readMessage() throws InterruptedException, EmailException, MessagingException, IOException {
        ImapClient imapClient = new ImapClient("automationtestsnew@gmail.com", "qwe1rty2");
        imapClient.connect();
        Message message = imapClient.findMessages(With.from("donotreply@kismia.com")).get(0);
        System.out.println(getTextFromMessage(message));
    }

    @Test(priority = 2)
    public void getLinks() throws InterruptedException, EmailException, MessagingException, IOException {
        ImapClient imapClient = new ImapClient("automationtestsnew@gmail.com", "qwe1rty2");
        imapClient.connect();
        Message message = imapClient.findMessages(With.from("donotreply@kismia.com")).get(0);
        //System.out.println(getTextFromMessage(message));

        MessageContent messageContent = new MessageContent(getTextFromMessage(message));
        messageContent.getLinkUrls();
        System.out.println(messageContent.getLinkUrls());
    }

    private String getTextFromMessage(Message message) throws MessagingException, IOException {
        String result = "";
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }

    private String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart)  throws MessagingException, IOException{
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            System.out.println(bodyPart.getContentType());
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice in my tests
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = html;
            } else if (bodyPart.getContent() instanceof MimeMultipart){
                result = result + getTextFromMimeMultipart((MimeMultipart)bodyPart.getContent());
            }
        }
        return result;
    }

}
