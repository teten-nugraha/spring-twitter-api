package id.ten.forumservices.service.impl;

import id.ten.forumservices.dto.request.EmailPayload;
import id.ten.forumservices.service.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
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
    public void sendEmail(EmailPayload emailPayload) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(emailPayload.getDestination());
        message.setSubject(emailPayload.getSubject());
        message.setText(emailPayload.getBody());

        mailSender.send(message);
    }
}
