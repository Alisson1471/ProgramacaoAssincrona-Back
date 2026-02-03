package com.example.Secretaria.service;

import com.example.Secretaria.dto.request.LoginRequest;
import com.example.Secretaria.dto.response.UserResponse;
import com.example.Secretaria.factory.LoginStrategyFactory;
import com.example.Secretaria.strategy.LoginStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoginService {

    private final LoginStrategyFactory factory;

    public UserResponse login(LoginRequest loginRequest) {
        LoginStrategy strategy = factory.getStrategy(loginRequest.getUserType());
        return strategy.login(loginRequest);
    }

}
