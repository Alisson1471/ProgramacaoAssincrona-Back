package com.example.Secretaria.strategy;

import com.example.Secretaria.adapter.AlunoAdapter;
import com.example.Secretaria.dto.request.LoginRequest;
import com.example.Secretaria.dto.response.AlunoResponse;
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
    public AlunoResponse login(LoginRequest loginRequest) {
        var professor = alunoAdapter.login(loginRequest.getCpf(), loginRequest.getPassword());
        return alunoMapper.convertToResponse(professor);
    }

    @Override
    public boolean supports(String userType) {
        return userType.equalsIgnoreCase("Aluno");
    }
}
