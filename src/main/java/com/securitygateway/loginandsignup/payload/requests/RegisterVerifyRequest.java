package com.securitygateway.loginandsignup.payload.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterVerifyRequest {
    @NotBlank(message = "Email can't be blank")
    @Email(message = "enter a valid email")
    private String email;
    @NotBlank(message = "OTP can't be blank")
    @Size(min = 6, max = 6, message = "OTP must be 6 characters long")
    private String otp;
}
