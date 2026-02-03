package com.example.Secretaria.strategy;

import com.example.Secretaria.dto.request.LoginRequest;
import org.springframework.stereotype.Component;

@Component
public class AdminLoginStrategy implements LoginStrategy {

    public String login(LoginRequest loginRequest) {
        return "admin bolado!";
    }

    public boolean supports(String userType) {
        return userType.equalsIgnoreCase("ADMIN");
    }

}
