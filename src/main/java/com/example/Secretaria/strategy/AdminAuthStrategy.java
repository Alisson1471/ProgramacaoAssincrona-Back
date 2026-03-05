package com.example.Secretaria.strategy;

import com.example.Secretaria.adapter.AdminAdapter;
import com.example.Secretaria.dto.request.AuthRequest;
import com.example.Secretaria.dto.response.UserResponse;
import com.example.Secretaria.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AdminAuthStrategy implements AuthStrategy {

    private final AdminAdapter adminAdapter;

    private final AdminMapper adminMapper;

    @Override
    public UserResponse login(AuthRequest loginRequest) {
        var admin = adminAdapter.login(loginRequest.getCpf(), loginRequest.getPassword());
        return adminMapper.convertToResponse(admin);
    }

    public void updateSenha(AuthRequest authRequest) {

    }

    @Override
    public boolean supports(String userType) {
        return userType.equalsIgnoreCase("Admin");
    }

}
