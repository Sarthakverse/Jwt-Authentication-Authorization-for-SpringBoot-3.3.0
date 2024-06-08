package com.securitygateway.loginandsignup.payload.responses;

import com.securitygateway.loginandsignup.model.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterVerifyResponse {
    private String accessToken ;
    private String refreshToken ;
    private String firstName ;
    private String lastName ;
    private String email ;
    private Role role;
    private boolean isVerified;
}
