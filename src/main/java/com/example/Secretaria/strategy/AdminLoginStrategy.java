package com.example.Secretaria.strategy;

import com.example.Secretaria.adapter.AdminAdapter;
import com.example.Secretaria.dto.request.LoginRequest;
import com.example.Secretaria.dto.response.UserResponse;
import com.example.Secretaria.mapper.AdminMapper;
import org.springframework.stereotype.Component;

@Component
public class AdminLoginStrategy implements LoginStrategy {

    private final AdminAdapter adminAdapter;

    private final AdminMapper adminMapper;

    public AdminLoginStrategy(AdminAdapter adminAdapter, AdminMapper adminMapper) {
        this.adminAdapter = adminAdapter;
        this.adminMapper = adminMapper;
    }

    @Override
    public UserResponse login(LoginRequest loginRequest) {
        var aluno = adminAdapter.login(loginRequest.getCpf(), loginRequest.getPassword());
        return adminMapper.convertToResponse(aluno);
    }

    @Override
    public void updateSenha(LoginRequest loginRequest) {

    }

    @Override
    public boolean supports(String userType) {
        return userType.equalsIgnoreCase("Admin");
    }


}
