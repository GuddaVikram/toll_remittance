package com.saas.app.toll.authentication.service.implementation;

import com.saas.app.toll.authentication.Repository.UserRepository;
import com.saas.app.toll.authentication.entity.User;
//import com.saas.app.toll.authentication.config.PasswordEncoder;
import com.saas.app.toll.authentication.models.RegistrationRequest;
import com.saas.app.toll.authentication.models.enums.UserRole;
import com.saas.app.toll.authentication.service.interfaces.UserRegistrationService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Getter
@Setter
@AllArgsConstructor
public class UserRegistrationImpl implements UserRegistrationService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Boolean register(RegistrationRequest registrationRequest) {

        User user = userRepository.findByEmail(registrationRequest.getEmail());

        if(user!=null){
            throw new IllegalStateException("email is already taken");
        }

        user = new User(
                registrationRequest.firstName + " " +registrationRequest.lastName,
                bCryptPasswordEncoder.encode(registrationRequest.password),
                registrationRequest.getEmail(),
                false,
                UserRole.USER
        );

        userRepository.save(user);

        return true;
    }
}
