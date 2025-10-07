package util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class MailUtil {
    public static void sendMail(String to, String subject, String body, boolean bodyIsHTML)
            throws MessagingException {

        // Tài khoản Gmail
        final String from = "vmthuyvan25@gmail.com";
        final String password = "lqtifrrptvmjjznp"; // dùng app password, không dùng password thật

        // Config SMTP Gmail
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        // Tạo session có xác thực
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });

        // Soạn mail
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        if (bodyIsHTML)
            message.setContent(body, "text/html; charset=UTF-8");
        else
            message.setText(body);

        // Gửi mail
        Transport.send(message);
    }
}
