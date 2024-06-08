![LoginSignupLogo](https://github.com/Sarthakverse/Jwt-Authentication-Authorization-for-SpringBoot-3.3.1/assets/117356021/bf5b6453-8614-4799-8753-c10edfe815a4)

# Registration and Login
- This backend application, developed using Spring Boot 3.3.0 and Spring Security 6.X.X.
- implements a role-based (User/Admin) registration and login system.
- It leverages Caffeine cache for storing OTPs sent via email for verification purposes.
- Upon successful registration, the application generates JWT tokens: an access token (valid for 1 hour) and a refresh token (valid for 30 days).
- These tokens are used to authorize users, ensuring that only verified users with valid tokens can access certain endpoints outside of the "/api/v1/auth/**" path.
- To enhance reliability, a retry mechanism is implemented for email sending, which attempts to resend the OTP up to two more times in case of a system failure.
- Additionally, the application includes robust validation checks, ensuring that request bodies meet the required criteria.
## Demo and Documentation
- [Demo video](https://youtu.be/_5enBVGXVXs)
- [Postman Documentation](https://documenter.getpostman.com/view/29367403/2sA3XJnQvU#9e002b3b-973d-48cc-b006-28765454f76d)
- [Swagger Documentation](https://jwt-authentication-authorization-for.onrender.com/swagger-ui/index.html)
## Hosted Url
To use the REST_APIs use this url
```bash
  https://jwt-authentication-authorization-for.onrender.com/
```




