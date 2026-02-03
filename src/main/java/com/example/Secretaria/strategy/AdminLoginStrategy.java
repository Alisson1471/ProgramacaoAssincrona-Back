package com.example.Secretaria.strategy;

import com.example.Secretaria.dto.request.LoginRequest;
import com.example.Secretaria.dto.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class AdminLoginStrategy implements LoginStrategy {

    public UserResponse login(LoginRequest loginRequest) {
        return null;
    }

    public boolean supports(String userType) {
        return userType.equalsIgnoreCase("ADMIN");
    }

}
