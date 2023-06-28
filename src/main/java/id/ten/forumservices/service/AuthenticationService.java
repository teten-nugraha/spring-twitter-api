package id.ten.forumservices.service;

import id.ten.forumservices.dto.request.SignUpRequest;
import id.ten.forumservices.dto.request.SigninRequest;
import id.ten.forumservices.dto.response.JwtAuthenticationResponse;
import jakarta.mail.MessagingException;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request) throws MessagingException;

    JwtAuthenticationResponse signin(SigninRequest request);

    String activations(String activationCode);
}
