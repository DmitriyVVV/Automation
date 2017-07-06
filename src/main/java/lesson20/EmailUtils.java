package lesson20;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.testng.annotations.Test;
import imap.*;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMultipart;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitriy on 05.07.2017.
 */
public class EmailUtils {


    @Test
    public void alala() throws EmailException {
        Email email = new SimpleEmail();
        email.setHostName("smtp.gmail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("automationtestsnew@gmail.com", "qwe1rty2"));
        email.setSSLOnConnect(true);
        email.setFrom("automationtestsnew@gmail.com");
        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("automationtestsnew@gmail.com");
        email.send();
    }

    @Test
    public void alalalall() throws InterruptedException, EmailException, MessagingException, IOException {
        ImapClient imapClient = new ImapClient("automationtestsnew@gmail.com", "qwe1rty2");
        imapClient.connect();
        List<Message> messages = imapClient.findMessages(With.from("noreply@chakrads.com"));
        for(Message message : messages){
            System.out.println(message.getSubject());
        }
    }

    @Test
    public void readMessage() throws InterruptedException, EmailException, MessagingException, IOException {
        ImapClient imapClient = new ImapClient("automationtestsnew@gmail.com", "qwe1rty2");
        imapClient.connect();
        Message message = imapClient.findMessages(With.from("noreply@chakrads.com")).get(0);
        System.out.println(getTextFromMessage(message));
    }

    @Test
    public void getLinks() throws InterruptedException, EmailException, MessagingException, IOException {
        ImapClient imapClient = new ImapClient("automationtestsnew@gmail.com", "qwe1rty2");
        imapClient.connect();
        Message message = imapClient.findMessages(With.from("noreply@chakrads.com")).get(0);
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
