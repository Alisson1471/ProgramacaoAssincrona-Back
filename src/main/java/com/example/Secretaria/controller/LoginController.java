package com.example.Secretaria.controller;

import com.example.Secretaria.dto.request.LoginRequest;
import com.example.Secretaria.dto.response.UserResponse;
import com.example.Secretaria.factory.LoginStrategyFactory;
import com.example.Secretaria.strategy.LoginStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(name = "/login")
public class LoginController {

    private final LoginStrategyFactory factory;

    @PostMapping
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginRequest) {
        LoginStrategy strategy = factory.getStrategy(loginRequest.getUserType());
        strategy.login(loginRequest);
        return ResponseEntity.status(200).body(strategy.login(loginRequest));
    }

    @PatchMapping
    public void updateSenha(@RequestBody LoginRequest loginRequest) {
        LoginStrategy strategy = factory.getStrategy(loginRequest.getUserType());
        strategy.updateSenha(loginRequest);
    }

}
