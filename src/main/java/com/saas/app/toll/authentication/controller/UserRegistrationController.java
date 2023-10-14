package com.saas.app.toll.authentication.controller;


import com.saas.app.toll.authentication.service.interfaces.UserRegistrationService;
import com.saas.app.toll.authentication.models.RegistrationRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@AllArgsConstructor
public class UserRegistrationController {

    @Autowired
    private UserRegistrationService userRegistrationService;
    @PostMapping("/register")
    public Boolean register(@Valid @RequestBody RegistrationRequest registrationRequest){
        return userRegistrationService.register(registrationRequest);
    }
}
