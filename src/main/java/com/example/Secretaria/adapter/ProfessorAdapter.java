package com.example.Secretaria.adapter;

import com.example.Secretaria.model.Professor;
import com.example.Secretaria.repository.ProfessorRepository;
import com.example.Secretaria.utils.CryptService;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProfessorAdapter {

    private final ProfessorRepository professorRepository;
    private final CryptService cryptService;

    public Professor login(String cpf, String password) {
        var professor = professorRepository.findByCpf(cpf)
        .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado"));

        if (!cryptService.matches(password, professor.getSenha())) {
            throw new BadCredentialsException("Senha inválida");
        }
        return professor;
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

    public void save(Professor professor) {

        professorRepository.save(professor);
    }
}
