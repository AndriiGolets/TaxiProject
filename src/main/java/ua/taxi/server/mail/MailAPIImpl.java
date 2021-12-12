package ua.taxi.server.mail;

import org.apache.log4j.Logger;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Properties;

/**
 * Created by andrii on 7/23/16.
 */
public class MailAPIImpl implements MailAPI{

    private static final Logger LOGGER = Logger.getLogger(MailAPIImpl.class);

    @Override
    public boolean sendMail(String yourEmail, String password, String toEmail, String subject, String body) {


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(yourEmail, password);
                    }
                });
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(yourEmail));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);

           return true;

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Map<LocalDateTime, String> getMail(String yourEmail, String password, String fromEmail) {
        return null;
    }
}
