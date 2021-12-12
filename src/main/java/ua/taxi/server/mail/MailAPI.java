package ua.taxi.server.mail;

import java.time.LocalDateTime;
import java.util.Map;

/**
 * Created by andrii on 7/23/16.
 */
public interface MailAPI {

    boolean sendMail(String yourEmail, String password, String toEmail, String theme, String body);

    Map<LocalDateTime, String> getMail(String yourEmail, String password, String fromEmail);

}
