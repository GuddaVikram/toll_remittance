package com.saas.app.toll.authentication.models;

import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RegistrationRequest {
    public String firstName;
    public String lastName;
    public String password;
    @Email(message = "Invalid Email Format")
    public String email;
}
