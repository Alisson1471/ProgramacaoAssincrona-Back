package com.example.Secretaria.strategy;

import com.example.Secretaria.dto.request.AuthRequest;
import com.example.Secretaria.dto.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class AdminAuthStrategy implements AuthStrategy {

    public UserResponse login(AuthRequest authRequest) {
        return null;
    }

    public void updateSenha(AuthRequest authRequest) {

    }

    public boolean supports(String userType) {
        return userType.equalsIgnoreCase("ADMIN");
    }

}
