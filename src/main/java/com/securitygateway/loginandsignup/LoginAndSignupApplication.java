package com.securitygateway.loginandsignup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableCaching
@EnableAsync
@EnableRetry
public class LoginAndSignupApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginAndSignupApplication.class, args);
    }

}
