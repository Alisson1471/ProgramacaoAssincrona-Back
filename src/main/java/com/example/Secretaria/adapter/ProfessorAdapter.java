package com.example.Secretaria.adapter;

import com.example.Secretaria.model.Professor;
import com.example.Secretaria.repository.ProfessorRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProfessorAdapter {

    private final ProfessorRepository professorRepository;

    public Professor login(String cpf, String password) {
        var professor = professorRepository.findByCpfAndSenha(cpf, password);

        if (professor.isEmpty()) {
            throw new EntityNotFoundException("Professor não encontrado!");
        }

        return professor.get();
    }
}
