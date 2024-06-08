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
<a id="built-with"></a>
### Built With

* [![Springboot][Spring.io]][Springboot-url]
* [![JWT][JWT.io]][JWT-url]
* [![CaffeineCache](https://img.shields.io/badge/Cache-Caffeine-blue)](https://caffeine.gitbook.io)
* [![Swagger](https://img.shields.io/badge/API-Swagger-brightgreen)](https://swagger.io)
* [![Spring Security](https://img.shields.io/badge/Security-Spring-green)](https://spring.io/projects/spring-security)
* [![Java Mail Sender](https://img.shields.io/badge/Mail-Java%20Mail%20Sender-blue)](https://javaee.github.io/javamail/)
* ![Cron Job](https://img.shields.io/badge/Cron%20Job-Scheduled%20Task-orange)




## Hosted Url
To use the REST_APIs use this url
```bash
  https://jwt-authentication-authorization-for.onrender.com/
```
## Importatant Depenedencies used in project
  - `spring-boot-starter-web`
  - `spring-boot-starter-data-jpa`
  - `spring-boot-starter-mail`
  - `spring-boot-starter-security`
  - `spring-boot-starter-validation`
  - `springdoc-openapi-starter-webmvc-ui`
  - `postgresql`
  - `lombok`
  - `spring-retry`
  - `jjwt`
  - `jjwt-impl`
  - `jjwt-api`
  - `spring-boot-starter-cache`
  - `caffeine`

## Project Roadmap

### 1. Set Up the Environment
- **Install JDK 17**
  - Download from the official [Oracle JDK website](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- **Install an IDE**
  - Download and install IntelliJ IDEA or Eclipse
  - Configure IDE for Java 17
  - Install necessary plugins for Spring Boot development
### Clone the repo
   ```sh
   git clone https://github.com/Sarthakverse/Jwt-Authentication-Authorization-for-SpringBoot-3.3.1.git
   ```
### Open the cloned folder using STS, IntelliJ Idea or any other IDE, and it will auto download all the configuration files.
### Run the project, the base URL for the project will be
   ```sh
   http://localhost:8080/
   ```
### Get the documentation for the various APIs at the following link
   ```sh
   http://localhost:8080/swagger-ui/index.html
   ```
   Get the postman collection at the following link
   ```sh
   https://crimson-flare-571775.postman.co/workspace/Green-Stitch~dcfa712e-5f25-40e2-aedf-60b0e52bcca6/collection/24017701-6dfd191f-0f0c-46c0-a63c-d71dde765b9e?action=share&creator=24017701
   ```
## Some ScreenShots
![image](https://github.com/Sarthakverse/Jwt-Authentication-Authorization-for-SpringBoot-3.3.1/assets/117356021/41222f5a-2fde-4957-9136-a42afd5c4053)
![image](https://github.com/Sarthakverse/Jwt-Authentication-Authorization-for-SpringBoot-3.3.1/assets/117356021/e3254745-85f2-4950-a348-26be68096e1e)
![image](https://github.com/Sarthakverse/Jwt-Authentication-Authorization-for-SpringBoot-3.3.1/assets/117356021/d34badea-b925-400c-80a3-b309f6a923ef)
![image](https://github.com/Sarthakverse/Jwt-Authentication-Authorization-for-SpringBoot-3.3.1/assets/117356021/99a90f98-ad2a-4142-b169-6d06ccd2535a)
![image](https://github.com/Sarthakverse/Jwt-Authentication-Authorization-for-SpringBoot-3.3.1/assets/117356021/4ab2b123-cc23-4b4c-82ee-f762e25eea50)


<a id="contributing"></a>
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request
<h1>Contact Information</h1>
<ul class="contact-info">
<li><strong>Email:</strong> <a href="mailto:sarthak2210047@akgec.ac.in">sarthak2210047@akgec.ac.in</a></li>
<li><strong>GitHub:</strong> <a href="https://github.com/Sarthakverse" target="_blank">https://github.com/your-github-profile</a></li>
<li><strong>LinkedIn:</strong> <a href="https://www.linkedin.com/in/sarthak-rastogi-47bb11256/" target="_blank">https://www.linkedin.com/in/sarthak-rastogi-47bb11256//</a></li>
<li><strong>Phone:</strong> +(91) 8303913426</li>
</ul>
   



[Spring.io]: https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot
[Springboot-url]: https://spring.io/
[JWT.io]: https://img.shields.io/badge/JWT-black?style=for-the-badge&logo=JSON%20web%20tokens
[JWT-url]: https://jwt.io/











