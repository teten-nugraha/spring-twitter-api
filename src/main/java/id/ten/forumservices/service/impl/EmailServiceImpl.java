package id.ten.forumservices.service.impl;

import id.ten.forumservices.dto.request.EmailPayload;
import id.ten.forumservices.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    @Async
    public void sendEmail(EmailPayload emailPayload) throws MessagingException {

        MimeMessage message = mailSender.createMimeMessage();

        message.setFrom(new InternetAddress("twitter-clone@mail.com"));
        message.setRecipients(MimeMessage.RecipientType.TO, emailPayload.getDestination());
        message.setSubject(emailPayload.getSubject());

        String content = "<!doctype html>\n" + "<html>\n"
                + "  <head>\n"
                + "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n"
                + "  </head>\n"
                + "  <body style=\"font-family: sans-serif;\">\n"
                + "    <div style=\"display: block; margin: auto; max-width: 600px;\" class=\"main\">\n"
                + "      <h1 style=\"font-size: 18px; font-weight: bold; margin-top: 20px\">Selamat, Account Anda sudah terdaftar dalam sistem kami</h1>\n"
                + "      <img alt=\"Inspect with Tabs\" src=\"https://assets-examples.mailtrap.io/integration-examples/welcome.png\" style=\"width: 100%;\">\n"
                + "      <p>Untuk mengaktifkan Account Anda, silahkan klik berikut</p><br>\n"
                + "      <p>"
                + emailPayload.getBody() + "</p>\n" + "    </div>\n"
                + "    <!-- Example of invalid for email html/css, will be detected by Mailtrap: -->\n"
                + "    <style>\n"
                + "      .main { background-color: white; }\n"
                + "      a:hover { border-left-width: 1em; min-height: 2em; }\n"
                + "    </style>\n"
                + "  </body>\n"
                + "</html>";

        message.setContent(content, "text/html");

        mailSender.send(message);
    }
}
