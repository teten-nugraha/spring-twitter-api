package id.ten.forumservices.service;

import id.ten.forumservices.dto.request.EmailPayload;

public interface EmailService {
    public void sendEmail(EmailPayload emailPayload);
}
