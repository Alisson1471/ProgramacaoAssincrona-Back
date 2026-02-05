package com.example.Secretaria.strategy;

import com.example.Secretaria.adapter.ProfessorAdapter;
import com.example.Secretaria.dto.request.LoginRequest;
import com.example.Secretaria.dto.response.AlunoResponse;
import com.example.Secretaria.mapper.ProfessorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProfessorLoginStrategy implements LoginStrategy {

    private final ProfessorAdapter professorAdapter;

    private final ProfessorMapper professorMapper;

    @Override
    public AlunoResponse login(LoginRequest loginRequest) {
        var professor = professorAdapter.login(loginRequest.getCpf(), loginRequest.getPassword());
        return professorMapper.convertToResponse(professor);
    }

    @Override
    public boolean supports(String userType) {
        return userType.equalsIgnoreCase("Professor");
    }
}
