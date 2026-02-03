package com.example.Secretaria.controller;

import com.example.Secretaria.dto.request.LoginRequest;
import com.example.Secretaria.dto.response.UserResponse;
import com.example.Secretaria.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(name = "/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest loginRequest) {
        return ResponseEntity.status(200).body(loginService.login(loginRequest));
    }

}
