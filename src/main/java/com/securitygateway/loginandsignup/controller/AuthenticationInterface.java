package com.securitygateway.loginandsignup.controller;

import com.securitygateway.loginandsignup.payload.requests.*;
import com.securitygateway.loginandsignup.payload.responses.*;
import com.securitygateway.loginandsignup.payload.responses.Error;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Authentication", description = "Authentication APIs")
public interface AuthenticationInterface {

    @Operation(summary = "Register a new user", description = "This API registers a new user if the user is not already present in the records, and sends an email to the user for verification.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User has been saved in records, but still needs to be verified",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RegisterResponse.class))),
            @ApiResponse(responseCode = "400", description = """
                Bad Request:
                - User already exists with this email and is verified.
                - Validation errors:
                  - First name can't be blank
                  - Last name can't be blank
                  - Invalid email entered
                  - Password must contain at least 8 characters, one uppercase, one lowercase and one number
                  - Please choose your gender
                  - Invalid phone number, please enter in the format +(code)XXXXXXXXXX
                  - Please choose a role
                - User already exists with this phone number. Please try again with a different phone number.
            """,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: Failed to send OTP email. Please try again later.",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Error.class)))
    })
    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest registerRequest);

    @Operation(summary = "Verify user registration", description = "This API verifies user registration using the provided OTP.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User registration verified successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RegisterVerifyResponse.class))),
            @ApiResponse(responseCode = "400", description = """
                Bad Request:
                - Email or OTP is incorrect
            """,
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneralAPIResponse.class))),
            @ApiResponse(responseCode = "408", description = "Request Timeout: OTP has expired",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneralAPIResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not Found: User with the specified email not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneralAPIResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: Failed to verify user registration",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneralAPIResponse.class)))
    })
    public ResponseEntity<?> verifyRegistration(@Valid @RequestBody RegisterVerifyRequest registerVerifyRequest);

    @Operation(summary = "Login user", description = "Authenticate and log in a user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User logged in successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RegisterVerifyResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request: Invalid credentials or user not verified",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneralAPIResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not Found: User with the specified email not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneralAPIResponse.class)))
    })
    public ResponseEntity<?> login(@Valid @RequestBody LoginRequest loginRequest);

    @Operation(summary = "Forgot password", description = "Send OTP to user's email for resetting password.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OTP sent successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneralAPIResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not Found: User with the specified email not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneralAPIResponse.class))),
            @ApiResponse(responseCode = "429", description = "Too Many Requests: OTP already sent recently, wait for 2 minutes before trying again",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneralAPIResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error: Failed to send OTP email",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneralAPIResponse.class)))
    })
    public ResponseEntity<?> forgotPassword(@Valid @RequestBody ForgotPasswordRequest forgotPasswordRequest);

    @Operation(summary = "Verify OTP", description = "Verify the OTP provided by the user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OTP verified successfully, now you can change the password",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneralAPIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request: Incorrect OTP entered",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneralAPIResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not Found: User with the specified email not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneralAPIResponse.class))),
            @ApiResponse(responseCode = "408", description = "Request Timeout: OTP has expired",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneralAPIResponse.class)))
    })
    public ResponseEntity<?> verifyOtp(@Valid @RequestBody RegisterVerifyRequest registerVerifyRequest);

    @Operation(summary = "Reset Password", description = "Reset the password for the user.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Password has been reset successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneralAPIResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request: Password and confirm password do not match",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneralAPIResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not Found: User with the specified email not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneralAPIResponse.class)))
    })
    public ResponseEntity<?> resetPassword(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest);

    @Operation(summary = "Refresh Token", description = "Generate a new access token from a refresh token.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK: Access token generated successfully",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = RefreshTokenResponse.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request: Invalid refresh token or refresh token expired",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneralAPIResponse.class))),
            @ApiResponse(responseCode = "404", description = "Not Found: User not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = GeneralAPIResponse.class)))
    })
    public ResponseEntity<?> refreshToken(@RequestParam(name = "refreshToken") String refreshToken);
}
