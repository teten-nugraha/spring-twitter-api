package id.ten.forumservices.controller;

import id.ten.forumservices.dto.request.SignUpRequest;
import id.ten.forumservices.dto.request.SigninRequest;
import id.ten.forumservices.dto.response.SuccessResponse;
import id.ten.forumservices.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController extends BaseController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<SuccessResponse> signup(@RequestBody SignUpRequest request) {
        return ResponseEntity.ok(contructSuccessResponse(authenticationService.signup(request), "signup berhasil"));
    }

    @PostMapping("/signin")
    public ResponseEntity<SuccessResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(contructSuccessResponse(authenticationService.signin(request), "signin berhasil"));
    }
}
