package com.example.Secretaria.strategy;

import com.example.Secretaria.adapter.AlunoAdapter;
import com.example.Secretaria.dto.request.AuthRequest;
import com.example.Secretaria.dto.response.UserResponse;
import com.example.Secretaria.mapper.AlunoMapper;
import org.springframework.stereotype.Component;

@Component
public class AlunoAuthStrategy implements AuthStrategy {
    private final AlunoAdapter alunoAdapter;

    private final AlunoMapper alunoMapper;

    public AlunoAuthStrategy(AlunoAdapter alunoAdapter, AlunoMapper alunoMapper) {
        this.alunoAdapter = alunoAdapter;
        this.alunoMapper = alunoMapper;
    }

    @Override
    public UserResponse login(AuthRequest authRequest) {
        var aluno = alunoAdapter.login(authRequest.getCpf(), authRequest.getPassword());
        return alunoMapper.convertToResponse(aluno);
    }

    @Override
    public void updateSenha(AuthRequest authRequest) {

    }

    @Override
    public boolean supports(String userType) {
        return userType.equalsIgnoreCase("Aluno");
    }
}
