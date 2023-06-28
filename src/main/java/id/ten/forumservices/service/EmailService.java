package id.ten.forumservices.service;

import id.ten.forumservices.dto.request.EmailPayload;
import jakarta.mail.MessagingException;

public interface EmailService {
    void sendEmail(EmailPayload emailPayload) throws MessagingException;
}
