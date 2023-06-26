package id.ten.forumservices.service.impl;

import id.ten.forumservices.dto.request.EmailPayload;
import id.ten.forumservices.dto.request.SignUpRequest;
import id.ten.forumservices.dto.request.SigninRequest;
import id.ten.forumservices.dto.response.JwtAuthenticationResponse;
import id.ten.forumservices.entities.Role;
import id.ten.forumservices.entities.User;
import id.ten.forumservices.exceptions.ResourceAlreadyExistException;
import id.ten.forumservices.repositories.UserRepository;
import id.ten.forumservices.service.AuthenticationService;
import id.ten.forumservices.service.EmailService;
import id.ten.forumservices.service.JwtService;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final EmailService emailService;

    @Override
    public JwtAuthenticationResponse signup(SignUpRequest request) {

        Optional<User> existUser = userRepository.findByUsername(request.getUsername());
        if (existUser.isPresent()) {
            throw new ResourceAlreadyExistException("User sudah terdaftar");
        }

        var user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .isActive(false)
                .build();
        userRepository.save(user);
        sendEmailForUserSignUp(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponse signin(SigninRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = userRepository
                .findByUsername(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password."));
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponse.builder().token(jwt).build();
    }

    private void sendEmailForUserSignUp(User user) {
        final EmailPayload payload = generatePayload(user);
        emailService.sendEmail(payload);
    }

    private EmailPayload generatePayload(User user) {
        EmailPayload payload = EmailPayload.builder()
                .destination(user.getEmail())
                .subject("User Verification Link")
                .body("Klik link berikut untuk aktivasi http://localhost.com")
                .build();
        return payload;
    }
}
