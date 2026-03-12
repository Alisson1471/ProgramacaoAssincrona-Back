package com.example.Secretaria.controller;

import com.example.Secretaria.dto.request.AuthRequest;
import com.example.Secretaria.dto.request.UpdateRequest;
import com.example.Secretaria.dto.response.UserResponse;
import com.example.Secretaria.factory.AuthStrategyFactory;
import com.example.Secretaria.strategy.AuthStrategy;
import com.example.Secretaria.swgger.AuthControllerDocs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController implements AuthControllerDocs {

    private final AuthStrategyFactory factory;

    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody AuthRequest authRequest) {
        AuthStrategy strategy = factory.getStrategy(authRequest.getUserType());
        return ResponseEntity.status(200).body(strategy.login(authRequest));
    }

    @PatchMapping("/update-password")
    public ResponseEntity<Void> updateSenha(@RequestBody UpdateRequest request) {
        AuthStrategy strategy = factory.getStrategy(request.getUserType());
        strategy.updateSenha(request);
        return ResponseEntity.noContent().build();
    }

}
