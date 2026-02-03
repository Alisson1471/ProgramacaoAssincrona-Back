package com.example.Secretaria.strategy;

import com.example.Secretaria.dto.request.LoginRequest;
import com.example.Secretaria.dto.response.UserResponse;

public interface LoginStrategy {
    UserResponse login(LoginRequest loginRequest);
    boolean supports(String userType);
}
