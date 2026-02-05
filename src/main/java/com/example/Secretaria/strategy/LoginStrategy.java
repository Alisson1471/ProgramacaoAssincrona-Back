package com.example.Secretaria.strategy;

import com.example.Secretaria.dto.request.LoginRequest;
import com.example.Secretaria.dto.response.AlunoResponse;

public interface LoginStrategy {
    AlunoResponse login(LoginRequest loginRequest);
    boolean supports(String userType);
}
