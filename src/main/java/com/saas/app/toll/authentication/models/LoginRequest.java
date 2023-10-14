package com.saas.app.toll.authentication.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginRequest {

    @Email(message = "email should be in valid format")
    @NotNull(message = "email is mandatory")
    public String email;

    @NotNull(message = "password is mandatory")
    public String password;
}
