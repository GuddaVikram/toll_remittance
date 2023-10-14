package com.saas.app.toll.authentication.service.interfaces;

import com.saas.app.toll.authentication.models.LoginRequest;

public interface UserLoginService {
    String userLogin(LoginRequest loginRequest);
}
