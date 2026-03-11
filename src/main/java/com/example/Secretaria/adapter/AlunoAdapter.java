package com.example.Secretaria.adapter;

import com.example.Secretaria.model.Aluno;
import com.example.Secretaria.repository.AlunoRepository;
import com.example.Secretaria.utils.CryptService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlunoAdapter {

    private final AlunoRepository alunoRepository;

    private final CryptService cryptService;

    public Aluno login(String cpf, String password) {
        var aluno = alunoRepository.findByCpf(cpf)
        .orElseThrow(() -> new EntityNotFoundException("Aluno não encontrado"));

        if (!cryptService.matches(password, aluno.getSenha())){
            throw new BadCredentialsException("Senha inválida");
        }
        return aluno;
    }

    public Aluno findById(int id) {
        var aluno = alunoRepository.findById(id);

        if (aluno.isEmpty()) {
            throw new EntityNotFoundException("Aluno não encontrado!");
        }

        return aluno.get();
    }

    public void salvar(Aluno aluno) {
        alunoRepository.save(aluno);
    }
}
