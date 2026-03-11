package com.example.Secretaria.strategy;

import com.example.Secretaria.adapter.AlunoAdapter;
import com.example.Secretaria.dto.request.AuthRequest;
import com.example.Secretaria.dto.request.UpdateRequest;
import com.example.Secretaria.dto.response.UserResponse;
import com.example.Secretaria.mapper.AlunoMapper;
import com.example.Secretaria.utils.CryptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlunoAuthStrategy implements AuthStrategy {

    private final AlunoAdapter alunoAdapter;
    private final CryptService cryptService;
    private final AlunoMapper alunoMapper;
    @Override
    public UserResponse login(AuthRequest authRequest) {
        var aluno = alunoAdapter.login(authRequest.getCpf(), authRequest.getPassword());
        return alunoMapper.convertToResponse(aluno);
    }

    @Override
    public void updateSenha(UpdateRequest request) {
        var aluno = alunoAdapter.login(request.getCpf(), request.getPassword());
        aluno.setSenha(cryptService.crypt(request.getNewPassword()));
        alunoAdapter.salvar(aluno);
    }

    @Override
    public boolean supports(String userType) {
        return userType.equalsIgnoreCase("Aluno");
    }
}
