package com.example.Secretaria.strategy;

import com.example.Secretaria.dto.request.LoginRequest;

public interface LoginStrategy {
    String login(LoginRequest loginRequest);
    boolean supports(String userType);
}
