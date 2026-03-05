package com.example.Secretaria.strategy;

import com.example.Secretaria.adapter.ProfessorAdapter;
import com.example.Secretaria.dto.request.AuthRequest;
import com.example.Secretaria.dto.response.UserResponse;
import com.example.Secretaria.mapper.ProfessorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProfessorAuthStrategy implements AuthStrategy {

    private final ProfessorAdapter professorAdapter;

    private final ProfessorMapper professorMapper;

    @Override
    public UserResponse login(AuthRequest authRequest) {
        var professor = professorAdapter.login(authRequest.getCpf(), authRequest.getPassword());
        return professorMapper.convertToResponse(professor);
    }

    @Override
    public void updateSenha(AuthRequest authRequest) {
        return;
    }

    @Override
    public boolean supports(String userType) {
        return userType.equalsIgnoreCase("Professor");
    }
}
