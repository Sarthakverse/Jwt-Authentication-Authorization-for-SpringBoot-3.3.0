package com.securitygateway.loginandsignup.service;

import com.securitygateway.loginandsignup.exceptions.ResourceNotFoundException;
import com.securitygateway.loginandsignup.model.User;
import com.securitygateway.loginandsignup.payload.responses.GeneralAPIResponse;
import com.securitygateway.loginandsignup.payload.responses.RefreshTokenResponse;
import com.securitygateway.loginandsignup.payload.responses.RegisterVerifyResponse;
import com.securitygateway.loginandsignup.repository.UserRepository;
import com.securitygateway.loginandsignup.security.JwtHelper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final JwtHelper jwtHelper;
    private final UserDetailsService userDetailsService;
    private final UserRepository userRepository;

    public RegisterVerifyResponse generateJwtToken(User user)
    {
         String myAccessToken = jwtHelper.generateAccessToken(user);
         String myRefreshToken = jwtHelper.generateRefreshToken(user);
         return RegisterVerifyResponse.builder()
                 .accessToken(myAccessToken)
                 .refreshToken(myRefreshToken)
                 .firstName(user.getName().getFirstName())
                 .lastName(user.getName().getLastName())
                 .email(user.getEmail())
                 .role(user.getRole())
                 .isVerified(user.getIsVerified())
                 .build();
    }

    public ResponseEntity<?> generateAccessTokenFromRefreshToken(String refreshToken) {
       if(refreshToken != null)
       {
           try
           {
               String username = jwtHelper.extractUsername(refreshToken);
               if(username.startsWith("#refresh"))
               {
                   String finalUserName = username.substring(8);
                   UserDetails userDetails = userDetailsService.loadUserByUsername(finalUserName);
                   User user = userRepository.findByEmail(finalUserName).orElseThrow(
                           ()-> new ResourceNotFoundException("User not found with email "+finalUserName)
                   );
                   if(jwtHelper.isRefreshTokenValid(refreshToken, userDetails))
                   {
                       String accessToken  = jwtHelper.generateAccessToken(userDetails);
                       return new ResponseEntity<>(RefreshTokenResponse.builder()
                               .accessToken(accessToken)
                               .firstName(user.getName().getFirstName())
                               .lastName(user.getName().getLastName())
                               .email(user.getEmail())
                               .role(user.getRole())
                               .build() , HttpStatus.OK);
                   }
                   else
                   {
                       return new ResponseEntity<>(GeneralAPIResponse.builder().message("Refresh token is expired").build() , HttpStatus.BAD_REQUEST);
                   }
               }
               else
               {
                   return new ResponseEntity<>(GeneralAPIResponse.builder().message("Invalid refresh token").build() , HttpStatus.BAD_REQUEST);
               }
           }
           catch(IllegalArgumentException | MalformedJwtException e)
              {
                return new ResponseEntity<>(GeneralAPIResponse.builder().message("Invalid refresh token").build() , HttpStatus.BAD_REQUEST);
              }
           catch(ResourceNotFoundException e)
           {
               return new ResponseEntity<>(GeneralAPIResponse.builder().message("User not found").build() , HttpStatus.NOT_FOUND);
           }
           catch(ExpiredJwtException e)
           {
                return new ResponseEntity<>(GeneralAPIResponse.builder().message("Refresh token is expired").build() , HttpStatus.BAD_REQUEST);
           }

       }
       else
       {
           return new ResponseEntity<>(GeneralAPIResponse.builder().message("Refresh token is null").build() , HttpStatus.BAD_REQUEST);
       }

    }

}
