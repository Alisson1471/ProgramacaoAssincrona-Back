package com.example.Secretaria.strategy;

import com.example.Secretaria.dto.request.AuthRequest;
import com.example.Secretaria.dto.response.UserResponse;

public interface AuthStrategy {
    UserResponse login(AuthRequest authRequest);
    void updateSenha(AuthRequest authRequest);
    boolean supports(String userType);
}
