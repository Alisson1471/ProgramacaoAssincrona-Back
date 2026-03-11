package com.example.Secretaria.strategy;

import com.example.Secretaria.dto.request.AuthRequest;
import com.example.Secretaria.dto.request.UpdateRequest;
import com.example.Secretaria.dto.response.UserResponse;

public interface AuthStrategy {
    UserResponse login(AuthRequest authRequest);
    void updateSenha(UpdateRequest request);
    boolean supports(String userType);
}
