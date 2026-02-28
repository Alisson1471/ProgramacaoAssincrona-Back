package com.example.Secretaria;

import com.example.Secretaria.model.Disciplina;
import com.example.Secretaria.repository.DisciplinaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DisciplinaAdapter {

    private final DisciplinaRepository disciplinaRepository;

    public Disciplina findByName(String name) {
        var disciplina = disciplinaRepository.findByNome(name);

        if (disciplina.isEmpty()) {
            throw new EntityNotFoundException("Disciplina não encontrada.");
        }

        return disciplina.get();
    }

}
