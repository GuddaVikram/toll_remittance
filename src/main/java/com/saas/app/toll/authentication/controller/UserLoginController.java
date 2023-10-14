package com.saas.app.toll.authentication.controller;

import com.saas.app.toll.authentication.models.LoginRequest;
import com.saas.app.toll.authentication.service.interfaces.UserLoginService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
public class UserLoginController {

    private final UserLoginService userLoginService;

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@Valid @RequestBody LoginRequest loginRequest){
        return ResponseEntity.ok(userLoginService.userLogin(loginRequest));
    }

}
