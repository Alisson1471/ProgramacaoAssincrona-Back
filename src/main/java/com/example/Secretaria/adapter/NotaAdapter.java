package com.example.Secretaria.adapter;

import com.example.Secretaria.model.Nota;
import com.example.Secretaria.repository.NotaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class NotaAdapter {

    private final NotaRepository notaRepository;

    public Nota save(Nota nota) {
        return notaRepository.save(nota);
    }

    public Nota findById(Integer id) {
        var nota = notaRepository.findById(id);

        if (nota.isEmpty()) {
            throw new EntityNotFoundException("Nota não encontrado!");
        }

        return nota.get();
    }

}
