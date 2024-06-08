package com.securitygateway.loginandsignup.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Username {
    @NotBlank(message = "firstName can't be blank")
    @Column(nullable = false)
    private String firstName;

    @NotBlank(message = "Last name can't be blank")
    @Column(nullable = false)
    private String lastName;

    public String getFullName(){
        return String.format("%s %s",firstName,lastName);
    }
}
