package id.ten.forumservices.controller;

import id.ten.forumservices.dto.request.SignUpRequest;
import id.ten.forumservices.dto.request.SigninRequest;
import id.ten.forumservices.dto.response.ErrorResponse;
import id.ten.forumservices.dto.response.SuccessResponse;
import id.ten.forumservices.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Authentication", description = "Controller untuk manage Signup dan Signin")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController extends BaseController {
    private final AuthenticationService authenticationService;

    @Operation(summary = "Create new User")
    @ApiResponses({
        @ApiResponse(
                responseCode = "201",
                content = {
                    @Content(schema = @Schema(implementation = SuccessResponse.class), mediaType = "application/json")
                }),
        @ApiResponse(
                responseCode = "500",
                content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
                }),
    })
    @PostMapping("/signup")
    public ResponseEntity<SuccessResponse> signup(@RequestBody SignUpRequest request) throws MessagingException {
        return new ResponseEntity<>(
                contructSuccessResponse(
                        authenticationService.signup(request), "signup berhasil, silahkan cek email Anda"),
                HttpStatus.CREATED);
    }

    @Operation(summary = "Signin user")
    @ApiResponses({
        @ApiResponse(
                responseCode = "200",
                content = {
                    @Content(schema = @Schema(implementation = SuccessResponse.class), mediaType = "application/json")
                }),
        @ApiResponse(
                responseCode = "500",
                content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
                }),
    })
    @PostMapping("/signin")
    public ResponseEntity<SuccessResponse> signin(@RequestBody SigninRequest request) {
        return ResponseEntity.ok(contructSuccessResponse(authenticationService.signin(request), "Login Berhasil"));
    }

    @Operation(summary = "Signin user")
    @ApiResponses({
        @ApiResponse(
                responseCode = "200",
                content = {
                    @Content(schema = @Schema(implementation = SuccessResponse.class), mediaType = "application/json")
                }),
        @ApiResponse(
                responseCode = "500",
                content = {
                    @Content(schema = @Schema(implementation = ErrorResponse.class), mediaType = "application/json")
                }),
    })
    @PostMapping("/activation/{activation_code}")
    public ResponseEntity<SuccessResponse> activation(@PathVariable("activation_code") String activationCode) {
        return ResponseEntity.ok(
                contructSuccessResponse(authenticationService.activations(activationCode), "User telah aktif"));
    }
}
