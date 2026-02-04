package com.example.Secretaria.adapter;

import com.example.Secretaria.model.Aluno;
import com.example.Secretaria.repository.AlunoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlunoAdapter {

    private final AlunoRepository alunoRepository;

    public Aluno login(String cpf, String password) {
        var aluno = alunoRepository.findByCpfAndSenha(cpf, password);

        if (aluno.isEmpty()) {
            throw new EntityNotFoundException("Aluno não encontrado!");
        }

        return aluno.get();
    }
}
