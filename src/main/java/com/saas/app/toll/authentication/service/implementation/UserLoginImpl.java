package com.saas.app.toll.authentication.service.implementation;

import com.saas.app.toll.authentication.config.JwtUtils;
import com.saas.app.toll.authentication.entity.User;
import com.saas.app.toll.authentication.models.LoginRequest;
import com.saas.app.toll.authentication.service.interfaces.UserLoginService;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserLoginImpl implements UserLoginService {
    private final AuthenticationManager authenticationManager;
    private final AppUserService appUserService;
    private final JwtUtils jwtUtils;
    @Override
    public String userLogin(@NotNull LoginRequest loginRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),loginRequest.getPassword())
        );
        UserDetails user =  appUserService.loadUserByUsername(loginRequest.getEmail());
        if(user!=null)
        {
            return jwtUtils.generateToken(user);
        }
        return "error";
    }
}
