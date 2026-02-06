package com.example.Secretaria.mapper;

import com.example.Secretaria.dto.response.AlunoResponse;
import com.example.Secretaria.model.Aluno;
import org.springframework.stereotype.Component;

@Component
public class AlunoMapper {
    public AlunoResponse convertToResponse(Aluno aluno) {
        var alunoResponse = new AlunoResponse();
        alunoResponse.setId(aluno.getId());
        alunoResponse.setNome(aluno.getNome());
        alunoResponse.setCpf(aluno.getCpf());
        alunoResponse.setUsuario(aluno.getUsuario());
        alunoResponse.setSenha(aluno.getSenha());
        alunoResponse.setMatricula(aluno.getMatricula());

        return alunoResponse;
    }
}
