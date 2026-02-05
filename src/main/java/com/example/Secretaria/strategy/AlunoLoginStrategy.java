package com.example.Secretaria.strategy;

import com.example.Secretaria.adapter.AlunoAdapter;
import com.example.Secretaria.dto.request.LoginRequest;
import com.example.Secretaria.dto.response.UserResponse;
import com.example.Secretaria.mapper.AlunoMapper;
import org.springframework.stereotype.Component;

@Component
public class AlunoLoginStrategy implements LoginStrategy {
    private final AlunoAdapter alunoAdapter;

    private final AlunoMapper alunoMapper;

    public AlunoLoginStrategy(AlunoAdapter alunoAdapter, AlunoMapper alunoMapper) {
        this.alunoAdapter = alunoAdapter;
        this.alunoMapper = alunoMapper;
    }

    @Override
    public UserResponse login(LoginRequest loginRequest) {
        var aluno = alunoAdapter.login(loginRequest.getCpf(), loginRequest.getPassword());
        return alunoMapper.convertToResponse(aluno);
    }


    @Override
    public boolean supports(String userType) {
        return userType.equalsIgnoreCase("Aluno");
    }
}
