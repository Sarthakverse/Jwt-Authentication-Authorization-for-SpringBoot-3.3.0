package com.securitygateway.loginandsignup.service;

import com.securitygateway.loginandsignup.constants.ApplicationConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class OtpService {
    String otpChar = ApplicationConstants.OTP_CHARACTERS;
    Integer otpLength = ApplicationConstants.OTP_LENGTH;

    public String generateOtp() {
        StringBuilder otp = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < otpLength; i++) {
            otp.append(otpChar.charAt(random.nextInt(otpChar.length())));
        }
        log.info("Generated OTP: {}", otp);
        return otp.toString();
    }

    @CachePut(value = "user", key = "#email")
    public String getOtpForEmail(String email) {
        return generateOtp();
    }
}
