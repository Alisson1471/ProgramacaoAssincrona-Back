package com.example.Secretaria.adapter;

import com.example.Secretaria.model.Professor;
import com.example.Secretaria.repository.ProfessorRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProfessorAdapter {

    private final ProfessorRepository professorRepository;

    public Professor login(String cpf, String password) {
        var professor = professorRepository.findByCpfAndSenha(cpf, password);

        if (professor.isEmpty()) {
            throw new EntityNotFoundException("Professor não encontrado.");
        }

        return professor.get();
    }

    public List<Professor> findAll() {
        var list = professorRepository.findAll();

        if (list.isEmpty()) {
            throw new EntityNotFoundException("Professores não encontrados.");
        }

        return list;
    }

    public Professor findById(int id) {
        var professor = professorRepository.findById(id);

        if (professor.isEmpty()) {
            throw new EntityNotFoundException("Professor não encontrado!");
        }

        return professor.get();
    }

    public void verifyExists(String cpf) {
        var professor = professorRepository.findByCpf(cpf);

        if (professor.isPresent()) {
            throw new EntityExistsException("Professor já existente.");
        }
    }

    public void create(Professor professor) {
        professorRepository.save(professor);
    }
}
