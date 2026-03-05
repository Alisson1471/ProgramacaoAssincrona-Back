package com.example.Secretaria.controller;

import com.example.Secretaria.dto.request.AuthRequest;
import com.example.Secretaria.dto.response.UserResponse;
import com.example.Secretaria.factory.AuthStrategyFactory;
import com.example.Secretaria.strategy.AuthStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(name = "/login")
public class AuthController {

    private final AuthStrategyFactory factory;

    @PostMapping
    public ResponseEntity<UserResponse> login(@RequestBody AuthRequest authRequest) {
        AuthStrategy strategy = factory.getStrategy(authRequest.getUserType());
        return ResponseEntity.status(200).body(strategy.login(authRequest));
    }

    @PatchMapping
    public void updateSenha(@RequestBody AuthRequest authRequest) {
        AuthStrategy strategy = factory.getStrategy(authRequest.getUserType());
        strategy.updateSenha(authRequest);
    }

}
