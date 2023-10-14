package com.saas.app.toll.authentication.service.interfaces;

import com.saas.app.toll.authentication.models.RegistrationRequest;

public interface UserRegistrationService {
    Boolean register(RegistrationRequest registrationRequest);
}
